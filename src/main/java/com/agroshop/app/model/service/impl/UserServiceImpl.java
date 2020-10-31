package com.agroshop.app.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.beans.UserBean;
import com.agroshop.app.model.entities.ProfileEntity;
import com.agroshop.app.model.entities.UserEntity;
import com.agroshop.app.model.repository.IUserRepository;
import com.agroshop.app.model.service.IClientService;
import com.agroshop.app.model.service.IDriverService;
import com.agroshop.app.model.service.IFarmerService;
import com.agroshop.app.model.service.IProfileService;
import com.agroshop.app.model.service.IUserService;
import com.agroshop.app.util.Constants;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private PasswordEncoder  bcrypt;
	@Autowired
	private IProfileService profileService;
	
	@Override
	public List<UserEntity> getAll() {
		return userRepo.findAll();
	}

	@Override
	public UserEntity getOneById(Integer id) {
		return userRepo.findById(id).orElse(new UserEntity());
	}

	@Override
	public UserEntity save(UserEntity t) {
		return userRepo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		userRepo.deleteById(id);
	}

	@Override
	public boolean register(UserEntity user) {
		try {
			user.setPassword(bcrypt.encode(user.getPassword()));
			ProfileEntity profileSelect =profileService.findProfileByName(user.getTypeUser());
			user.setProfile(new ProfileEntity());
			user.setProfile(profileSelect);
			user.setStatus(Constants.STATUS_OFF_ENTITY);
			userRepo.save(user);
			return true;
		}catch(Exception e) {
			return false;
			
		}
	}

}

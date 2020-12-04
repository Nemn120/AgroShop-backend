package com.agroshop.app.model.service.impl;


import java.util.ArrayList;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.DTO.RegisterDTO;
import com.agroshop.app.model.entities.ClientEntity;
import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.entities.FarmerEntity;
import com.agroshop.app.model.entities.ProfileEntity;
import com.agroshop.app.model.entities.UserEntity;
import com.agroshop.app.model.repository.IUserRepository;
import com.agroshop.app.model.service.IClientService;
import com.agroshop.app.model.service.IDriverService;
import com.agroshop.app.model.service.IFarmerService;
import com.agroshop.app.model.service.IProfileService;
import com.agroshop.app.model.service.IUserService;
import com.agroshop.app.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServiceImpl implements IUserService{
	

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);	

	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private PasswordEncoder  bcrypt;
	@Autowired
	private IProfileService profileService;
	
	@Autowired
	private IFarmerService farmerService;
	
	@Autowired
	private IDriverService driverService;
	
	@Autowired
	private IClientService clientService;
	
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
	public UserEntity  register(UserEntity user) throws Throwable {
		List<UserEntity> u = userRepo.getUserByUsername(user.getUsername());
		if(u.size() >0)
			throw new RuntimeException(Constants.USERNAME_DUPLICATE);
		user.setPassword(bcrypt.encode(user.getPassword()));
		ProfileEntity profileSelect =profileService.findProfileByName(user.getTypeUser());
		user.setProfile(new ProfileEntity());
		user.setProfile(profileSelect);
		return userRepo.save(user);
	}



	@Override
	public Object getTypeUserByUsernameAndType(String username, String type) {
		if(Constants.USER_TYPE_FARMER.equals(type)){
			return farmerService.getUserByUsername(username);
		}
		if(Constants.USER_TYPE_DRIVER.equals(type)){				
			return driverService.getUserByUsername(username);
		}
		if(Constants.USER_TYPE_CLIENT.equals(type)){
			return clientService.getUserByUsername(username);
		}
		return null;
	}

	@Override
	public Object registerUserByTypeUser(RegisterDTO registerUser)  throws Throwable {
		ObjectMapper objectMapper = new ObjectMapper();
			if(Constants.USER_TYPE_FARMER.equals(registerUser.getUserType())){
				FarmerEntity userFarmer =objectMapper.convertValue(registerUser.getUserRegister(),FarmerEntity.class);
				
				return this.farmerService.register(userFarmer);
			}
			if(Constants.USER_TYPE_DRIVER.equals(registerUser.getUserType())){				
				DriverEntity userDriver=objectMapper.convertValue(registerUser.getUserRegister(),DriverEntity.class);
				return this.driverService.register(userDriver);
				
			}
			if(Constants.USER_TYPE_CLIENT.equals(registerUser.getUserType())){
				ClientEntity userClient =objectMapper.convertValue(registerUser.getUserRegister(),ClientEntity.class);
				return this.clientService.register(userClient);
			}
		
		return null;
	}

	@Override
	public UserEntity getUserByUsername(String username) throws Throwable {
		return this.userRepo.findOneByUsername(username);
	}
	

}

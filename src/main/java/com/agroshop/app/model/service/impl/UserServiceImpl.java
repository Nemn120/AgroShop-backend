package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.ProfileEntity;
import com.agroshop.app.model.entities.UserEntity;
import com.agroshop.app.model.repository.IUserRepository;
import com.agroshop.app.model.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository userRepo;
	
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

}

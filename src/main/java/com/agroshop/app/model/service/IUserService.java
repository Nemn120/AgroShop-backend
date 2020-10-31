package com.agroshop.app.model.service;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.beans.UserBean;
import com.agroshop.app.model.entities.UserEntity;

@Service
public interface IUserService extends GenericCRUD<UserEntity, Integer>{
	
	public boolean register(UserEntity user);
	
}

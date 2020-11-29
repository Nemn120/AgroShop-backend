
package com.agroshop.app.model.service;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.DTO.RegisterDTO;
import com.agroshop.app.model.entities.UserEntity;

@Service
public interface IUserService extends GenericCRUD<UserEntity, Integer>{

	
	UserEntity register(UserEntity user)  throws Throwable;
	
	Object getTypeUserByUsernameAndType(String username,String type);
	
	Object registerUserByTypeUser(RegisterDTO user)  throws Throwable;
	UserEntity getUserByUsername(String username)   throws Throwable;
	
}
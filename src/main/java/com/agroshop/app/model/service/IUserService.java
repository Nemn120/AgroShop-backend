package com.agroshop.app.model.service;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.DTO.RegisterDTO;
import com.agroshop.app.model.entities.UserEntity;

@Service
public interface IUserService extends GenericCRUD<UserEntity, Integer>{

	Boolean acceptUser(Integer id); 
	UserEntity register(UserEntity user);
	
	Object getTypeUserByUsernameAndType(String username,String type);
	
	Object registerUserByTypeUser(RegisterDTO user);
	
	
	
}

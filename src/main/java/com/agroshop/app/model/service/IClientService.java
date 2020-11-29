package com.agroshop.app.model.service;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.ClientEntity;
import com.agroshop.app.model.entities.FarmerEntity;

@Service
public interface IClientService extends GenericCRUD<ClientEntity, Integer>{
	ClientEntity register(ClientEntity client) throws Throwable; 
	ClientEntity getUserByUsername(String username);	
}

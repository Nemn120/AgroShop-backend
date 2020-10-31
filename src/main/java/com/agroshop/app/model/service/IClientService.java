package com.agroshop.app.model.service;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.ClientEntity;

@Service
public interface IClientService extends GenericCRUD<ClientEntity, Integer>{
	ClientEntity register(ClientEntity client); 
}

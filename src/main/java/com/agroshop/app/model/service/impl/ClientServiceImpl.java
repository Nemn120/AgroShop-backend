package com.agroshop.app.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agroshop.app.model.entities.ClientEntity;
import com.agroshop.app.model.entities.UserEntity;
import com.agroshop.app.model.repository.IClientRepository;
import com.agroshop.app.model.service.IClientService;
import com.agroshop.app.model.service.IUserService;
import com.agroshop.app.util.Constants;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	private IClientRepository clientRepository;
	
	@Autowired
	private IUserService userService;
	
	@Override
	public List<ClientEntity> getAll() {
		return clientRepository.findAll();
	}

	@Override
	public ClientEntity getOneById(Integer id) {
		return clientRepository.findById(id).orElse(new ClientEntity());
	}

	@Override
	public ClientEntity save(ClientEntity t) {
		return clientRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		clientRepository.deleteById(id);
	}

	@Override
	public ClientEntity register(ClientEntity client) {
		client.getUser().setTypeUser(Constants.USER_TYPE_CLIENT);
		client.setUser(this.userService.register(client.getUser()));
		return this.save(client);   
	}

	@Override
	public ClientEntity getUserByUsername(String username) {
		return this.clientRepository.getUserByUsername(username);
	}

}

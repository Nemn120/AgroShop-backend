package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agroshop.app.model.entities.ClientEntity;
import com.agroshop.app.model.repository.IClientRepository;
import com.agroshop.app.model.service.IClientService;

@Service
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	private IClientRepository clientRepository;
	
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

}

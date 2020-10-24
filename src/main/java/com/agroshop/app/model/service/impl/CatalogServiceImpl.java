package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.CatalogEntity;
import com.agroshop.app.model.repository.ICatalogRepository;
import com.agroshop.app.model.service.ICatalogService;

@Service
public class CatalogServiceImpl implements ICatalogService{
	
	@Autowired
	private ICatalogRepository catalogRepo;
	
	@Override
	public List<CatalogEntity> getAll() {
		return catalogRepo.findAll();
	}

	@Override
	public CatalogEntity getOneById(Integer id) {
		return catalogRepo.getOne(id);
	}

	@Override
	public CatalogEntity save(CatalogEntity t) {
		return catalogRepo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		catalogRepo.deleteById(id);
	}

}

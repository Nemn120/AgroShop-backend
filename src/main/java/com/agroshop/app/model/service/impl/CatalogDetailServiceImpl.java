package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.CatalogDetailEntity;
import com.agroshop.app.model.repository.ICatalogDetailRepository;
import com.agroshop.app.model.service.ICatalogDetailService;

@Service
public class CatalogDetailServiceImpl implements ICatalogDetailService {
	
	@Autowired
	private ICatalogDetailRepository catalogDetailRepo;
	
	@Override
	public List<CatalogDetailEntity> getAll() {
		return catalogDetailRepo.findAll();
	}

	@Override
	public CatalogDetailEntity getOneById(Integer id) {
		return catalogDetailRepo.getOne(id);
	}

	@Override
	public CatalogDetailEntity save(CatalogDetailEntity t) {
		return catalogDetailRepo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		catalogDetailRepo.deleteById(id);
	}

}

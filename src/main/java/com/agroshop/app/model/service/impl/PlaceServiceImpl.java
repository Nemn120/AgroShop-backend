package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.PlaceEntity;
import com.agroshop.app.model.repository.IPlaceRepository;
import com.agroshop.app.model.service.IPlaceService;

@Service
public class PlaceServiceImpl implements IPlaceService{
	
	@Autowired
	IPlaceRepository repo;

	@Override
	public List<PlaceEntity> getAll() {
		return repo.findAll();
	}

	@Override
	public PlaceEntity getOneById(Integer id) {
		return repo.findById(id).orElse(new PlaceEntity());
	}

	@Override
	public PlaceEntity save(PlaceEntity t) {
		return repo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
		
	}
}

package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.repository.IDriverRepository;
import com.agroshop.app.model.service.IDriverService;

@Service
public class DriverServiceImpl implements IDriverService{
	
	@Autowired
	private IDriverRepository driverRepo;
	
	@Override
	public List<DriverEntity> getAll() {
		return driverRepo.findAll();
	}

	@Override
	public DriverEntity getOneById(Integer id) {
		return driverRepo.getOne(id);
	}

	@Override
	public DriverEntity save(DriverEntity t) {
		return driverRepo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		driverRepo.deleteById(id);
	}
	
}

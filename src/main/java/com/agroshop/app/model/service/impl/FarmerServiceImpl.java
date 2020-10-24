package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.entities.FarmerEntity;
import com.agroshop.app.model.repository.IFarmerRepository;
import com.agroshop.app.model.service.IFarmerService;

@Service
public class FarmerServiceImpl implements IFarmerService{
	
	@Autowired
	private IFarmerRepository farmerRepo;
	
	@Override
	public List<FarmerEntity> getAll() {
		return farmerRepo.findAll();
	}

	@Override
	public FarmerEntity getOneById(Integer id) {
		return farmerRepo.findById(id).orElse(new FarmerEntity());
	}
	@Override
	public FarmerEntity save(FarmerEntity t) {
		return farmerRepo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		farmerRepo.deleteById(id);
	}

}

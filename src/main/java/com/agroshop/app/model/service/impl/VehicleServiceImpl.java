package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.agroshop.app.model.entities.VehicleEntity;
import com.agroshop.app.model.repository.IVehicleRepository;
import com.agroshop.app.model.service.IVehicleService;

public class VehicleServiceImpl implements IVehicleService{

	
	@Autowired
	private IVehicleRepository vehicleRepository;
	
	@Override
	public List<VehicleEntity> getAll() {
		return vehicleRepository.findAll();
	}

	@Override
	public VehicleEntity getOneById(Integer id) {
		return vehicleRepository.findById(id).orElse(new VehicleEntity());
	}

	@Override
	public VehicleEntity save(VehicleEntity t) {
		t.setIsDeleted(false);
		return vehicleRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		VehicleEntity ve = vehicleRepository.findById(id).orElse(new VehicleEntity());
		if(ve !=null && ve.getIsDeleted() != true) {
			ve.setIsDeleted(true);
			vehicleRepository.save(ve);
		}
		vehicleRepository.deleteById(id);
		
	}
	
	

}
package com.agroshop.app.model.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.controller.rest.VehicleController;
import com.agroshop.app.model.entities.VehicleEntity;
import com.agroshop.app.model.repository.IVehicleRepository;
import com.agroshop.app.model.service.IVehicleService;

@Service
public class VehicleServiceImpl implements IVehicleService{

	private static final Logger logger = LogManager.getLogger(IVehicleService.class);
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
		VehicleEntity vehicleSave =vehicleRepository.save(t);
		if(t.getPhoto() != null &&  t.getPhoto().length>0)
			vehicleRepository.updatePhoto(t.getId(),t.getPhoto());
			return vehicleSave;
	}

	@Override
	public void deleteById(Integer id) {
		VehicleEntity ve = vehicleRepository.findById(id).orElse(new VehicleEntity());
		if(ve.getDriver()!= null && ve.getIsDeleted() == false) {
			ve.setIsDeleted(true);
			vehicleRepository.save(ve);
		}
		//vehicleRepository.deleteById(id);
		
	}

	@Override
	public List<VehicleEntity> getVehicleListByDriver(Integer id) {
		return vehicleRepository.getListVehicleByDriver(id);
	}
	
	

}

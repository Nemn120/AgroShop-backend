package com.agroshop.app.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.VehicleEntity;

@Service
public interface IVehicleService extends GenericCRUD<VehicleEntity, Integer>{
	
	List<VehicleEntity> getVehicleListByDriver(Integer id);

}

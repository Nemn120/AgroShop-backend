package com.agroshop.app.model.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.repository.IDriverRepository;
import com.agroshop.app.model.service.IDriverService;
import com.agroshop.app.util.Constants;

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
		return driverRepo.findById(id).orElse(new DriverEntity());
	}

	@Override
	public DriverEntity save(DriverEntity t) {
		return driverRepo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		driverRepo.deleteById(id);
	}

	@Override
	public List<DriverEntity> getDriverListByStatus(String status) {
		return driverRepo.findByStatus(status);
	}

	@Override
	public DriverEntity getDriverById(Integer id) {
		return driverRepo.findById(id).orElse(null);
	}

	@Override
	public Boolean isAcceptedDriver(DriverEntity driver) {
		Boolean status = false;
			if(driver.getStatus() == Constants.DRIVER_STATUS_PENDING) {
				status = false;
			} else if (driver.getStatus() == Constants.DRIVER_STATUS_ACCEPTED){
				status = true;
			}
		return status;
	}

	@Override
	public DriverEntity acceptDriverRegistered(Integer id) {
		DriverEntity driver = getDriverById(id);
		DriverEntity driverAccepted = new DriverEntity();
		if(!isAcceptedDriver(driver)) {
			driver.setStatus(Constants.DRIVER_STATUS_ACCEPTED);
			driverAccepted = save(driver);
		}
		return driverAccepted;
	}
}

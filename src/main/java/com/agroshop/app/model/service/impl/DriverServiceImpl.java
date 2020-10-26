package com.agroshop.app.model.service.impl;

import java.util.List;

import com.agroshop.app.model.beans.DriverBean;
import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.repository.IDriverRepository;
import com.agroshop.app.model.service.IDriverService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public DriverEntity MapDriverFromBeantoEntity(DriverBean driver) {
		DriverEntity driverEntity= new DriverEntity();
		BeanUtils.copyProperties(driverEntity, driver);
		return driverEntity;
	}

	@Override
	public DriverBean MapDriverFromEntitytoBean(DriverEntity driver) {
		DriverBean driverBean= new DriverBean();
		BeanUtils.copyProperties(driverBean, driver);
		return driverBean;
	}

	@Override
	public DriverEntity getDriverById(Integer id) {
		return driverRepo.findById(id).orElse(null);
	}
	
}

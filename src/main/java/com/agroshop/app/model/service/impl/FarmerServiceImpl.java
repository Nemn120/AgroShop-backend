package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.controller.response.AbstractResponse;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.entities.FarmerEntity;
import com.agroshop.app.model.entities.UserEntity;
import com.agroshop.app.model.repository.IFarmerRepository;
import com.agroshop.app.model.service.IFarmerService;
import com.agroshop.app.model.service.IUserService;
import com.agroshop.app.util.Constants;

@Service
public class FarmerServiceImpl implements IFarmerService{
	
	@Autowired
	private IFarmerRepository farmerRepo;
	
	@Autowired
	private IUserService userService;
	
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

	@Override
	public FarmerEntity register(FarmerEntity farmer) throws Throwable {
		farmer.getUser().setTypeUser(Constants.USER_TYPE_FARMER);
		farmer.setUser(this.userService.register(farmer.getUser()));
		return this.save(farmer);     
	}

	@Override
	public FarmerEntity getUserByUsername(String username) {
		return farmerRepo.getUserByUsername(username);
	}

	@Override
	public FarmerEntity getFarmerById(Integer id) {
		return farmerRepo.getFarmerById(id);
	}

}

package com.agroshop.app.model.service.impl;
import java.util.ArrayList;
import java.util.List;


import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.repository.IDriverRepository;
import com.agroshop.app.model.service.IDriverService;
import com.agroshop.app.model.service.IUserService;
import com.agroshop.app.util.Constants;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverServiceImpl implements IDriverService{
	
	@Autowired
	private IDriverRepository driverRepo;
	
	@Autowired
	private IUserService userService;
	
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
	public List<DriverEntity> acceptDriverRegistered(List<Integer> ids) {
		List<DriverEntity> driverAccepted = new ArrayList<DriverEntity>();
		ids.forEach( id -> {
			DriverEntity driver = this.getDriverById(id);
			if(!isAcceptedDriver(driver)) {
				driver.setStatus(Constants.DRIVER_STATUS_ACCEPTED);
				driverAccepted.add(save(driver));
			} 
		});
		return driverAccepted;
	}

	@Override
	public DriverEntity getUserByUsername(String username) {
		return driverRepo.getUserByUsername(username);
	}

	@Override
	public DriverEntity register(DriverEntity driver) {
		driver.getUser().setTypeUser(Constants.USER_TYPE_DRIVER);
		driver.setUser(this.userService.register(driver.getUser()));
		return this.save(driver);  
	}

	@Override
	public DriverEntity acceptDriverRegistered(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}


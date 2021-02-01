package com.agroshop.app.model.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.repository.IDriverRepository;
import com.agroshop.app.model.service.IDriverService;
import com.agroshop.app.model.service.IUserService;
import com.agroshop.app.util.Constants;
import com.agroshop.app.util.MailUtil;


@Service
public class DriverServiceImpl implements IDriverService{
	
	@Autowired
	private IDriverRepository driverRepo;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private MailUtil mailUtil;
	
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
			if (driver.getStatus().equals(Constants.DRIVER_STATUS_ACCEPTED)){
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
				if(driver.getUser().getEmail() != null) {
					sendEmailConfirmDriverAccepted(driver);
				}
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
	public DriverEntity register(DriverEntity driver) throws Throwable {
		driver.getUser().setTypeUser(Constants.USER_TYPE_DRIVER);
		driver.setUser(this.userService.register(driver.getUser()));
		return this.save(driver);  
	}

	@Override
	public DriverEntity acceptDriverRegistered(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStatusOfDriver(String username) {
		DriverEntity driver = getUserByUsername(username);
		return driver.getStatus();
	}
	
	private void sendEmailConfirmDriverAccepted(DriverEntity driver) {
		String subject = "Sr. Conductor Su cuenta como conductor ha sido aceptada";
		StringBuffer body = new StringBuffer("Agroshop le envía sus credenciales de acceso: \n");
		body.append("Usuario: " + driver.getUser().getUsername() + "\n");
		body.append("Password: " + driver.getUser().getPassword() + "\n");
		mailUtil.sendEmail(driver.getUser().getEmail(), body.toString(), subject);
	}
}


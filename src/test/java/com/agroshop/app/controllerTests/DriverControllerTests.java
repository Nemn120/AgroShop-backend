package com.agroshop.app.controllerTests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.DTO.RegisterDTO;
import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.entities.UserEntity;
import com.agroshop.app.model.service.IDriverService;
import com.agroshop.app.model.service.IUserService;

@ExtendWith(SpringExtension.class)
public class DriverControllerTests {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IDriverService driverService;
	
	private GenericResponse<DriverEntity> response;
	
	@Test
	public void testGetListDriverAccepted() {
		
		RegisterDTO registerDTO = new RegisterDTO();
		UserEntity user = new UserEntity();
		DriverEntity driver1 = new DriverEntity();
		GenericRequest<String> request = new GenericRequest<>();
		List<DriverEntity> drivers = new ArrayList<>();
		
		request.setData("Aceptado");
		
		user.setUsername("Driver 01");
		user.setPassword("123");
		
		driver1.setId(1);
		driver1.setStatus("Aceptado");
		driver1.setYearsOfExperience("5");
		driver1.setQualification(5.0);
		driver1.setUser(user);
		
		registerDTO.setUserType("DRIVER");
		registerDTO.setUserRegister(driver1);
		
		userService.registerUserByTypeUser(registerDTO);
		assert(driverService.getDriverListByStatus("Aceptado")).isEmpty();
		driverService.getDriverListByStatus("Aceptado");
		
	}
	
}

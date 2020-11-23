package com.agroshop.app.controller.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.DTO.LoginDTO;
import com.agroshop.app.model.DTO.RegisterDTO;
import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.service.IDriverService;
import com.agroshop.app.model.service.IUserService;
import com.agroshop.app.util.Constants;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IDriverService driverService;
	
	private static final Logger logger = LogManager.getLogger(ProfileController.class);
	
	
	@PostMapping(value="/gubu")
	public GenericResponse<Object> getUserByUsernameAndUserType(@RequestBody LoginDTO request ){
		GenericResponse<Object> response = new GenericResponse<Object>();
		Object object = null; 
		try {
			logger.info(request.getUsername());
			if(request.getUserType().equals(Constants.USER_TYPE_DRIVER)) {
				DriverEntity driver = driverService.getUserByUsername(request.getUsername());
				if(!driverService.isAcceptedDriver(driver)) {
					object = null;
				} else {
					object =userService.getTypeUserByUsernameAndType(request.getUsername(), request.getUserType());				
				}
			} else {
				object =userService.getTypeUserByUsernameAndType(request.getUsername(), request.getUserType());				
			}
			if(object != null) {
				response.setData(object);
			}else {
				response.setResponseMessage(Constants.ERROR_PETITION_MESSAGE);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage(Constants.ERROR_PETITION_MESSAGE);
		}
		
		return response;
	}
	
	@PostMapping(value="/rubt")
	public GenericResponse<Object> registerUserByUserType(@RequestBody RegisterDTO request ) throws Throwable{
		GenericResponse<Object> response = new GenericResponse<Object>();
		try {
			Object o = userService.registerUserByTypeUser(request);
			if(o!=null) {
				response.setData(o);
				response.setResponseMessage(Constants.SUCCESS_REGISTER);
				response.setResponseCode(Constants.SUCCESS_PETITION_REQUEST);
			}else {
				response.setResponseMessage(Constants.ERROR_REGISTER_MESSAGE_USERNAME_INVALID);
				response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			}
		}catch(Exception e) {
			
			logger.error(e.getMessage());
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage(Constants.ERROR_REGISTER_MESSAGE);
		}
		
		return response;
	}	
	
	

}

package com.agroshop.app.controller.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.DTO.LoginDTO;
import com.agroshop.app.model.DTO.RegisterDTO;
import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.entities.ProductEntity;
import com.agroshop.app.model.entities.UserEntity;
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
		logger.info("UserController.getUserByUsernameAndUserType()");
		GenericResponse<Object> response = new GenericResponse<Object>();
		Object object = null; 
		try {
			logger.info(request.getUsername());
			if(request.getUserType().equals(Constants.USER_TYPE_DRIVER)) {
				DriverEntity driver = driverService.getUserByUsername(request.getUsername());
				if(!driverService.isAcceptedDriver(driver)) {
					object = null;
					response.setResponseMessage("Su cuenta se encuentra en espera de validacion, por favor espere 24h");
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
		logger.info("UserController.registerUserByUserType()");
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
			if(e.getMessage().equals(Constants.USERNAME_DUPLICATE))
				response.setResponseMessage(e.getMessage());
			else
				response.setResponseMessage(Constants.ERROR_REGISTER_MESSAGE);
			logger.error(e.getMessage());
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
		}
		return response;
	}
	
	@PostMapping(value="/gubi")
	public GenericResponse<Object> getUserById(@RequestBody GenericRequest<UserEntity> request ) throws Throwable{
		logger.info("UserController.getUserById()");
		GenericResponse<Object> response = new GenericResponse<Object>();
		try {
			UserEntity user = userService.getOneById(request.getId());
			response.setData(user);
			response.setResponseCode(Constants.SUCCESS_PETITION_REQUEST);
		}catch(Exception e) {
			response.setResponseMessage("Error al obtener datos del usuario");
			logger.error(e.getMessage());
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
		}
		return response;
	}	
	
	@PostMapping(value="/gubus")
	public GenericResponse<Object> getUserByUsername(@RequestBody GenericRequest<UserEntity> request ) throws Throwable{
		logger.info("UserController.getUserByUsername()");
		GenericResponse<Object> response = new GenericResponse<Object>();
		try {
			UserEntity user = userService.getUserByUsername(request.getData().getUsername());
			response.setData(user);
			response.setResponseCode(Constants.SUCCESS_PETITION_REQUEST);
		}catch(Exception e) {
			response.setResponseMessage("Error al obtener datos del usuario");
			logger.error(e.getMessage());
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
		}
		return response;
	}
	
	@PostMapping(value="/uu")
	public GenericResponse<Object> updatedUser(@RequestPart("request") GenericRequest<UserEntity> request,@RequestPart("file") MultipartFile file) throws Throwable{
		logger.info("UserController.updatedUser()");
		GenericResponse<Object> response = new GenericResponse<Object>();
		try {
			if(request.getData() == null)
				return response;
			if(file.getBytes().length>0)
				request.getData().setPhoto(file.getBytes());
			response.setData(userService.updateUser(request.getData()));
			response.setResponseCode(Constants.SUCCESS_PETITION_REQUEST);
		}catch(Exception e) {
			response.setResponseMessage("Error al registrar datos del usuario");
			logger.error(e);
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
		}
		return response;
	}
	
	@GetMapping(value = "/gp/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> getPhoto(@PathVariable("id") Integer id) {
		logger.info("UserController.getPhoto()");
		UserEntity c = userService.getOneById(id);
		byte[] data = c.getPhoto();
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}	
}

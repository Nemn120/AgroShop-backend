package com.agroshop.app.controller.rest;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.entities.FarmerEntity;
import com.agroshop.app.model.entities.ProfileEntity;
import com.agroshop.app.model.service.IProfileMenuOptionService;
import com.agroshop.app.model.service.IProfileService;
import com.agroshop.app.model.service.impl.ProfileServiceImpl;
import com.agroshop.app.util.Constants;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private IProfileMenuOptionService profileMenuOptionService;
	
	@Autowired
	private IProfileService profileService;
	
	private static final Logger logger = LogManager.getLogger(ProfileController.class);
	
	
	@GetMapping(value="/glp")
	public GenericResponse<ProfileEntity> getListOptionByProfile(){
		GenericResponse<ProfileEntity> response = new GenericResponse<ProfileEntity>();
		try {
			response.setResponseCode(Constants.SUCCESS_PETITION_REQUEST);
			response.setDatalist(profileService.getAll());
		}catch(Exception e) {
			logger.error(e.getMessage());
			response.setResponseMessage(Constants.ERROR_PETITION_MESSAGE);
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
		}
		
		return response;
	}
	
}

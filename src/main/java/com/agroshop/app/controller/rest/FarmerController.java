package com.agroshop.app.controller.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.entities.FarmerEntity;
import com.agroshop.app.model.service.IFarmerService;
import com.agroshop.app.util.Constants;

@RestController
@RequestMapping("/farmer")
public class FarmerController {
	
	@Autowired
	private IFarmerService farmerService;
	
	private GenericResponse<FarmerEntity> response; 
	private static final Logger logger = LogManager.getLogger(FarmerController.class);

	
}

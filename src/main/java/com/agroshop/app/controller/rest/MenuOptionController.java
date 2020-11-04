package com.agroshop.app.controller.rest;

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

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.entities.FarmerEntity;
import com.agroshop.app.model.entities.MenuOptionEntity;
import com.agroshop.app.model.service.IMenuOptionService;
import com.agroshop.app.util.Constants;

@RestController
@RequestMapping("/menu")
public class MenuOptionController {
	
	private static final Logger logger = LogManager.getLogger(MenuOptionController.class);	

	@Autowired
	private IMenuOptionService menuService;
	
	@PostMapping(path="/glmbi")
	public GenericResponse<MenuOptionEntity>  getListMenuOption(@RequestBody GenericRequest<FarmerEntity> request){
		GenericResponse<MenuOptionEntity> response = new GenericResponse<MenuOptionEntity>();
		try {
			response.setDatalist(menuService.getListMenuOptionByProfileId(request.getId()));
			response.setResponseCode(Constants.SUCCESS_PETITION_REQUEST);
		}catch(Exception e) {
			logger.error(e.getMessage());
			response.setResponseMessage(Constants.ERROR_PETITION_REQUEST);
		}
		
		return response;
		
	}
	
	

}

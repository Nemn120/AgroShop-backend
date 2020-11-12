package com.agroshop.app.controller.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.DTO.MenuOptionDTO;
import com.agroshop.app.model.service.IMenuOptionService;
import com.agroshop.app.util.Constants;

@RestController
@RequestMapping("/menu")
public class MenuOptionController {
	
	private static final Logger logger = LogManager.getLogger(MenuOptionController.class);	

	@Autowired
	private IMenuOptionService menuService;
	
	@PostMapping(path="/glmbi")
	public GenericResponse<MenuOptionDTO>  getListMenuOption(@RequestBody GenericRequest<MenuOptionDTO> request){
		GenericResponse<MenuOptionDTO> response = new GenericResponse<MenuOptionDTO>();
		try {
			response.setDatalist(menuService.getListMenuOptionByProfileId(request.getId()));
			response.setResponseCode(Constants.SUCCESS_PETITION_REQUEST);
		}catch(Exception e) {
			logger.error(e);
			response.setResponseMessage(Constants.ERROR_PETITION_REQUEST);
		}
		
		return response;
		
	}
	
	

}

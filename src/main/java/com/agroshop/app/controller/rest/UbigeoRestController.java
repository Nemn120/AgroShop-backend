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
import com.agroshop.app.model.entities.UbigeoEntity;
import com.agroshop.app.model.entities.UserEntity;
import com.agroshop.app.model.service.IUbigeoService;

@RestController
@RequestMapping("/ubigeo")
public class UbigeoRestController {
	
	private static final Logger logger = LogManager.getLogger(UbigeoRestController.class);

	@Autowired
	private IUbigeoService ubigeoService;
	
	@PostMapping(value="/grl")
	public GenericResponse<UbigeoEntity> getRegionList(@RequestBody GenericRequest<UbigeoEntity> request ) {
		logger.info("UbigeoRestController.getRegionList()");
		GenericResponse<UbigeoEntity> response = new GenericResponse<UbigeoEntity>();
		try {
			response.setDatalist(this.ubigeoService.getRegionList());
			return response;
		}catch(Exception e) {
			
			
			return response;
		}
	}
	@PostMapping(value="/gdbpr")
	public GenericResponse<UbigeoEntity> getDistrictsListByProvinceCodeAndRegionCode(@RequestBody GenericRequest<UbigeoEntity> request ) {
		logger.info("UbigeoRestController.getDistrictsListByProvinceCodeAndRegionCode()");
		GenericResponse<UbigeoEntity> response = new GenericResponse<UbigeoEntity>();
		try {
			response.setDatalist(this.ubigeoService.getDistrictsListByProvinceCodeAndRegionCode(request.getData().getCodigoDepartamento(),request.getData().getCodigoProvincia()));
			return response;
		}catch(Exception e) {
			
			
			return response;
		}
	}
	@PostMapping(value="/gpbr")
	public GenericResponse<UbigeoEntity> getProvinceListByRegionCode(@RequestBody GenericRequest<UbigeoEntity> request ) {
		logger.info("UbigeoRestController.getProvinceListByRegionCode()");
		GenericResponse<UbigeoEntity> response = new GenericResponse<UbigeoEntity>();
		try {
			response.setDatalist(this.ubigeoService.getProvinceListByRegionCode(request.getData().getCodigoDepartamento()));
			return response;
		}catch(Exception e) {
			
			
			return response;
		}
	}

}

package com.agroshop.app.controller.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.AbstractResponse;
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
	
	@GetMapping(path="/glf")
	public 	List<FarmerEntity> getAllFarmer(){
		return farmerService.getAll();
	}
	
	@PostMapping(path="/gfbi")
	public GenericResponse<FarmerEntity> getFarmerById(@RequestBody GenericRequest<FarmerEntity> request){
		
		GenericResponse<FarmerEntity> response = new GenericResponse<FarmerEntity>();
		try {
			FarmerEntity farmer = farmerService.getFarmerById(request.getId());
			if(farmer!=null)
				response.setResponseMessage("agricultor encontrado");
			else
				response.setResponseMessage("No se encontró al agricultor");
			response.setData(farmer);
			response.setFinalTimesTamp(LocalDateTime.now());
			response.setResponseCode(AbstractResponse.SUCCESS);
		}catch(Exception e) {
			response.setResponseMessage("Error al buscar agricultor");
			response.setResponseCode(AbstractResponse.ERROR);
		}
		
		return response;
	}

	
}

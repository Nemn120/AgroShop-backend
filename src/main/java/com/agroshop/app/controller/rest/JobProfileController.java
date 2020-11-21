package com.agroshop.app.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.AbstractResponse;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.entities.FarmerEntity;
import com.agroshop.app.model.entities.JobProfileEntity;
import com.agroshop.app.model.entities.OrderEntity;
import com.agroshop.app.model.service.IJobProfileService;

@RestController
@RequestMapping("/jobprofile")
public class JobProfileController {
	
	@Autowired
	private IJobProfileService jobProfileService;
	
	@PostMapping(path="/gpbi")
	private ResponseEntity<GenericResponse<JobProfileEntity>> getJobProfileById(@RequestBody GenericRequest<JobProfileEntity> request){
		GenericResponse<JobProfileEntity> response = new GenericResponse<JobProfileEntity>();
		try {
			response.setData(this.jobProfileService.getOneById(request.getId()));
			return new ResponseEntity<GenericResponse<JobProfileEntity>>(response,HttpStatus.CREATED);
		}catch(Exception e) {
			response.setResponseMessage("Error al buscar agricultor");
			response.setResponseCode(AbstractResponse.ERROR);
			return new ResponseEntity<GenericResponse<JobProfileEntity>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PostMapping(path="/sjpbi")
	private ResponseEntity<GenericResponse<JobProfileEntity>> saveJobProfile(@RequestBody GenericRequest<JobProfileEntity> request){
		GenericResponse<JobProfileEntity> response = new GenericResponse<JobProfileEntity>();
		try {
			response.setData(this.jobProfileService.save(request.getData()));
			response.setResponseMessage(request.getData().getId() != null?"Perfil actualizado con éxito":"Perfil registrado con éxito");
			return new ResponseEntity<GenericResponse<JobProfileEntity>>(response,HttpStatus.CREATED);
		}catch(Exception e) {
			response.setResponseMessage("Error al buscar agricultor");
			response.setResponseCode(AbstractResponse.ERROR);
			return new ResponseEntity<GenericResponse<JobProfileEntity>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	

}

package com.agroshop.app.controller.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.AbstractResponse;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.DTO.SearchJobOfferByFieldsDTO;
import com.agroshop.app.model.entities.JobOfferEntity;
import com.agroshop.app.model.entities.OrderEntity;
import com.agroshop.app.model.entities.ProductEntity;
import com.agroshop.app.model.service.IJobOfferService;
import com.agroshop.app.util.Constants;

@RestController
@RequestMapping("/joboffer")
public class JobOfferController {

	String path = "http://localhost:8080/joboffer";
	private static final Logger logger = LogManager.getLogger(JobOfferController.class);
	
	@Autowired
	IJobOfferService service;
	
	@PostMapping(path="/po")
	public ResponseEntity<GenericResponse<JobOfferEntity>> postOffer(@RequestBody GenericRequest<JobOfferEntity> request) throws Throwable {
		
		GenericResponse<JobOfferEntity> response = new GenericResponse<JobOfferEntity>();
		try {
			JobOfferEntity jo = service.postOffer(request.getData());
			if(jo.getStatusOffer().equals(Constants.JOB_OFFER_AVAILABLE)) {
				response.setData(jo);
				response.setResponseMessage("Se publicó correctamente la oferta laboral");
				response.setResponseCode(Constants.SUCCESS_REGISTER);
			}else {
				response.setResponseMessage("No se pudo publicar la oferta laboral");
				response.setResponseCode(Constants.ERROR_REGISTER_MESSAGE);
			}				

			response.setFinalTimesTamp(LocalDateTime.now());
			return new ResponseEntity<GenericResponse<JobOfferEntity>>(response,HttpStatus.OK);
		}catch(Exception e){
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage(e.getMessage());
			logger.error("ERORR ==> ",e);
			
			return new ResponseEntity<GenericResponse<JobOfferEntity>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path="/gljobf")
	public ResponseEntity<GenericResponse<JobOfferEntity>> getListJobOfferByFields(@RequestBody GenericRequest<SearchJobOfferByFieldsDTO> request) throws Throwable {
		
		GenericResponse<JobOfferEntity> response = new GenericResponse<JobOfferEntity>();
		try {
			List<JobOfferEntity> list = service.getListJobOfferByFields(request.getData());
			if(list.isEmpty()) 
				response.setResponseMessage("No se encontraron ofertas laborales que coincidan con la busqueda");
			else {
				response.setDatalist(list);
				response.setResponseMessage("Ofertas laborales encontradas");
			}
			response.setResponseCode(Constants.SUCCESS_SHOW_LIST);
			response.setFinalTimesTamp(LocalDateTime.now());
			return new ResponseEntity<GenericResponse<JobOfferEntity>>(response,HttpStatus.OK);
		}catch(Exception e){
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage(e.getMessage());
			logger.error("ERORR ==> ",e);
			
			return new ResponseEntity<GenericResponse<JobOfferEntity>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/gaoj")
	public 	List<JobOfferEntity> getAllJobOffer(){
		return service.getAll();
	}
}

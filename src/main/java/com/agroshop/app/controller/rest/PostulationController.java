package com.agroshop.app.controller.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.AbstractResponse;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.entities.PostulationEntity;
import com.agroshop.app.model.service.IPostulationService;
import com.agroshop.app.util.Constants;

@RestController
@RequestMapping("/postulation")
public class PostulationController {

	private static final Logger logger = LogManager.getLogger(PostulationController.class);

	@Autowired
	IPostulationService postulationService;

	@PostMapping(path = "/afaj")
	public GenericResponse<PostulationEntity> applyForAJob(@RequestBody GenericRequest<PostulationEntity> request) throws Throwable {
		logger.info("PostulationController.applyForAJob()");
		GenericResponse<PostulationEntity> response = new GenericResponse<>();
		String message = "";
		try {
			message = postulationService.applyForAJob(request.getData().getJobOffer().getId(),
					request.getData().getDriver().getId(), request.getData().getDetail(), request.getData().getReply());
			response.setResponseCode(AbstractResponse.SUCCESS);
			response.setResponseMessage(message);
		} catch (Exception e) {
			response.setResponseCode(AbstractResponse.ERROR);
			response.setResponseMessage(e.getMessage());
			//throw new RuntimeException(Constants.ERROR_PETITION_MESSAGE);
		}
		return response;
	}
	
	@PostMapping(path = "/fpbsaid")
	public GenericResponse<PostulationEntity> findPostulationByStatusPostulationAndDriverId(@RequestBody GenericRequest<PostulationEntity> request) throws Throwable {
		logger.info("PostulationController.findPostulationByStatusPostulationAndDriverId()");
		GenericResponse<PostulationEntity> response = new GenericResponse<>();
		try {
			response.setDatalist(postulationService.findByStatusPostulationAndDriverId(request.getData().getStatusPostulation(), request.getData().getDriver().getId()));
			response.setResponseCode(AbstractResponse.SUCCESS);
			response.setResponseMessage(Constants.SUCCESS_PETITION_REQUEST);
		} catch (Exception e) {
			response.setResponseCode(AbstractResponse.ERROR);
			response.setResponseMessage(e.getMessage());
			throw new RuntimeException(Constants.ERROR_PETITION_MESSAGE);
		}
		return response;
	}
	
	@PostMapping(path = "/fpbsafid")
	public GenericResponse<PostulationEntity> findPostulationByStatusPostulationAndFarmerId(@RequestBody GenericRequest<PostulationEntity> request) throws Throwable {
		logger.info("PostulationController.findPostulationByStatusPostulationAndFarmerId()");
		GenericResponse<PostulationEntity> response = new GenericResponse<>();
		try {
			response.setDatalist(postulationService.findPostulationByStatusPostulationAndFarmerId(request.getData().getStatusPostulation(), request.getData().getJobOffer().getOrder().getFarmer().getId()));
			response.setResponseCode(AbstractResponse.SUCCESS);
			response.setResponseMessage(Constants.SUCCESS_PETITION_REQUEST);
		} catch (Exception e) {
			response.setResponseCode(AbstractResponse.ERROR);
			response.setResponseMessage(e.getMessage());
			throw new RuntimeException(Constants.ERROR_PETITION_MESSAGE);
		}
		return response;
	}
	
	@PostMapping(path = "/dpbid")
	public GenericResponse<PostulationEntity> deletePostulationById(@RequestBody GenericRequest<Integer> request) throws Throwable {
		logger.info("PostulationController.deletePostulationById()");
		GenericResponse<PostulationEntity> response = new GenericResponse<>();
		try {
			postulationService.deleteById(request.getData());
			response.setResponseCode(AbstractResponse.SUCCESS);
			response.setResponseMessage(Constants.SUCCESS_PETITION_REQUEST);
		} catch (Exception e) {
			response.setResponseCode(AbstractResponse.ERROR);
			response.setResponseMessage(e.getMessage());
			throw new RuntimeException(Constants.ERROR_PETITION_MESSAGE);
		}
		return response;
	}
	
	@PostMapping(path = "/gpbid")
	public GenericResponse<PostulationEntity> getPostulationById(@RequestBody GenericRequest<Integer> request) throws Throwable {
		logger.info("PostulationController.getPostulationById()");
		GenericResponse<PostulationEntity> response = new GenericResponse<>();
		try {
			postulationService.getOneById(request.getData());
			response.setResponseCode(AbstractResponse.SUCCESS);
			response.setResponseMessage(Constants.SUCCESS_PETITION_REQUEST);
		} catch (Exception e) {
			response.setResponseCode(AbstractResponse.ERROR);
			response.setResponseMessage(e.getMessage());
			throw new RuntimeException(Constants.ERROR_PETITION_MESSAGE);
		}
		return response;
	}

}

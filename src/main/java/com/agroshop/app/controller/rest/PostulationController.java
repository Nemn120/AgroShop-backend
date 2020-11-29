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
	
	@PostMapping(path = "/fpbs")
	public GenericResponse<PostulationEntity> findPostulationByStatus(@RequestBody GenericRequest<String> request) throws Throwable {
		logger.info("PostulationController.findPostulationByStatus()");
		GenericResponse<PostulationEntity> response = new GenericResponse<>();
		try {
			response.setDatalist(postulationService.findPostulationByStatus(request.getData()));
			response.setResponseCode(AbstractResponse.SUCCESS);
			response.setResponseMessage(Constants.SUCCESS_PETITION_REQUEST);
		} catch (Exception e) {
			response.setResponseCode(AbstractResponse.ERROR);
			response.setResponseMessage(e.getMessage());
			//throw new RuntimeException(Constants.ERROR_PETITION_MESSAGE);
		}
		return response;
	}

}

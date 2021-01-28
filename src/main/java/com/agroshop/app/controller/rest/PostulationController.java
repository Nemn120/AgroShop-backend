package com.agroshop.app.controller.rest;

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
import com.agroshop.app.model.entities.PostulationEntity;
import com.agroshop.app.model.service.IPostulationService;
import com.agroshop.app.util.Constants;

@RestController
@RequestMapping("/postulation")
public class PostulationController {

	private static final Logger logger = LogManager.getLogger(PostulationController.class);

	@Autowired
	IPostulationService postulationService;
	
	@GetMapping(path = "/gap")
	public GenericResponse<PostulationEntity> getAllPostulation() throws Throwable {
		logger.info("PostulationController.getAllPostulation()");
		GenericResponse<PostulationEntity> response = new GenericResponse<>();
		try {
			response.setDatalist(postulationService.getAll());;
			response.setResponseCode(AbstractResponse.SUCCESS);
		} catch (Exception e) {
			response.setResponseCode(AbstractResponse.ERROR);
			response.setResponseMessage(e.getMessage());
		}
		return response;
	}

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
		}
		return response;
	}
	
	// TO DO
	@PostMapping(path = "/apf")
    public GenericResponse<PostulationEntity> acceptPostulationFarmer(@RequestBody GenericRequest<Integer> request) throws Throwable{
		GenericResponse<PostulationEntity> response = new GenericResponse<>();
        response = new GenericResponse<PostulationEntity>();
        try {
            postulationService.acceptPostulation(request.getData());
            response.setResponseMessage(Constants.SUCCESS_PETITION_REQUEST);
            response.setResponseCode(AbstractResponse.SUCCESS);

        } catch (Error e) {
            logger.error(e.getMessage());
            response.setResponseMessage(Constants.ERROR_ACCEPTING_DRIVER);
            response.setResponseCode(AbstractResponse.ERROR);
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
		}
		return response;
	}
	
	@PostMapping(path = "/rpbid")
	public GenericResponse<PostulationEntity> declinePostulationById(@RequestBody GenericRequest<Integer> request) throws Throwable {
		logger.info("PostulationController.cancelPostulationById()");
		GenericResponse<PostulationEntity> response = new GenericResponse<>();
		try {
			PostulationEntity postulation = postulationService.getOneById(request.getData());
			postulation.setStatus(Constants.POSTULATION_RECEIVED_STATUS_DECLINE);
			postulationService.save(postulation);
			response.setResponseCode(AbstractResponse.SUCCESS);
			response.setResponseMessage(Constants.SUCCESS_PETITION_REQUEST);
		} catch (Exception e) {
			response.setResponseCode(AbstractResponse.ERROR);
			response.setResponseMessage(e.getMessage());
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
		}
		return response;
	}

}

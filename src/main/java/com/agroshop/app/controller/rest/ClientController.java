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
import com.agroshop.app.model.entities.ClientEntity;
import com.agroshop.app.model.service.IClientService;
import com.agroshop.app.util.Constants;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private IClientService clientService;
	
	private GenericResponse<ClientEntity> response; 
	private static final Logger logger = LogManager.getLogger(ClientController.class);
	
	@PostMapping(path = "/rcl")
    public GenericResponse<ClientEntity> register(@RequestBody GenericRequest<ClientEntity> request) {
		this.response = new GenericResponse<ClientEntity>();
		try {
			response.setData(this.clientService.register(request.getData()));
			response.setResponseMessage(Constants.SUCCESS_REGISTER);
			response.setResponseCode(Constants.SUCCESS_PETITION_REQUEST);
		}catch(Exception e) {
			logger.error(e.getMessage());
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage(Constants.ERROR_REGISTER_MESSAGE);
		}
        return response;
    }
		
	
}
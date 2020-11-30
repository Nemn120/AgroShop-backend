package com.agroshop.app.controller.rest;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.AbstractResponse;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.entities.ClientEntity;
import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.service.IDriverService;
import com.agroshop.app.util.Constants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private IDriverService driverService;
    private GenericResponse<DriverEntity> response;
    private List<String> errors;
    private static final Logger logger = LogManager.getLogger(DriverController.class);

    @PostMapping(path = "/cd")
    public GenericResponse<DriverEntity> registerDriver(@RequestBody GenericRequest<DriverEntity> request) {

        this.response = new GenericResponse<DriverEntity>();
        this.errors = new ArrayList<String>();
        
        try {
            response.setData(this.driverService.save(request.getData()));
            response.setResponseMessage(Constants.SUCCESS_REGISTER);
            response.setResponseCode(AbstractResponse.SUCCESS);
        } catch (Error e) {
            logger.error(e.getMessage());
            errors.add(e.getMessage());
            response.setResponseMessage(Constants.ERROR_CREATING_DRIVER);
            response.setErrorList(errors);
            response.setResponseCode(AbstractResponse.ERROR);

        }
        return response;
    }

    @PostMapping(path = "/dd")
    public GenericResponse<DriverEntity> deleteDriver(@RequestBody GenericRequest<Integer> request) {

        this.response = new GenericResponse<DriverEntity>();
        this.errors = new ArrayList<String>();

        try {
            driverService.deleteById(request.getData());
            response.setResponseMessage(Constants.SUCCESS_DELETED);
            response.setResponseCode(AbstractResponse.SUCCESS);
        } catch (Error e) {
            logger.error(e.getMessage());
            errors.add(e.getMessage());
            response.setResponseMessage(Constants.ERROR_DELETING_DRIVER);
            response.setErrorList(errors);
            response.setResponseCode(AbstractResponse.ERROR);
        }
        return response;
    }

    @PostMapping(path = "/gldbs")
    public GenericResponse<DriverEntity> getListDriverByStatus(@RequestBody GenericRequest<String> request) {
    
        this.response = new GenericResponse<DriverEntity>();
        List<DriverEntity> drivers = new ArrayList<DriverEntity>();
        this.errors = new ArrayList<String>();

        if(request.getData() == null) {
            response.setResponseMessage(Constants.ERROR_REQUEST);
            response.setResponseCode(AbstractResponse.ERROR);
            return response;
        }

        try {
            drivers = driverService.getDriverListByStatus(request.getData());
            response.setDatalist(drivers);
            response.setResponseMessage(Constants.SUCCESS_SHOW_LIST);
            response.setResponseCode(AbstractResponse.SUCCESS);
        } catch (Error e) {
            logger.error(e.getMessage());
            errors.add(e.getMessage());
            response.setResponseMessage(Constants.ERROR_GETTING_DRIVERS);
            response.setErrorList(errors);
            response.setResponseCode(AbstractResponse.ERROR);
        }
        return response;
    }

    @PostMapping(path = "/adr")
    public GenericResponse<DriverEntity> acceptDriverRegistered(@RequestBody GenericRequest<List<Integer>> request) {

        this.response = new GenericResponse<DriverEntity>();
        this.errors = new ArrayList<String>();
        List<DriverEntity> drivers = new ArrayList<DriverEntity>();

        try {
            drivers = driverService.acceptDriverRegistered(request.getData());
            response.setDatalist(drivers);
            response.setResponseMessage(Constants.SUCCESS_REGISTER);
            response.setResponseCode(AbstractResponse.SUCCESS);

        } catch (Error e) {
            logger.error(e.getMessage());
            errors.add(e.getMessage());
            response.setResponseMessage(Constants.ERROR_ACCEPTING_DRIVER);
            response.setErrorList(errors);
            response.setResponseCode(AbstractResponse.ERROR);
        }
        return response;
    }
    
    @PostMapping(path = "/gmfd")
    public GenericResponse<String> getMessageForDriver(@RequestBody GenericRequest<String> request) {
    	GenericResponse<String> response = new GenericResponse<String>();
    	String status;
    	try {
    		status = driverService.getStatusOfDriver(request.getData());
    		if (status.equals(Constants.DRIVER_STATUS_PENDING)) {
    			response.setData(Constants.DRIVER_MESSAGE_NO_ACCEPTED);
    			response.setResponseMessage(Constants.SUCCESS_PETITION_REQUEST);
    			response.setResponseCode(AbstractResponse.SUCCESS);
    		}
    	} catch(Error e) {
    		response.setData(null);
    		response.setResponseMessage(Constants.ERROR_PETITION_MESSAGE);
    		response.setResponseCode(AbstractResponse.ERROR);
    	}
    	return response;
    }

}

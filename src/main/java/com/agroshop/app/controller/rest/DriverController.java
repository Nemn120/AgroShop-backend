package com.agroshop.app.controller.rest;

import java.util.ArrayList;
import java.util.List;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.AbstractResponse;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.service.IDriverService;
import com.agroshop.app.util.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.dao.DataAccessException;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private IDriverService driverService;

    @PostMapping(path = "/cd")
    public GenericResponse<DriverEntity> createDriver(@RequestBody GenericRequest<DriverEntity> request) {

        GenericResponse<DriverEntity> response = new GenericResponse<DriverEntity>();
        DriverEntity driverCreated = new DriverEntity();
        List<String> errors = new ArrayList<String>();
        
        try {
            driverCreated = driverService.save(request.getData());

            response.setResponseMessage("Conductor creado con éxito");
            response.setData(driverCreated);
            response.setResponseCode(AbstractResponse.SUCCESS);
        } catch (Error e) {
            errors.add("Error" + e.getMessage());
            response.setResponseMessage(Constants.ERROR_CREATING_DRIVER);
            response.setErrorList(errors);
            response.setResponseCode(AbstractResponse.ERROR);

        }
        return response;
    }

    @PostMapping(path = "/ud/{id}")
    public GenericResponse<DriverEntity> updateDriver(@RequestBody GenericRequest<DriverEntity> request, @PathVariable Integer id) {

        GenericResponse<DriverEntity> response = new GenericResponse<DriverEntity>();
        DriverEntity currentDriver = driverService.getDriverById(id);
        DriverEntity updatedDriver = null;
        List<String> errors = new ArrayList<String>();

        try {
            
            currentDriver.setDriverLicenseNumber(request.getData().getDriverLicenseNumber());
            currentDriver.setYearsOfExperience(request.getData().getYearsOfExperience());
            currentDriver.setQualification(request.getData().getQualification());

			updatedDriver = driverService.save(currentDriver);

            response.setResponseMessage("Conductor: " + id.toString() + " actualizado con éxito");
            response.setData(updatedDriver);
            response.setResponseCode(AbstractResponse.SUCCESS);
        } catch (DataAccessException e) {
            errors.add(e.getMessage());
            response.setResponseMessage(Constants.ERROR_UPDATING_DRIVER);
            response.setErrorList(errors);
            response.setResponseCode(AbstractResponse.ERROR);

        }
        return response;
    }

    @PostMapping(path = "/dd/{id}")
    public GenericResponse<DriverEntity> deleteDriver(@PathVariable Integer id) {

        GenericResponse<DriverEntity> response = new GenericResponse<DriverEntity>();
        List<String> errors = new ArrayList<String>();

        try {
            driverService.deleteById(id);
            response.setResponseMessage("Conductor: " + id + " eliminado con éxito");
            response.setResponseCode(AbstractResponse.SUCCESS);
        } catch (Error e) {
            errors.add("Error" + e.getMessage());
            response.setResponseMessage(Constants.ERROR_DELETING_DRIVER);
            response.setErrorList(errors);
            response.setResponseCode(AbstractResponse.ERROR);
        }
        return response;
    }

    @PostMapping(path = "/gld")
    public GenericResponse<DriverEntity> getListDriver() {

        GenericResponse<DriverEntity> response = new GenericResponse<DriverEntity>();
        List<DriverEntity> drivers;
        List<String> errors = new ArrayList<String>();

        try {
            drivers = driverService.getAll();

            response.setResponseMessage("Lista de conductores obtenido con éxito");
            response.setDatalist(drivers);
            response.setResponseCode(AbstractResponse.SUCCESS);
        } catch (Error e) {
            errors.add("Error" + e.getMessage());
            response.setResponseMessage(Constants.ERROR_GETTING_DRIVERS);
            response.setErrorList(errors);
            response.setResponseCode(AbstractResponse.ERROR);
        }
        return response;
    }

    @PostMapping(path = "/glda")
    public GenericResponse<DriverEntity> getListDriverAccepted() {
       
        GenericResponse<DriverEntity> response = new GenericResponse<DriverEntity>();
        List<DriverEntity> drivers;
        List<String> errors = new ArrayList<String>();

        try {
            drivers = driverService.getDriverListByStatus(Constants.DRIVER_STATUS_ACCEPTED);
            response.setResponseCode("Lista de conductores aceptados obtenido con éxito");
            response.setDatalist(drivers);
            response.setResponseCode(AbstractResponse.SUCCESS);
        } catch (Error e) {
            errors.add("Error" + e.getMessage());
            response.setResponseMessage(Constants.ERROR_DRIVER_ACCEPTED);
            response.setErrorList(errors);
            response.setResponseCode(AbstractResponse.ERROR);
        }
        return response;
    }

    @PostMapping(path = "/gldp")
    public GenericResponse<DriverEntity> getListDriverPending() {
    
        GenericResponse<DriverEntity> response = new GenericResponse<DriverEntity>();
        List<DriverEntity> drivers;
        List<String> errors = new ArrayList<String>();

        try {
            drivers = driverService.getDriverListByStatus(Constants.DRIVER_STATUS_PENDING);
            response.setResponseMessage("Lista de conductores pendientes obtenido con éxito");
            response.setDatalist(drivers);
            response.setResponseCode(AbstractResponse.SUCCESS);
        } catch (Error e) {
            errors.add("Error" + e.getMessage());
            response.setResponseMessage(Constants.ERROR_DRIVER_PENDING);
            response.setErrorList(errors);
            response.setResponseCode(AbstractResponse.ERROR);
        }
        return response;
    }

    @PostMapping(path = "/adr")
    public GenericResponse<DriverEntity> acceptDriverRegistered(@RequestBody GenericRequest<List<Integer>> request) {

        GenericResponse<DriverEntity> response = new GenericResponse<DriverEntity>();
        List<String> errors = new ArrayList<String>();
        List<DriverEntity> drivers = new ArrayList<DriverEntity>();

        try {
            request.getData().forEach( id -> {
            DriverEntity driverAccepted = driverService.acceptDriverRegistered(id);
            drivers.add(driverService.save(driverAccepted));
            });

            response.setDatalist(drivers);
            response.setResponseMessage("Conductores aceptados con éxito");
            response.setResponseCode(AbstractResponse.SUCCESS);

        } catch (Error e) {
            errors.add("Error" + e.getMessage());
            response.setResponseMessage(Constants.ERROR_ACCEPTING_DRIVER);
            response.setErrorList(errors);
            response.setResponseCode(AbstractResponse.ERROR);
        }
        return response;
    }

}

package com.agroshop.app.controller.rest;

import java.util.ArrayList;
import java.util.List;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.AbstractResponse;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.beans.DriverBean;
import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.service.IDriverService;
import com.agroshop.app.util.Constants;

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

    @PostMapping(path = "/glda")
    public GenericResponse<DriverBean> getListDriverAccepted() {
       
        GenericResponse<DriverBean> response = new GenericResponse<DriverBean>();
        List<String> errors = new ArrayList<String>();
        List<DriverEntity> driverEntities;
        List<DriverBean> driverResponses;
        try {
            driverResponses = new ArrayList<>();
            driverEntities = driverService.getDriverListByStatus(Constants.DRIVER_STATUS_ACCEPTED);

            if(driverEntities == null) {
                errors.add(Constants.DRIVER_BY_STATUS_NOT_AVAILABLE);
                response.setErrorList(errors);
                return response;
            }

            driverEntities.forEach( data -> {
                driverResponses.add(driverService.MapDriverFromEntitytoBean(data));
            });

            response.setDatalist(driverResponses);
            response.setResponseCode(AbstractResponse.SUCCESS);

        } catch (Error e) {
            errors.add(e.getMessage());

            response.setErrorList(errors);
            response.setResponseMessage(Constants.ERROR_DRIVER_ACCEPTED);
            response.setResponseCode(AbstractResponse.ERROR);
        }
        return response;
    }

    @PostMapping(path = "/gldp")
    public GenericResponse<DriverBean> getListDriverPending() {
       
        GenericResponse<DriverBean> response = new GenericResponse<DriverBean>();
        List<String> errors = new ArrayList<String>();
        List<DriverEntity> driverEntities;
        List<DriverBean> driverResponses;
        
        try {
            driverResponses = new ArrayList<>();
            driverEntities = driverService.getDriverListByStatus(Constants.DRIVER_STATUS_PENDING);

            if(driverEntities == null) {
                errors.add(Constants.DRIVER_BY_STATUS_NOT_AVAILABLE);
                response.setErrorList(errors);
                return response;
            }

            driverEntities.forEach( data -> {
                driverResponses.add(driverService.MapDriverFromEntitytoBean(data));
            });

            response.setDatalist(driverResponses);
            response.setResponseCode(AbstractResponse.SUCCESS);

        } catch (Error e) {
            errors.add(e.getMessage());

            response.setErrorList(errors);
            response.setResponseMessage(Constants.ERROR_DRIVER_PENDING);
            response.setResponseCode(AbstractResponse.ERROR);
        }
        return response;
    }

    @PostMapping(path = "/adr")
    public GenericResponse<DriverBean> acceptDriverRegistered(@RequestBody GenericRequest<List<Integer>> request) {
        GenericResponse<DriverBean> response = new GenericResponse<DriverBean>();
        List<String> errors = new ArrayList<String>();
        List<DriverBean> driverBeans = new ArrayList<DriverBean>();

        
        request.getData().forEach( id -> {
            DriverEntity driver = driverService.getDriverById(id);
            driver.setStatus(Constants.DRIVER_STATUS_ACCEPTED);
            driverBeans.add(driverService.MapDriverFromEntitytoBean(driverService.save(driver)));
        });

        try {
            response.setDatalist(driverBeans);
            response.setResponseMessage("Drivers aceptados");
            response.setResponseCode(AbstractResponse.SUCCESS);

        } catch (Error e) {
            errors.add(e.getMessage());

            response.setErrorList(errors);
            response.setResponseMessage(Constants.ERROR_ACCEPTING_DRIVER);
            response.setResponseCode(AbstractResponse.ERROR);
        }
        return response;
    }
}

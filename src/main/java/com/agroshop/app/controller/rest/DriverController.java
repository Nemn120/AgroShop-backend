package com.agroshop.app.controller.rest;

import java.util.ArrayList;
import java.util.List;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.beans.DriverBean;
import com.agroshop.app.model.entities.CompanyEntity;
import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.service.ICompanyService;
import com.agroshop.app.model.service.IDriverService;
import com.agroshop.app.util.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private IDriverService driverService;

    @Autowired
    private ICompanyService companyService;

    @PostMapping(path = "/glda")
    public GenericResponse<DriverBean> getListDriverAccepted() {
       
        GenericResponse<DriverBean> response = new GenericResponse<DriverBean>();
        List<DriverBean> driverResponses;
        List<DriverEntity> driverEntities;
        List<String> errors = new ArrayList<String>();
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
            response.setResponseCode(response.SUCCESS);

        } catch (Error e) {
            errors.add(e.getMessage());

            response.setErrorList(errors);
            response.setResponseMessage(Constants.ERROR_DRIVER_ACCEPTED);
            response.setResponseCode(response.ERROR);
        }
        return response;
    }

    @PostMapping(path = "/gldp")
    public GenericResponse<DriverBean> getListDriverPending() {
       
        GenericResponse<DriverBean> response = new GenericResponse<DriverBean>();
        List<DriverBean> driverResponses;
        List<DriverEntity> driverEntities;
        List<String> errors = new ArrayList<String>();
        
        try {
            driverResponses = new ArrayList<>();
            driverEntities = new ArrayList<>();
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
            response.setResponseCode(response.SUCCESS);

        } catch (Error e) {
            errors.add(e.getMessage());

            response.setErrorList(errors);
            response.setResponseMessage(Constants.ERROR_DRIVER_PENDING);
            response.setResponseCode(response.ERROR);
        }
        return response;
    }

    @PostMapping(path = "/adr/{id}")
    public GenericResponse<DriverBean> acceptDriver(@RequestBody GenericRequest<DriverBean> request, @PathVariable("id") Integer id) {
        GenericResponse<DriverBean> response = new GenericResponse<DriverBean>();
        List<String> errors = new ArrayList<String>();
        DriverEntity driverEntity;

        CompanyEntity company = companyService.getCompanyById(id);

        if(company == null) {
            errors.add(Constants.COMPANY_BY_ID_NOT_AVAILABLE);
            response.setErrorList(errors);
            return response;
        }

        try {
            driverEntity = driverService.MapDriverFromBeantoEntity(request.getData());
            company.setDriver(driverEntity);
            companyService.save(company);
            response.setResponseCode(response.SUCCESS);

        } catch (Error e) {
            errors.add(e.getMessage());

            response.setErrorList(errors);
            response.setResponseMessage(Constants.ERROR_ACCEPTING_DRIVER);
            response.setResponseCode(response.ERROR);
        }
        return response;
    }
}

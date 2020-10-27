package com.agroshop.app.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.service.IDriverService;
import com.agroshop.app.util.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> createDriver(@RequestBody DriverEntity driver) {

        DriverEntity driverCreated;
        Map<String, Object> response = new HashMap<>();

        try {
            driverCreated = driverService.save(driver);

            response.put("message","Conductor: " + driverCreated.getId() + " creado con éxito");
            response.put("data", driverCreated);
        } catch (DataAccessException e) {
            response.put("message", Constants.ERROR_CREATING_DRIVER);
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PostMapping(path = "/dd/{id}")
    public ResponseEntity<?> deleteDriver(@PathVariable Integer id) {

        Map<String, Object> response = new HashMap<>();

        try {
            driverService.deleteById(id);

            response.put("message","Conductor: " + id + " eliminado con éxito");
        } catch (DataAccessException e) {
            response.put("message", Constants.ERROR_DELETING_DRIVER);
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/gld")
    public ResponseEntity<?> getListDriver() {

        Map<String, Object> response = new HashMap<>();
        List<DriverEntity> drivers;

        try {
            drivers = driverService.getAll();

            response.put("message", "Lista de conductores obtenido con éxito");
            response.put("data", drivers);
        } catch (DataAccessException e) {
            response.put("message", Constants.ERROR_GETTING_DRIVERS);
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/glda")
    public ResponseEntity<?> getListDriverAccepted() {
       
        Map<String, Object> response = new HashMap<>();
        List<DriverEntity> drivers;

        try {
            drivers = driverService.getDriverListByStatus(Constants.DRIVER_STATUS_ACCEPTED);
            response.put("message", "Lista de conductores aceptados obtenido con éxito");
            response.put("data", drivers);

        } catch (DataAccessException e) {
            response.put("message", Constants.ERROR_DRIVER_ACCEPTED);
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/gldp")
    public ResponseEntity<?> getListDriverPending() {
    
        Map<String, Object> response = new HashMap<>();
        List<DriverEntity> drivers;

        try {
            drivers = driverService.getDriverListByStatus(Constants.DRIVER_STATUS_PENDING);
            response.put("message", "Lista de conductores pendientes obtenido con éxito");
            response.put("data", drivers);

        } catch (DataAccessException e) {
            response.put("message", Constants.ERROR_DRIVER_PENDING);
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/adr/{id}")
    public ResponseEntity<?> acceptDriverRegistered(@PathVariable Integer id) {

        DriverEntity driverUpdated;
        Map<String, Object> response = new HashMap<>();

        try {
            DriverEntity currentDriver;
            currentDriver = driverService.getDriverById(id);
            currentDriver.setStatus(Constants.DRIVER_STATUS_ACCEPTED);
            driverUpdated = driverService.save(currentDriver);

            response.put("message","Conductor: " + driverUpdated.getId() + " actualizado con éxito");
            response.put("data", driverUpdated);
        } catch (DataAccessException e) {
            response.put("message", Constants.ERROR_ACCEPTING_DRIVER);
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

}

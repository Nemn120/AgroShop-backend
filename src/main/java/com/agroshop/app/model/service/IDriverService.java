package com.agroshop.app.model.service;

import java.util.List;

import com.agroshop.app.model.entities.DriverEntity;

import org.springframework.stereotype.Service;

@Service
public interface IDriverService extends GenericCRUD<DriverEntity, Integer>{
    List<DriverEntity> getDriverListByStatus(String status);
    DriverEntity getDriverById(Integer id);
    Boolean isAcceptedDriver(DriverEntity driver);
    List<DriverEntity> acceptDriverRegistered(List<Integer> ids);
    DriverEntity acceptDriverRegistered(Integer id);
    DriverEntity getUserByUsername(String username);
    DriverEntity register(DriverEntity farmer);
    String getStatusOfDriver(String username);
}

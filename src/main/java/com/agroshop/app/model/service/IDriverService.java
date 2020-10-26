package com.agroshop.app.model.service;

import java.util.List;

import com.agroshop.app.model.beans.DriverBean;
import com.agroshop.app.model.entities.DriverEntity;

import org.springframework.stereotype.Service;

@Service
public interface IDriverService extends GenericCRUD<DriverEntity, Integer>{
    DriverEntity MapDriverFromBeantoEntity(DriverBean driver);
    DriverBean MapDriverFromEntitytoBean(DriverEntity driver);
    List<DriverEntity> getDriverListByStatus(String status);
    DriverEntity getDriverById(Integer id);
}

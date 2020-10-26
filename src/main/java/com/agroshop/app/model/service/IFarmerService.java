package com.agroshop.app.model.service;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.FarmerEntity;

@Service
public interface IFarmerService extends GenericCRUD<FarmerEntity, Integer>{

}
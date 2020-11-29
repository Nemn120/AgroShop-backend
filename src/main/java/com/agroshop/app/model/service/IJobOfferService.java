package com.agroshop.app.model.service;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.JobOfferEntity;

@Service
public interface IJobOfferService extends GenericCRUD<JobOfferEntity, Integer>{
	
}

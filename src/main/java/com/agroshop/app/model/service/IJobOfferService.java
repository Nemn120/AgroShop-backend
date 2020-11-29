package com.agroshop.app.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.DTO.SearchJobOfferByFieldsDTO;
import com.agroshop.app.model.entities.JobOfferEntity;

@Service
public interface IJobOfferService extends GenericCRUD<JobOfferEntity, Integer>{

	Boolean postOffer(JobOfferEntity job);
	
	List<JobOfferEntity> getListJobOfferByFields(SearchJobOfferByFieldsDTO sjobf);
}

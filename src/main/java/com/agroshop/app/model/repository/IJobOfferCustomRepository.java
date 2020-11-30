package com.agroshop.app.model.repository;

import java.util.List;

import com.agroshop.app.model.DTO.SearchJobOfferByFieldsDTO;
import com.agroshop.app.model.entities.JobOfferEntity;


public interface IJobOfferCustomRepository {
	
	public List<JobOfferEntity> getListJobOfferByFields(SearchJobOfferByFieldsDTO sjobf);
}

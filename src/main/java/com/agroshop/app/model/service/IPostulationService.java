package com.agroshop.app.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.PostulationEntity;

@Service
public interface IPostulationService extends GenericCRUD<PostulationEntity, Integer> {
	
	public String applyForAJob(Integer idJobOffer, Integer idDriver, String detail, String reply) throws Throwable;
	
	public PostulationEntity findByIdJobOfferAndIdDriver(Integer idJobOffer, Integer idDriver) throws Throwable;
	
	public boolean existsPostulationForDriver(Integer idJobOffer, Integer idDriver) throws Throwable;
	
	public List<PostulationEntity> findByStatusPostulationAndDriverId(String statusPostulation, Integer driverId) throws Throwable;
	
	public List<PostulationEntity> findPostulationByStatusPostulationAndFarmerId(String statusPostulation, Integer farmerId) throws Throwable;
	
}

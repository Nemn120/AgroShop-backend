package com.agroshop.app.model.repository.impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.agroshop.app.model.DTO.SearchJobOfferByFieldsDTO;
import com.agroshop.app.model.entities.JobOfferEntity;
import com.agroshop.app.model.repository.IJobOfferCustomRepository;
import com.agroshop.app.util.Constants;

public class IJobOfferCustomRepositoryImpl implements IJobOfferCustomRepository{

	@PersistenceContext
	 private EntityManager em;
	
	@Override
	public List<JobOfferEntity> getListJobOfferByFields(SearchJobOfferByFieldsDTO job, LocalDate date) {
		
		StringBuffer queryString = new StringBuffer(
		"SELECT jo From JobOfferEntity jo where jo.statusOffer=:statusOffer ");
		
		if(job.getPriceIni()!= null && job.getPriceFin()!= null) {
			queryString.append(" AND jo.shippingCost BETWEEN :priceIni AND :priceFin ");
		}
		if(job.getWeightIni()!= null && job.getWeightFin()!= null) {
				queryString.append(" AND jo.totalWeight BETWEEN :weightIni AND :weightFin ");
		}
		if(job.getOriginRegion()!=null){
			queryString.append(" AND jo.originRegion=:originRegion ");
		}
		if(job.getOriginProvince()!=null){
			queryString.append(" AND jo.originProvince=:originProvince ");
		}
		if(job.getOriginDistrict()!=null) {
			queryString.append(" AND jo.originDistrict=:originDistrict ");
		}
		if(job.getDestinationRegion()!=null) {
			queryString.append(" AND jo.order.destinationRegion=:destinationRegion ");
		}
		if(job.getDestinationProvince()!=null) {
			queryString.append(" AND jo.order.destinationProvince=:destinationProvince ");
		}
		if(job.getDestinationDistrict()!=null) {
			queryString.append(" AND jo.order.destinationDistrict=:destinationDistrict ");
		}

		queryString.append(" AND :fin <= jo.finalDate ORDER BY jo.createDate DESC");
		
		Query query = em.createQuery(queryString.toString(),JobOfferEntity.class);
		
		query.setParameter("statusOffer",Constants.JOB_OFFER_AVAILABLE);
		query.setParameter("fin", date);
		
		if(job.getPriceIni()!= null && job.getPriceFin()!= null) {
			query.setParameter("priceIni",job.getPriceIni());
			query.setParameter("priceFin",job.getPriceFin());
		}
		if(job.getWeightIni()!= null && job.getWeightFin()!= null) {
			query.setParameter("weightIni",job.getWeightIni());
			query.setParameter("weightFin",job.getWeightFin());
		}
		if(job.getOriginRegion()!=null) {
			query.setParameter("originRegion",job.getOriginRegion());
		}
		if(job.getOriginProvince()!=null) {
			query.setParameter("originProvince",job.getOriginProvince());
		}
		if(job.getOriginDistrict()!=null) {
			query.setParameter("originDistrict",job.getOriginDistrict());
		}
		if(job.getDestinationRegion()!=null) {
			query.setParameter("destinationRegion",job.getDestinationRegion());
		}
		if(job.getDestinationProvince()!=null) {
			query.setParameter("destinationProvince",job.getDestinationProvince());
		}
		if(job.getDestinationDistrict()!=null) {
			query.setParameter("destinationDistrict",job.getDestinationDistrict());
		}

		return query.getResultList();
	}
}

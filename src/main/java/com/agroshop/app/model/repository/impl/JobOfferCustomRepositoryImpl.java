package com.agroshop.app.model.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.agroshop.app.model.DTO.SearchJobOfferByFieldsDTO;
import com.agroshop.app.model.entities.JobOfferEntity;
import com.agroshop.app.model.repository.IJobOfferCustomRepository;
import com.agroshop.app.util.Constants;

public class JobOfferCustomRepositoryImpl implements IJobOfferCustomRepository{

	@PersistenceContext
	 private EntityManager em;
	
	@Override
	public List<JobOfferEntity> getListJobOfferByFields(SearchJobOfferByFieldsDTO job) {
		
		StringBuffer queryString = new StringBuffer(
		"SELECT jo From JobOfferEntity jo where jo.statusOffer=:statusOffer");
		
		if(job.getPriceIni()!= null && job.getPriceFin()!= null) {
			queryString.append(" AND jo.order.total BETWEEN :priceIni AND :priceFin ");
		}
		if(job.getWeightIni()!= null && job.getWeightFin()!= null) {
				queryString.append(" AND jo.totalWeight BETWEEN :weightIni AND :weightFin ");
		}
		if(job.getDateIni()!= null && job.getDateFin()!= null) {
			queryString.append(" AND jo.finalDate BETWEEN :dateIni AND :dateFin ");
		}
		if(job.getDepartmentIni()!=null){
			queryString.append(" AND jo.departmentOrigin=:deparmentIni");
		}
		if(job.getDepartmentFin()!=null){
			queryString.append(" AND jo.order.reference=:deparmentFin");
		}
		if(job.getIdFarmer()!=null) {
			queryString.append(" AND jo.order.farmer.id=:id");
		}

		Query query = em.createQuery(queryString.toString(),JobOfferEntity.class);
		
		query.setParameter("statusOffer",job.getStatus());
		
		if(job.getPriceIni()!= null && job.getPriceFin()!= null) {
			query.setParameter("priceIni",job.getPriceIni());
			query.setParameter("priceFin",job.getPriceFin());
		}
		if(job.getWeightIni()!= null && job.getWeightFin()!= null) {
			query.setParameter("weightIni",job.getWeightIni());
			query.setParameter("weightFin",job.getWeightFin());
		}
		if(job.getDateIni()!= null && job.getDateFin()!= null) {
			query.setParameter("dateIni",job.getDateIni());
			query.setParameter("dateFin",job.getDateFin());
		}
		if(job.getDepartmentIni()!=null) {
			query.setParameter("deparmentIni",job.getDepartmentIni());
		}
		if(job.getDepartmentFin()!=null) {
			query.setParameter("deparmentFin",job.getDepartmentFin());
		}
		if(job.getIdFarmer()!=null) {
			query.setParameter("id",job.getIdFarmer());
		}

		return query.getResultList();
}
}

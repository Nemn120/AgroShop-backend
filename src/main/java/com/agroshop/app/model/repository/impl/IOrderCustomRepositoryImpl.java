package com.agroshop.app.model.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.agroshop.app.model.DTO.SearchOrderByFieldsDTO;
import com.agroshop.app.model.entities.OrderEntity;
import com.agroshop.app.model.repository.IOrderCustomRepository;

public class IOrderCustomRepositoryImpl implements IOrderCustomRepository{

	@PersistenceContext
	 private EntityManager em;
	
	@Override
	public List<OrderEntity> getListOrderByFields(SearchOrderByFieldsDTO dto) {
		StringBuffer queryString = new StringBuffer(
				"SELECT o From OrderEntity o where o.farmer.id=:farmer AND o.isDeleted=False ");
		
		if(dto.getStatus()!=null) {
			queryString.append(" AND o.status=:status");
		}
		if(dto.getPriceIni()!= null && dto.getPriceFin()!= null) {
			queryString.append(" AND o.total BETWEEN :priceIni AND :priceFin ");
		}
		if(dto.getDestinationRegion()!=null) {
			queryString.append(" AND o.destinationRegion=:destinationRegion ");
		}
		if(dto.getDestinationProvince()!=null) {
			queryString.append(" AND o.destinationProvince=:destinationProvince ");
		}
		if(dto.getDestinationDistrict()!=null) {
			queryString.append(" AND o.destinationDistrict=:destinationDistrict ");
		}
		if(dto.getDateIni()!=null) {
			queryString.append(" AND o.createDate >= :dateIni");
		}
		if(dto.getDateFin()!=null) {
			queryString.append(" AND o.createDate <= :dateFin");
		}
		if(dto.getDocumentNumber()!=null) {
			queryString.append(" AND o.client.user.documentNumber=:documentNumber ");
		}
		queryString.append(" ORDER BY o.createDate DESC");
		
		queryString.append(" ORDER BY o.createDate DESC");
		
		Query query = em.createQuery(queryString.toString(), OrderEntity.class);
		
		query.setParameter("farmer",dto.getFarmer());
		
		if(dto.getStatus()!=null) {
			query.setParameter("status", dto.getStatus());
		}
		if(dto.getPriceIni()!= null && dto.getPriceFin()!= null) {
			query.setParameter("priceIni",dto.getPriceIni());
			query.setParameter("priceFin",dto.getPriceFin());
		}
		if(dto.getDestinationRegion()!=null) {
			query.setParameter("destinationRegion",dto.getDestinationRegion());
		}
		if(dto.getDestinationProvince()!=null) {
			query.setParameter("destinationProvince",dto.getDestinationProvince());
		}
		if(dto.getDestinationDistrict()!=null) {
			query.setParameter("destinationDistrict",dto.getDestinationDistrict());
		}
		if(dto.getDateIni()!=null) {
			query.setParameter("dateIni",dto.getDateIni());
		}
		if(dto.getDateFin()!=null) {
			query.setParameter("dateFin",dto.getDateFin());
		}
		if(dto.getDocumentNumber()!=null) {
			query.setParameter("documentNumber",dto.getDocumentNumber());
		}
		
		
		return query.getResultList();
	}

}

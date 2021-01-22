package com.agroshop.app.model.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.agroshop.app.model.DTO.SalesReportDTO;
import com.agroshop.app.model.entities.OrderDetailEntity;
import com.agroshop.app.model.entities.OrderEntity;
import com.agroshop.app.model.repository.IOrderDetailCustomRepository;

public class IOrderDetailCustomRepositoryImpl implements IOrderDetailCustomRepository{

	@PersistenceContext
	 private EntityManager em;
	
	@Override
	public List<Object[]> getSalesReport(SalesReportDTO dto) {
		
		StringBuffer queryString = new StringBuffer(
				" SELECT SUM(o.total), count(o), prod.name, pro.price  From OrderDetailEntity o inner join o.customOrder ord inner join  o.productSales pro "
				+ " inner join pro.product prod"
				+ " where ord.farmer.id=:farmer AND o.isDeleted=False AND o.createDate between :dateIni AND :dateFin  ");
		/*StringBuffer queryString = new StringBuffer(
				" SELECT SUM(o.total), SUM(o.quantity), o.productSales.product.name, o.productSales.price From OrderDetailEntity o where o.customOrder.farmer.id=:farmer "
				+ " AND o.isDeleted=False AND o.createDate between :dateIni AND :dateFin  ");*/
		
		if(dto.getIds()!=null ) {
			queryString.append(" AND prod.id  in (:list) ");
		}
		
		if(dto.getStatus()!=null) {
			queryString.append(" AND ord.status =:status ");
		}
		queryString.append(" Group By pro.id, prod.name ");
		Query query = em.createQuery(queryString.toString());
		
		query.setParameter("dateIni",dto.getDateIni());
		query.setParameter("dateFin",dto.getDateFin());
		query.setParameter("farmer", dto.getFarmer());
		
		if(dto.getIds()!=null && !dto.getIds().isEmpty()) {
			query.setParameter("list",dto.getIds());
		}
		if(dto.getStatus()!=null) {
			query.setParameter("status",dto.getStatus());
		}
		
		
		return query.getResultList();
	}

}

package com.agroshop.app.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.OrderDetailEntity;

@Service
public interface IOrderDetailService extends GenericCRUD<OrderDetailEntity, Integer>{
	List<OrderDetailEntity> findByOrderId(Integer id);
	
	public boolean updateOrderDetailStatus( Integer id, String status);
	
}

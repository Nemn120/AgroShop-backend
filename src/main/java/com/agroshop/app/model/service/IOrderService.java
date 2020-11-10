package com.agroshop.app.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.OrderEntity;

@Service
public interface IOrderService extends GenericCRUD<OrderEntity, Integer>{
	
	public List<OrderEntity> saveOrderByManyFarmer(OrderEntity order)  throws Throwable ;
	
	public OrderEntity saveOrderByFarmer(OrderEntity order)  throws Throwable ;

}

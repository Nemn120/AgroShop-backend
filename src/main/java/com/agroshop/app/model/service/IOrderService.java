package com.agroshop.app.model.service;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.OrderEntity;

@Service
public interface IOrderService extends GenericCRUD<OrderEntity, Integer>{

}

package com.agroshop.app.model.service;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.OrderDetailEntity;

@Service
public interface IOrderDetailService extends GenericCRUD<OrderDetailEntity, Integer>{

}

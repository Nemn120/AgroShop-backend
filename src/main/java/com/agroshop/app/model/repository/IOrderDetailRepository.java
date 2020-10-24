package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.OrderDetailEntity;

public interface IOrderDetailRepository extends JpaRepository<OrderDetailEntity, Integer>{

}

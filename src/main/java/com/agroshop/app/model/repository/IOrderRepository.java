package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.OrderEntity;

public interface IOrderRepository extends JpaRepository<OrderEntity, Integer> {

}

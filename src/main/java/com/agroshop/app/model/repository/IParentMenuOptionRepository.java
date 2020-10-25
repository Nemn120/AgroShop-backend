package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.OrderEntity;
import com.agroshop.app.model.entities.ParentMenuOptionEntity;

public interface IParentMenuOptionRepository extends JpaRepository<ParentMenuOptionEntity, Integer> {

}

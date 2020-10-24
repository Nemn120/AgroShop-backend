package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.DriverEntity;

public interface IDriverRepository extends JpaRepository<DriverEntity, Integer>{

}

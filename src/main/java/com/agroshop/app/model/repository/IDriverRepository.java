package com.agroshop.app.model.repository;

import java.util.List;

import com.agroshop.app.model.entities.DriverEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDriverRepository extends JpaRepository<DriverEntity, Integer>{
    List<DriverEntity> findByStatus(String status);
}

package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.FarmerEntity;

public interface IFarmerRepository extends JpaRepository<FarmerEntity, Integer>{

}

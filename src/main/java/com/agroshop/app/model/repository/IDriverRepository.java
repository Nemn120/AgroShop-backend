package com.agroshop.app.model.repository;

import java.util.List;

import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.entities.FarmerEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IDriverRepository extends JpaRepository<DriverEntity, Integer>{
    List<DriverEntity> findByStatus(String status);
    
	@Query("SELECT driver FROM DriverEntity driver INNER JOIN  driver.user u WHERE u.username=:username")
	public DriverEntity getUserByUsername(@Param("username") String username);
	
	
}

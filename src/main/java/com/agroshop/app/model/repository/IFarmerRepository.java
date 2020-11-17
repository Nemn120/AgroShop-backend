package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.FarmerEntity;

public interface IFarmerRepository extends JpaRepository<FarmerEntity, Integer>{
	
	@Query("SELECT farmer FROM FarmerEntity farmer INNER JOIN  farmer.user  us where us.username=:username")
	public FarmerEntity getUserByUsername(@Param("username") String username);
	
	@Query("SELECT farmer FROM FarmerEntity farmer where farmer.id=:id")
	public FarmerEntity getFarmerById(@Param("id") Integer id);
	
}

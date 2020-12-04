package com.agroshop.app.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.JobProfileEntity;
public interface IJobProfileRepository extends JpaRepository<JobProfileEntity, Integer>{
	@Query("SELECT od FROM JobProfileEntity od WHERE  od.driver.id=:driverId")
	JobProfileEntity findByDriverId(@Param("driverId")Integer driverId);

}

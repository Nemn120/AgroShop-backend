package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.JobProfileEntity;

public interface IJobProfileRepository extends JpaRepository<JobProfileEntity, Integer>{
	

}

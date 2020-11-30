package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.JobOfferEntity;

public interface IJobOfferRepository extends IJobOfferCustomRepository, JpaRepository<JobOfferEntity,Integer>{


}

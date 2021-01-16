package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.PlaceEntity;

public interface IPlaceRepository extends JpaRepository<PlaceEntity, Integer>{

}

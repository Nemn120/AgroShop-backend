package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.CatalogDetailEntity;

public interface ICatalogDetailRepository extends JpaRepository<CatalogDetailEntity, Integer>{

}

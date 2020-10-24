package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.CatalogEntity;

public interface ICatalogRepository extends JpaRepository<CatalogEntity, Integer>{

}

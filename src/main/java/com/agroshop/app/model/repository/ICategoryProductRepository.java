package com.agroshop.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.CategoryProductEntity;

public interface ICategoryProductRepository extends JpaRepository<CategoryProductEntity, Integer> {

}

package com.agroshop.app.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.ProductEntity;

public interface IProductRepository  extends JpaRepository<ProductEntity, Integer> {
	List<ProductEntity> findByCategoryId(Integer categoryId);
}

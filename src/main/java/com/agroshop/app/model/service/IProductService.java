package com.agroshop.app.model.service;

import java.util.List;

import com.agroshop.app.model.entities.ProductEntity;

public interface IProductService extends GenericCRUD<ProductEntity, Integer>{
	List<ProductEntity> findByCategoryId(Integer categoryId);
}

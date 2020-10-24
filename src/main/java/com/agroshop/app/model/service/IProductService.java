package com.agroshop.app.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.ProductEntity;

@Service
public interface IProductService extends GenericCRUD<ProductEntity, Integer>{
	List<ProductEntity> findByCategoryId(Integer categoryId);
}

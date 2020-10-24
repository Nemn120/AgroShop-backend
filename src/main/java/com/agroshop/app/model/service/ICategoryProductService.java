package com.agroshop.app.model.service;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.CategoryProductEntity;

@Service
public interface ICategoryProductService extends GenericCRUD<CategoryProductEntity, Integer>{

}

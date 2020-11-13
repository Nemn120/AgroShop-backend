package com.agroshop.app.model.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.CategoryProductEntity;

@Service
public interface ICategoryProductService extends GenericCRUD<CategoryProductEntity, Integer>{

	public List<CategoryProductEntity> getListCategory(Integer id);
}

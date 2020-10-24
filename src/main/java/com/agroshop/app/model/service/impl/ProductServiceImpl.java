package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.agroshop.app.model.entities.ProductEntity;
import com.agroshop.app.model.repository.IProductRepository;
import com.agroshop.app.model.service.IProductService;

public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IProductRepository productRepo;
	
	@Override
	public ProductEntity getOneById(Integer id) {
		return productRepo.getOne(id);
	}

	@Override
	public void deleteById(Integer id) {
		productRepo.deleteById(id);
	}

	@Override
	public List<ProductEntity> getAll() {
		return productRepo.findAll();
	}

	@Override
	public ProductEntity save(ProductEntity t) {
		return productRepo.save(t);
	}

	@Override
	public List<ProductEntity> findByCategoryId(Integer categoryId) {
		return productRepo.findByCategoryId(categoryId);
	}
	
}

package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.CategoryProductEntity;
import com.agroshop.app.model.repository.ICategoryProductRepository;
import com.agroshop.app.model.service.ICategoryProductService;

@Service
public class CategoryProductServiceImpl implements ICategoryProductService {
	
	@Autowired
	private ICategoryProductRepository categoryRepo;
	
	@Override
	public CategoryProductEntity getOneById(Integer id) {
		return categoryRepo.getOne(id);
	}

	@Override
	public void deleteById(Integer id) {
		categoryRepo.deleteById(id);
	}

	@Override
	public List<CategoryProductEntity> getAll() {
		return categoryRepo.findAll();
	}

	@Override
	public CategoryProductEntity save(CategoryProductEntity t) {
		return categoryRepo.save(t);
	}
	
}

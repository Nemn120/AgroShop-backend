package com.agroshop.app.model.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.controller.rest.CategoryProductController;
import com.agroshop.app.model.entities.CategoryProductEntity;
import com.agroshop.app.model.entities.ProductEntity;
import com.agroshop.app.model.repository.ICategoryProductRepository;
import com.agroshop.app.model.service.ICategoryProductService;

@Service
public class CategoryProductServiceImpl implements ICategoryProductService {
	

	private static final Logger logger = LogManager.getLogger(CategoryProductServiceImpl.class);	
	@Autowired
	private ICategoryProductRepository categoryRepo;
	
	@Override
	public CategoryProductEntity getOneById(Integer id) {
		return categoryRepo.findById(id).orElse(new CategoryProductEntity());
	}

	@Override
	public void deleteById(Integer id) {
		CategoryProductEntity pro = categoryRepo.findById(id).orElse(new CategoryProductEntity());
		logger.info(pro.getName() +" "+pro.getId() + " "+ pro.getIsDeleted());
		if(!pro.getName().isEmpty() && pro.getIsDeleted() == false ) {
			pro.setIsDeleted(true);
			categoryRepo.save(pro);
		}
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

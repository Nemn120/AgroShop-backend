package com.agroshop.app.model.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import com.agroshop.app.controller.rest.ProductController;
import com.agroshop.app.model.entities.ProductEntity;
import com.agroshop.app.model.repository.IProductRepository;
import com.agroshop.app.model.service.IProductService;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
	

	private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);
	@Autowired
	private IProductRepository productRepo;
	
	@Override
	public ProductEntity getOneById(Integer id) {
		return productRepo.findById(id).orElse(new ProductEntity());
	}

	@Override
	public void deleteById(Integer id) {
		ProductEntity pro = productRepo.findById(id).orElse(new ProductEntity());
		if(!pro.getName().isEmpty() && pro.getIsDeleted() != true) {
			pro.setIsDeleted(true);
			productRepo.save(pro);
		}
	}

	@Override
	public List<ProductEntity> getAll() {
		return productRepo.findAll();
	}

	@Override
	public ProductEntity save(ProductEntity t) {
		ProductEntity product = productRepo.save(t);
		if(t.getPhoto() != null && t.getPhoto().length>0)
			productRepo.updatePhoto(product.getId(),t.getPhoto());
		return product; 
	}

	@Override
	public List<ProductEntity> findByCategoryId(Integer categoryId) {
		return productRepo.findByCategoryId(categoryId);
	}

	@Override
	public List<ProductEntity> getListProductByFarmer(Integer id) {
		return productRepo.getListProductByFarmer(id);
	}
	
}

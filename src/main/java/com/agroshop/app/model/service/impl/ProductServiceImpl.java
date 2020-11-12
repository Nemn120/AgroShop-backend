package com.agroshop.app.model.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.ProductEntity;
import com.agroshop.app.model.repository.IProductRepository;
import com.agroshop.app.model.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	
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
		if(t.getPhoto() != null &&  t.getPhoto().length>0) {
			productRepo.updatePhoto(t.getId(),t.getPhoto());
		}
		return productRepo.save(t);
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

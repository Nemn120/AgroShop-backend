package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.agroshop.app.model.entities.ProductSalesEntity;
import com.agroshop.app.model.repository.IProductSalesRepository;
import com.agroshop.app.model.service.IProductSalesService;

public class ProductSalesServiceImpl implements IProductSalesService {
	
	@Autowired
	private IProductSalesRepository salesRepository;
	
	@Override
	public ProductSalesEntity getOneById(Integer id) {
		return salesRepository.getOne(id);
	}

	@Override
	public void deleteById(Integer id) {
		salesRepository.deleteById(id);
		
	}

	@Override
	public List<ProductSalesEntity> getAll() {
		return salesRepository.findAll();
	}

	@Override
	public ProductSalesEntity save(ProductSalesEntity t) {
		return salesRepository.save(t);
	}

	@Override
	public List<ProductSalesEntity> findByIdSalesOrderByPriceAsc(int idSales) {
		return salesRepository.findByIdSalesOrderByPriceAsc(idSales);
	}
	
}

package com.agroshop.app.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.ProductSalesEntity;

@Service
public interface IProductSalesService extends GenericCRUD<ProductSalesEntity, Integer> {
	List<ProductSalesEntity> findByIdSalesOrderByPriceAsc(int idSales);
}

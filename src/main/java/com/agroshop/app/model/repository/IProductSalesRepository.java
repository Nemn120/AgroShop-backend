package com.agroshop.app.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.ProductSalesEntity;

public interface IProductSalesRepository extends JpaRepository<ProductSalesEntity, Integer> {
	//List<ProductSalesEntity> findByIdSalesOrderByPriceAsc(int idSales);
}

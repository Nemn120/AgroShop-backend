package com.agroshop.app.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.ProductSalesEntity;

@Service
public interface IProductSalesService extends GenericCRUD<ProductSalesEntity, Integer> {
	List<ProductSalesEntity> findByIdSalesOrderByPriceAsc(int idSales);
	
	Map<Integer,List<ProductSalesEntity>> getListSearchProductSales(String searchProduct, String status, String sales);
	
	List<ProductSalesEntity> getListProductSalesByFarmer(Integer id);
	
	List<ProductSalesEntity> getListProductSalesByFarmerAndStatus(Integer id, String status);
	
	ProductSalesEntity getProdutSalesByIdAndStatusAndStatusSales(Integer id,String status, String statusSales);
	
	List<ProductSalesEntity> getProdutSalesByStatusAndStatusSales(String status, String statusSales);
	
	ProductSalesEntity checkProductSalesAndSave(ProductSalesEntity t);
}

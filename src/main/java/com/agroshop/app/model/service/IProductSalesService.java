package com.agroshop.app.model.service;

import java.util.List;
import java.util.Map;

import com.agroshop.app.model.DTO.SearchProductSalesByFieldsDTO;
import com.agroshop.app.model.entities.ProductSalesEntity;

import org.springframework.stereotype.Service;

@Service
public interface IProductSalesService extends GenericCRUD<ProductSalesEntity, Integer> {
	List<ProductSalesEntity> findByIdSalesOrderByPriceAsc(int idSales);
	
	Map<Integer,List<ProductSalesEntity>> getListSearchProductSales(String searchProduct, String status, String sales);
	
	List<ProductSalesEntity> getListProductSalesByFarmer(Integer id);
	
	List<ProductSalesEntity> getListProductSalesByFarmerAndStatus(Integer id, String status);
	
	ProductSalesEntity getProdutSalesByIdAndStatusAndStatusSales(Integer id,String status, String statusSales);
	
	List<ProductSalesEntity> getProdutSalesByStatusAndStatusSales(String status, String statusSales);
	
	ProductSalesEntity checkProductSalesAndSave(ProductSalesEntity t);

	List<ProductSalesEntity> getListProductSalesByFields(SearchProductSalesByFieldsDTO spsbf);
	
	ProductSalesEntity saveAssessmentProductSalesById(Integer id, Integer assessment);

}

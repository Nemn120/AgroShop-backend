package com.agroshop.app.model.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.controller.rest.ProductSalesController;
import com.agroshop.app.model.entities.ProductEntity;
import com.agroshop.app.model.entities.ProductSalesEntity;
import com.agroshop.app.model.repository.IProductSalesRepository;
import com.agroshop.app.model.service.IProductSalesService;
import com.agroshop.app.util.Constants;

@Service
public class ProductSalesServiceImpl implements IProductSalesService {
	

	private static final Logger logger = LogManager.getLogger(IProductSalesService.class);
	@Autowired
	private IProductSalesRepository salesRepository;
	
	@Override
	public ProductSalesEntity getOneById(Integer id) {
		return salesRepository.findById(id).orElse(new ProductSalesEntity());
	}

	@Override
	public void deleteById(Integer id) {
		ProductSalesEntity pro = salesRepository.findById(id).orElse(new ProductSalesEntity());
		if(pro.getIsDeleted()!=true && pro.getCreateDate()!=null) {
			pro.setIsDeleted(true);
			salesRepository.save(pro);
		}
		
	}

	@Override
	public List<ProductSalesEntity> getAll() {
		return salesRepository.findAll();
	}

	@Override
	public ProductSalesEntity save(ProductSalesEntity t) {
		if(t.getTotalQuantity() == null)
		t.setTotalQuantity(0);
		if(t.getAvailableQuantity() == null){
			t.setAvailableQuantity(t.getTotalQuantity());	
		}
		if(t.getTotalQuantity()>0)
			t.setStatusSales(Constants.PRODUCT_SALES_STATUS_AVAILABLE);
		if(t.getTotalQuantity() ==0)
			t.setStatusSales(Constants.PRODUCT_SALES_STATUS_NOT_AVAILABLE);
		if(t.getStatus() == null)
			t.setStatus(Constants.STATUS_OFF_ENTITY);
		if(t.getId()!=null) {
			ProductSalesEntity pro = salesRepository.findById(t.getId()).orElse(new ProductSalesEntity());
			t.setUserCreateId(pro.getUserCreateId());
			t.setIsDeleted(pro.getIsDeleted());
			t.setCreateDate(pro.getCreateDate());
		}
		return salesRepository.save(t);
	}

	@Override
	public List<ProductSalesEntity> findByIdSalesOrderByPriceAsc(int idSales) {
		return null; //salesRepository.findByIdSalesOrderByPriceAsc(idSales);
	}

	@Override
	public Map<Integer, List<ProductSalesEntity>> getListSearchProductSales(String searchProduct, String status, String sales) {
		List<ProductSalesEntity> productSearch = salesRepository.getListSearchProductSales(searchProduct, status, sales);
		
		 Map<Integer,List<ProductSalesEntity>> mapSearch= new HashMap<Integer,List<ProductSalesEntity>>();
		 
		 productSearch.forEach(product ->{
			 if(mapSearch.containsKey(product.getFarmerNumber())){
				 logger.info(product.getFarmerNumber());
				 mapSearch.get(product.getFarmerNumber()).add(product);
			 }else {
				 List<ProductSalesEntity> productList = new ArrayList<>();
				 productList.add(product);
				 logger.info(product.getFarmerNumber());
				 mapSearch.put(product.getFarmerNumber(),productList);
			 }
		 });
		 
		 return mapSearch;
	}

	@Override
	public List<ProductSalesEntity> getListProductSalesByFarmer(Integer id) {
		return salesRepository.getListProductSalesByFarmer(id);
	}

	@Override
	public List<ProductSalesEntity> getListProductSalesByFarmerAndStatus(Integer id, String status) {
		return salesRepository.getListProductSalesByFarmerAndStatus(id, status);
	}

	@Override
	public ProductSalesEntity getProdutSalesByIdAndStatusAndStatusSales(Integer id, String status, String statusSales) {
		return salesRepository.findByIdAndStatusAndStatusSales(id, status, statusSales);
	}
	
	@Override
	public List<ProductSalesEntity> getProdutSalesByStatusAndStatusSales(String status, String statusSales) {
		return salesRepository.findByStatusAndStatusSales(status,statusSales);
	}
	


	
}

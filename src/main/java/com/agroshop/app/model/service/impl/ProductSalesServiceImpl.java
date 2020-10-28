package com.agroshop.app.model.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.ProductSalesEntity;
import com.agroshop.app.model.repository.IProductSalesRepository;
import com.agroshop.app.model.service.IProductSalesService;

@Service
public class ProductSalesServiceImpl implements IProductSalesService {
	
	@Autowired
	private IProductSalesRepository salesRepository;
	
	@Override
	public ProductSalesEntity getOneById(Integer id) {
		return salesRepository.findById(id).orElse(new ProductSalesEntity());
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
		return null; //salesRepository.findByIdSalesOrderByPriceAsc(idSales);
	}

	@Override
	public Map<Integer, List<ProductSalesEntity>> getListSearchProductSales(String searchProduct, String status) {
		List<ProductSalesEntity> productSearch = salesRepository.getListSearchProductSales(searchProduct, status);
		
		 Map<Integer,List<ProductSalesEntity>> mapSearch= new HashMap<Integer,List<ProductSalesEntity>>();
		 
		 productSearch.forEach(product ->{
			 if(mapSearch.containsKey(product.getOrganizationId())){
				 mapSearch.get(product.getOrganizationId()).add(product);
			 }else {
				 List<ProductSalesEntity> productList = new ArrayList<>();
				 productList .add(product);
				 mapSearch.put(product.getOrganizationId(),productList);
			 }
		 });
		 
		 return mapSearch;
	}
	


	
}

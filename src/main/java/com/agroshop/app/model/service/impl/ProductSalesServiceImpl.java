package com.agroshop.app.model.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agroshop.app.model.DTO.SearchProductSalesByFieldsDTO;
import com.agroshop.app.model.entities.ProductSalesEntity;
import com.agroshop.app.model.repository.IProductSalesRepository;
import com.agroshop.app.model.service.ICategoryProductService;
import com.agroshop.app.model.service.IPlaceService;
import com.agroshop.app.model.service.IProductSalesService;
import com.agroshop.app.util.Constants;

@Service
@Transactional
public class ProductSalesServiceImpl implements IProductSalesService {

	private static final Logger logger = LogManager.getLogger(IProductSalesService.class);
	@Autowired
	private IProductSalesRepository salesRepository;

	@Autowired
	private IPlaceService placeService;

	@Autowired
	private IProductSalesRepository productSalesRepo;

	
	@Autowired
	private ICategoryProductService categoryService;

	@Override
	public ProductSalesEntity getOneById(Integer id) {
		return salesRepository.findById(id).orElse(new ProductSalesEntity());
	}

	@Override
	public void deleteById(Integer id) {
		ProductSalesEntity pro = salesRepository.findById(id).orElse(new ProductSalesEntity());
		if (pro.getIsDeleted() != true && pro.getCreateDate() != null) {
			pro.setIsDeleted(true);
			salesRepository.save(pro);
		}

	}

	@Override
	public List<ProductSalesEntity> getAll() {
		/*
		 * ProductSalesEntity pro = salesRepository.findById(8).orElse(new
		 * ProductSalesEntity()); pro.setIsDeleted(false); salesRepository.save(pro);
		 */
		return salesRepository.findAll();
	}

	@Override
	public ProductSalesEntity save(ProductSalesEntity t) {

		return salesRepository.save(t);
	}

	@Override
	public List<ProductSalesEntity> findByIdSalesOrderByPriceAsc(int idSales) {
		return null; // salesRepository.findByIdSalesOrderByPriceAsc(idSales);
	}

	@Override
	public Map<Integer, List<ProductSalesEntity>> getListSearchProductSales(String searchProduct, String status,
			String sales) {
		List<ProductSalesEntity> productSearch = salesRepository.getListSearchProductSales(searchProduct, status,
				sales);

		Map<Integer, List<ProductSalesEntity>> mapSearch = new HashMap<Integer, List<ProductSalesEntity>>();

		productSearch.forEach(product -> {
			if (mapSearch.containsKey(product.getFarmerNumber())) {
				logger.info(product.getFarmerNumber());
				mapSearch.get(product.getFarmerNumber()).add(product);
			} else {
				List<ProductSalesEntity> productList = new ArrayList<>();
				productList.add(product);
				logger.info(product.getFarmerNumber());
				mapSearch.put(product.getFarmerNumber(), productList);
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
		return salesRepository.findByStatusAndStatusSales(status, statusSales);
	}

	@Override
	public ProductSalesEntity checkProductSalesAndSave(ProductSalesEntity t) {
		if (t.getTotalQuantity() == null)
			t.setTotalQuantity(0);
		if (t.getAvailableQuantity() == null) {
			t.setAvailableQuantity(t.getTotalQuantity());
		}
		if (t.getAvailableQuantity() > 0)
			t.setStatusSales(Constants.PRODUCT_SALES_STATUS_AVAILABLE);
		if (t.getAvailableQuantity() == 0)
			t.setStatusSales(Constants.PRODUCT_SALES_STATUS_NOT_AVAILABLE);
		if (t.getStatus() == null)
			t.setStatus(Constants.STATUS_OFF_ENTITY);
		if (t.getId() != null) {
			ProductSalesEntity pro = salesRepository.findById(t.getId()).orElse(new ProductSalesEntity());
			t.setUserCreateId(pro.getUserCreateId());
			t.setIsDeleted(pro.getIsDeleted());
			t.setCreateDate(pro.getCreateDate());
		}
		if(t.getOriginPlace() != null)
			t.setOriginPlace(placeService.save(t.getOriginPlace()));
		return this.save(t);
	}

	@Override
	public ProductSalesEntity saveAssessmentProductSalesById(Integer id, Integer assessment) {
		
		ProductSalesEntity pro = this.getOneById(id);
		if(pro.getId()!= null) {
			Integer as;
			if(pro.getAssessment()==null)
				as=assessment;
			else
				as=(int) Math.round((pro.getAssessment()+assessment)/2.0);
			
			salesRepository.updateAssessment(id, as);
			pro.setAssessment(as);
		}
		return pro;
	}
	
	@Override
	public List<ProductSalesEntity> getListProductSalesByFields(SearchProductSalesByFieldsDTO spsbf) {
		LocalDate date = LocalDate.now();
		logger.info("date: " + date);
		return productSalesRepo.getListProductSalesByFields(spsbf, date);
	}

}

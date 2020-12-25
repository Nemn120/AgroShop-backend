package com.agroshop.app.controller.rest;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.AbstractResponse;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.entities.CategoryProductEntity;
import com.agroshop.app.model.service.ICategoryProductService;
import com.agroshop.app.util.Constants;

@RestController
@RequestMapping("/categoryproduct")
public class CategoryProductController{
	@Autowired
	private ICategoryProductService categoryProductService;
	private static final Logger logger = LogManager.getLogger(CategoryProductController.class);	
	
	@PostMapping(path="/scp")
	public  GenericResponse<CategoryProductEntity> saveCategoryProduct(@RequestBody GenericRequest<CategoryProductEntity> request){
		
		GenericResponse<CategoryProductEntity> response = new GenericResponse<CategoryProductEntity>();
		try {
			
			response.setData(categoryProductService.save(request.getData()));
			response.setResponseMessage(Constants.SUCCESS_REGISTER);
			response.setResponseCode(Constants.SUCCESS_PETITION_REQUEST);
			response.setFinalTimesTamp(LocalDateTime.now());
		}catch(Exception e) {
			response.setResponseMessage(Constants.ERROR_CREATING_CATEGORY_PRODUCT);
			response.setResponseCode(AbstractResponse.ERROR);
		}
		return response;
	}
	
	@PostMapping(path="/dcp")
	public GenericResponse<CategoryProductEntity> deleteCategoryProduct(@RequestBody GenericRequest<CategoryProductEntity> request){
		
		GenericResponse<CategoryProductEntity> response = new GenericResponse<CategoryProductEntity>();
		try {
			logger.info(request.getData().getId());
			categoryProductService.deleteById(request.getData().getId());
			
			response.setResponseMessage("Se borró la categoria con exitoso");
			response.setResponseCode(Constants.SUCCESS_PETITION_REQUEST);
			response.setFinalTimesTamp(LocalDateTime.now());
		}catch(Exception e) {
			response.setResponseMessage(Constants.ERROR_DELETING_CATEGORY_PRODUCT);
			response.setResponseCode(AbstractResponse.ERROR);
		}
		
		
		return response;
	}
	
	@PostMapping(path="/gcp")
	public GenericResponse<CategoryProductEntity> getAllCategoryProduct(@RequestBody GenericRequest<CategoryProductEntity> request){
		logger.info("info");
		GenericResponse<CategoryProductEntity> response = new GenericResponse<CategoryProductEntity>();
		response.setDatalist(categoryProductService.getListCategory(request.getData().getUserCreateId()));
		return response;
	}
	
}

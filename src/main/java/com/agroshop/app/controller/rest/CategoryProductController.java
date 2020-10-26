package com.agroshop.app.controller.rest;

import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.AbstractResponse;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.beans.CategoryProductBean;
import com.agroshop.app.model.entities.CategoryProductEntity;
import com.agroshop.app.model.service.ICategoryProductService;

@RestController
@RequestMapping("/categoryproduct")
public class CategoryProductController{
	@Autowired
	private ICategoryProductService categoryProductService;
	private static final Logger logger = LogManager.getLogger(CategoryProductController.class);	
	@PostMapping(path="/scp")
	public  GenericResponse<CategoryProductBean> saveCategoryProduct(@RequestBody GenericRequest<CategoryProductBean> request){
		GenericResponse<CategoryProductBean> response = new GenericResponse<CategoryProductBean>();
		try {
			//response.setData(this.categoryProductService.save(request.getData()));
			
			CategoryProductEntity catProductEntity= new CategoryProductEntity();
			BeanUtils.copyProperties(request.getData(), catProductEntity);
			BeanUtils.copyProperties(categoryProductService.save(catProductEntity),request.getData());
			response.setData(request.getData());
			response.setResponseMessage("Producto registrado");
			response.setFinalTimesTamp(LocalDateTime.now());
			response.setResponseCode(AbstractResponse.SUCCESS);
		}catch(Exception e) {
			response.setResponseMessage("Error al guardar categoria");
			response.setResponseCode(AbstractResponse.ERROR);
		}
		return response;
	}
	
}

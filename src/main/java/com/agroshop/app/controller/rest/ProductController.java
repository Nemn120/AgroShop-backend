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
import com.agroshop.app.model.entities.ProductEntity;
import com.agroshop.app.model.entities.ProductSalesEntity;
import com.agroshop.app.model.service.IProductService;
import com.agroshop.app.util.Constants;

@RestController
@RequestMapping("/product")
public class ProductController {

	String path = "http://localhost:8080/product";
	private static final Logger logger = LogManager.getLogger(ProductController.class);
	
	@Autowired
	IProductService productService;
	
	@PostMapping(path="/sp")
	public GenericResponse<ProductEntity> saveProduct(@RequestBody GenericRequest<ProductEntity> request){
		logger.info("saveProduct");
		GenericResponse<ProductEntity> response = new GenericResponse<ProductEntity>();
		
		try {
			response.setData(productService.save(request.getData()));
			response.setFinalTimesTamp(LocalDateTime.now());
			response.setResponseMessage(Constants.SUCCESS_REGISTER);
			response.setResponseCode(Constants.SUCCESS_PETITION_REQUEST);
			
		}catch(Exception e) {
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage(Constants.ERROR_CREATING_PRODUCT);
			logger.error(e.getMessage());
		}
		
		return response;
	}
	
	@PostMapping(path="/dp")
	public GenericResponse<ProductEntity> deleteProduct(@RequestBody GenericRequest<ProductEntity> request){
		logger.info("deleteProductSales");
		GenericResponse<ProductEntity> response = new GenericResponse<ProductEntity>();
		
		try {
			productService.deleteById(request.getData().getId());
			response.setFinalTimesTamp(LocalDateTime.now());
			response.setResponseMessage("Se borró el producto con exitoso");
			response.setResponseCode(Constants.SUCCESS_PETITION_REQUEST);
			
		}catch(Exception e) {
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage(Constants.ERROR_DELETING_PRODUCT);
			logger.error(e.getMessage());
		}
		
		return response;
	}
	
	@PostMapping(path="/glpbf")
	public GenericResponse<ProductEntity> getListProductByFarmer(@RequestBody GenericRequest<ProductEntity> request){
		
		GenericResponse<ProductEntity> response = new GenericResponse<ProductEntity>();
		try {
			response.setDatalist(productService.getListProductByFarmer(request.getData().getUserCreateId()));
			response.setResponseMessage("productos mostrados exitosamente");
			response.setFinalTimesTamp(LocalDateTime.now());
			response.setResponseCode(AbstractResponse.SUCCESS);
		}catch(Exception e) {
			response.setResponseMessage("Error al mostrar productos");
			response.setResponseCode(AbstractResponse.ERROR);
		}
		
		return response;
	}
	
}

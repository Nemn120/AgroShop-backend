package com.agroshop.app.controller.rest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.agroshop.app.model.entities.ProductSalesEntity;
import com.agroshop.app.model.entities.VehicleEntity;
import com.agroshop.app.model.service.IProductSalesService;
import com.agroshop.app.util.Constants;

@RestController
@RequestMapping("/productsales")
public class ProductSalesController {

	String path = "http://localhost:8080/productsales";
	private static final Logger logger = LogManager.getLogger(ProductSalesController.class);	
	
	@Autowired
	IProductSalesService productSalesService;
	
	@PostMapping(path="/glsps")
	public GenericResponse<ProductSalesEntity> getListSearchProductSales(@RequestBody GenericRequest<ProductSalesEntity> request){
		logger.info("getListSearchProductSales");
		GenericResponse<ProductSalesEntity> response = new GenericResponse<ProductSalesEntity>();
		
		try {
			ProductSalesEntity pro = request.getData();
			logger.info("El producto es: "+ pro.getProduct().getName());
			Map<Integer,List<ProductSalesEntity>> res = productSalesService.getListSearchProductSales(pro.getProduct().getName(), 
					Constants.PRODUCT_SALES_STATUS_AVAILABLE, Constants.PRODUCT_SALES_STATUS_ACTIVE);
			

			if(!res.isEmpty())
				response.setResponseMessage("Se encontró el producto buscado");
			else
				response.setResponseMessage("No se encontraron productos");
			
			response.setDataMap(res);
			response.setFinalTimesTamp(LocalDateTime.now());
			response.setResponseCode(AbstractResponse.SUCCESS);
			
		}catch(Exception e) {
			response.setResponseMessage("Error al buscar producto");
			response.setResponseCode(AbstractResponse.ERROR);
			logger.error(e);
		}
		
		return response;
	}
	
	@PostMapping(path="/sps")
	public GenericResponse<ProductSalesEntity> saveProductSales(@RequestBody GenericRequest<ProductSalesEntity> request){
		logger.info("saveProductSales");
		GenericResponse<ProductSalesEntity> response = new GenericResponse<ProductSalesEntity>();
		
		try {
			response.setData(productSalesService.save(request.getData()));
			response.setFinalTimesTamp(LocalDateTime.now());
			response.setResponseMessage(Constants.SUCCESS_REGISTER);
			response.setResponseCode(Constants.SUCCESS_PETITION_REQUEST);
			
		}catch(Exception e) {
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage(Constants.ERROR_REGISTER_MESSAGE);
			logger.error(e.getMessage());
		}
		
		return response;
	}
	
	@PostMapping(path="/dps")
	public GenericResponse<ProductSalesEntity> deleteProductSales(@RequestBody GenericRequest<ProductSalesEntity> request){
		logger.info("deleteProductSales");
		GenericResponse<ProductSalesEntity> response = new GenericResponse<ProductSalesEntity>();
		
		try {
			productSalesService.deleteById(request.getData().getId());
			response.setFinalTimesTamp(LocalDateTime.now());
			response.setResponseMessage(Constants.ERROR_DELETING_PRODUCT_SALES);
			response.setResponseCode(Constants.SUCCESS_PETITION_REQUEST);
			
		}catch(Exception e) {
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage(Constants.ERROR_REGISTER_MESSAGE);
			logger.error(e.getMessage());
		}
		
		return response;
	}
	
	@PostMapping(path="/glpsbf")
	public GenericResponse<ProductSalesEntity> getListProductSalesByFarmer(@RequestBody GenericRequest<ProductSalesEntity> request){
		
		GenericResponse<ProductSalesEntity> response = new GenericResponse<ProductSalesEntity>();
		try {
			response.setDatalist(productSalesService.getListProductSalesByFarmer(request.getData().getFarmerNumber()));
			response.setResponseMessage("productos mostrados exitosamente");
			response.setFinalTimesTamp(LocalDateTime.now());
			response.setResponseCode(AbstractResponse.SUCCESS);
		}catch(Exception e) {
			response.setResponseMessage("Error al mostrar productos");
			response.setResponseCode(AbstractResponse.ERROR);
		}
		
		return response;
	}
	
	@PostMapping(path="/glpsbfas")
	public GenericResponse<ProductSalesEntity> getListProductSalesByFarmerAndStatus(@RequestBody GenericRequest<ProductSalesEntity> request){
		
		GenericResponse<ProductSalesEntity> response = new GenericResponse<ProductSalesEntity>();
		try {
			response.setDatalist(productSalesService.getListProductSalesByFarmerAndStatus(request.getData().getFarmerNumber(),request.getData().getStatus()));
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

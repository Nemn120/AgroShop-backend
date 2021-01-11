package com.agroshop.app.controller.rest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.AbstractResponse;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.entities.CategoryProductEntity;
import com.agroshop.app.model.entities.ProductEntity;
import com.agroshop.app.model.entities.ProductSalesEntity;
import com.agroshop.app.model.entities.VehicleEntity;
import com.agroshop.app.model.service.ICategoryProductService;
import com.agroshop.app.model.service.IProductSalesService;
import com.agroshop.app.util.Constants;

@RestController
@RequestMapping("/productsales")
public class ProductSalesController {

	String path = "http://localhost:8080/productsales";
	private static final Logger logger = LogManager.getLogger(ProductSalesController.class);	
	
	@Autowired
	IProductSalesService productSalesService;
	
	@Autowired
	private ICategoryProductService categoryService;
	
	@PostMapping(path="/glsps")
	public GenericResponse<ProductSalesEntity> getListSearchProductSales(@RequestBody GenericRequest<ProductSalesEntity> request){
		logger.info("ProductSalesController.getListSearchProductSales");
		GenericResponse<ProductSalesEntity> response = new GenericResponse<ProductSalesEntity>();
		
		try {
			ProductSalesEntity pro = request.getData();
			logger.info("El producto es: "+ pro.getProduct().getName());
			Map<Integer,List<ProductSalesEntity>> res = productSalesService.getListSearchProductSales(pro.getProduct().getName(), 
					 Constants.STATUS_ON_ENTITY, Constants.PRODUCT_SALES_STATUS_AVAILABLE);
			

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
			logger.error(e.getMessage());
		}
		
		return response;
	}
	
	@PostMapping(path="/sps")
	public GenericResponse<ProductSalesEntity> saveProductSales(@RequestBody GenericRequest<ProductSalesEntity> request){
		logger.info("saveProductSales");
		GenericResponse<ProductSalesEntity> response = new GenericResponse<ProductSalesEntity>();
		
		try {
			response.setData(productSalesService.checkProductSalesAndSave(request.getData()));
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
			logger.info(e.getMessage());
			logger.info(e.getCause());
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage(Constants.ERROR_REGISTER_MESSAGE);

		}
		
		return response;
	}
	
	@PostMapping(path="/glpsbf")
	public GenericResponse<ProductSalesEntity> getListProductSalesByFarmer(@RequestBody GenericRequest<ProductSalesEntity> request){
		
		GenericResponse<ProductSalesEntity> response = new GenericResponse<ProductSalesEntity>();
		try {
			List<ProductSalesEntity> list = productSalesService.getListProductSalesByFarmer(request.getData().getFarmerNumber());
			if(!list.isEmpty())
				response.setResponseMessage("productos mostrados exitosamente");
			else
				response.setResponseMessage("No se encontraron productos");
			response.setDatalist(list);
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
			List<ProductSalesEntity> list = productSalesService.getListProductSalesByFarmerAndStatus(request.getData().getFarmerNumber(),request.getData().getStatus());
			if(!list.isEmpty())
				response.setResponseMessage("productos mostrados exitosamente");
			else
				response.setResponseMessage("No se encontraron productos");
			response.setDatalist(list);
			response.setFinalTimesTamp(LocalDateTime.now());
			response.setResponseCode(AbstractResponse.SUCCESS);
		}catch(Exception e) {
			response.setResponseMessage("Error al mostrar productos");
			response.setResponseCode(AbstractResponse.ERROR);
		}
		
		return response;
	}
	
	@PostMapping(path="/glps")
	public GenericResponse<ProductSalesEntity> getAllProductSales(@RequestBody GenericRequest<ProductSalesEntity> request){
		GenericResponse<ProductSalesEntity> response = new GenericResponse<ProductSalesEntity>();
		try {
			response.setDatalist(productSalesService.getAll());
			
			response.setResponseMessage("productos mostrados exitosamente");
			response.setFinalTimesTamp(LocalDateTime.now());
			response.setResponseCode(AbstractResponse.SUCCESS);
		}catch(Exception e) {
			logger.info(e.getMessage());
			logger.info(e.getCause());
			response.setResponseMessage("Error al mostrar productos");
			response.setResponseCode(AbstractResponse.ERROR);
		}
		return response;
	}
	
	@PostMapping(path="/glpsaa")
	public GenericResponse<ProductSalesEntity> getAllProductSalesActiveAndAvailable(@RequestBody GenericRequest<ProductSalesEntity> request){
		logger.info("ProductSalesController.getAllProductSalesActiveAndAvailable");
		GenericResponse<ProductSalesEntity> response = new GenericResponse<ProductSalesEntity>();
		try {
			response.setDatalist(productSalesService.getProdutSalesByStatusAndStatusSales(Constants.PRODUCT_SALES_STATUS_ACTIVE, Constants.PRODUCT_SALES_STATUS_AVAILABLE));
			response.setFinalTimesTamp(LocalDateTime.now());
			response.setResponseCode(AbstractResponse.SUCCESS);
		}catch(Exception e) {
			logger.info(e);
			response.setResponseMessage("Error al mostrar  productos activos ");
			response.setResponseCode(AbstractResponse.ERROR);
		}
		return response;
		
	}
	
	@GetMapping(value ="/gbi/{id}")
	public GenericResponse<ProductSalesEntity> getProductSalesById(@PathVariable("id") Integer id){
		GenericResponse<ProductSalesEntity> response = new GenericResponse<ProductSalesEntity>();
		try {
			response.setData(productSalesService.getOneById(id));
			response.setFinalTimesTamp(LocalDateTime.now());
			response.setResponseCode(AbstractResponse.SUCCESS);
		}catch(Exception e) {
			response.setResponseMessage("Error al mostrar  productos activos ");
			response.setResponseCode(AbstractResponse.ERROR);
		}
		return response;
		
	}
	
	
	@PostMapping(path = "/opbc")
	public GenericResponse<?> organizeProductByAttribute(@RequestBody GenericRequest<ProductEntity> request) {

		GenericResponse<Map<String, List<ProductSalesEntity>>> response = new GenericResponse<>();
		
		try {
			Map<String, List<ProductSalesEntity>> productSalesOrganize = new HashMap<>();
			
			productSalesOrganize = productSalesService.organizateProductByAttribute(request.getData().getUserCreateId(), request.getData().getCategory().getName());

			response.setData(productSalesOrganize);
		} catch(Exception e) {
			response.setResponseMessage("Error al listar productos organizados ");
			response.setResponseCode(AbstractResponse.ERROR);
		}
		return response;
	}
	
	
}

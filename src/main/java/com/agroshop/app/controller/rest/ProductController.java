package com.agroshop.app.controller.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.AbstractResponse;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.entities.CategoryProductEntity;
import com.agroshop.app.model.entities.ProductEntity;
import com.agroshop.app.model.entities.ProductSalesEntity;
import com.agroshop.app.model.entities.VehicleEntity;
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
	public GenericResponse<ProductEntity> saveProduct(@RequestPart("request") GenericRequest<ProductEntity> request, @RequestPart("file") MultipartFile file){
	//public GenericResponse<ProductEntity> saveProduct(@RequestBody  MultipartFile file){	
		
		logger.info("saveProduct");
		GenericResponse<ProductEntity> response = new GenericResponse<ProductEntity>();
		
		try {
			
			/*ProductEntity pr = new ProductEntity();
			logger.info(file.getBytes());
			//pr.setPhoto(file.getBytes());
			/*CategoryProductEntity c = new CategoryProductEntity();
			c.setId(1);
			pr.setCategory(c);
			
			response.setData(productService.save(pr));*/
			if(file.getBytes().length >0)
				request.getData().setPhoto(file.getBytes());
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
	
	@GetMapping(path="/gap")
	public 	List<ProductEntity> getAllProduct(){
		return productService.getAll();
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
			List<ProductEntity> list = productService.getListProductByFarmer(request.getData().getUserCreateId());
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
	
	/*@PostMapping(path = "/gp", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public GenericResponse<byte[]> getPhoto(@RequestBody GenericRequest<ProductEntity> request) {
		GenericResponse<byte[]> response = new GenericResponse<byte[]>();
		try {
			
			ProductEntity c = productService.getOneById(request.getId());
			logger.info(c.getName());
			logger.info(c.getPhoto());
			byte[]	data = c.getPhoto();
			response.setData(data);
			response.setResponseMessage("foto obtenida exitosamente");
			response.setFinalTimesTamp(LocalDateTime.now());
			response.setResponseCode(AbstractResponse.SUCCESS);
		}catch(Exception e) {
			response.setResponseMessage("Error al mostrar foto");
			response.setResponseCode(AbstractResponse.ERROR);
		}
		
		return response;
	}*/
	
	@GetMapping(value = "/gp/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> getPhoto(@PathVariable("id") Integer id) {
		ProductEntity c = productService.getOneById(id);
		 byte[]	data = c.getPhoto();
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}
}

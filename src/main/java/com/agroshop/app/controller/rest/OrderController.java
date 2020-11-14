package com.agroshop.app.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.entities.OrderEntity;
import com.agroshop.app.model.entities.ProductEntity;
import com.agroshop.app.model.service.IOrderService;
import com.agroshop.app.util.Constants;

@RestController
@RequestMapping("/order")
public class OrderController {
	
private static final Logger logger = LogManager.getLogger(OrderController.class);
	
	@Autowired
	private IOrderService orderService;
	
	@PostMapping(path="/sobos")
	public ResponseEntity<GenericResponse<OrderEntity>> saveNewOrderByClient(@RequestBody GenericRequest<OrderEntity> request) throws Throwable {
		logger.info("OrderController.saveNewOrderByClient()");
		GenericResponse<OrderEntity> response = new GenericResponse<OrderEntity>();
		try {
			response.setDatalist(orderService.saveOrderByManyFarmer(request.getData()));
			response.setResponseMessage("Pedido realizado con exito");
			return new ResponseEntity<GenericResponse<OrderEntity>>(response,HttpStatus.CREATED);
		}catch(Exception e){
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage(e.getMessage());
			logger.error("ERORR ==> ",e);
			
			return new ResponseEntity<GenericResponse<OrderEntity>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path="/gal")
	public GenericResponse<OrderEntity> getAll(@RequestBody GenericRequest<OrderEntity> request) throws Throwable {
		logger.info("OrderController.saveNewOrderByClient()");
		GenericResponse<OrderEntity> response = new GenericResponse<OrderEntity>();
		try {
			response.setDatalist(orderService.getAll());
			response.setResponseMessage("Pedido realizado con exito");
			
			return response;
		}catch(Exception e){
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage("Ocurrio un error al realizar el pedido");
			logger.error("ERORR ==> ",e.getMessage());
			return response;
			//return new ResponseEntity<GenericResponse<OrderEntity>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

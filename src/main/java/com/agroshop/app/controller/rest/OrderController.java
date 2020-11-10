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

@RestController
@RequestMapping("/menu")
public class OrderController {
	
private static final Logger logger = LogManager.getLogger(OrderController.class);
	
	@Autowired
	private IOrderService orderService;
	
	/*@PostMapping(path="/sobos")
	public GenericResponse<?> saveNewOrderByOrganizationId(@RequestBody GenericRequest<OrderEntity> request) {
		logger.info("OrderController.saveNewOrderByOrganizationId()");
		Map<String,Object> response = new HashMap<>();
		try {
			response.put(Constants.DATA_RESPONSE, orderService.saveOrderByManyOrganization(or));
			response.put("message", "Pedido registrado con éxito");
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		}catch(Exception e){
			response.put("error", "Error al realizar pedido");
			logger.error("ERORR ==> ",e);
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	*/

}

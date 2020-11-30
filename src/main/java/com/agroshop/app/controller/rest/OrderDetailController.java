package com.agroshop.app.controller.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.entities.OrderDetailEntity;
import com.agroshop.app.model.service.IOrderDetailService;
import com.agroshop.app.util.Constants;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {
private static final Logger logger = LogManager.getLogger(OrderDetailController.class);
	
	@Autowired
	private IOrderDetailService orderDetailService;
	
	@PostMapping(path="/gobi")
	public GenericResponse<OrderDetailEntity> getOneById(@RequestBody GenericRequest<OrderDetailEntity> request) throws Throwable {
		logger.info("OrderController.saveNewOrderByClient()");
		GenericResponse<OrderDetailEntity> response = new GenericResponse<OrderDetailEntity>();
		try {
			response.setData(orderDetailService.getOneById(request.getId()));
			return response;
		}catch(Exception e){
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage("Ocurrio un error al buscar detalle pedido");
			logger.error("ERORR ==> ",e.getMessage());
			return response;		}
	}
	
	@PostMapping(path="/godbi")
	public GenericResponse<OrderDetailEntity> getOrderDetailById(@RequestBody GenericRequest<OrderDetailEntity> request) throws Throwable {
		logger.info("OrderController.saveNewOrderByClient()");
		GenericResponse<OrderDetailEntity> response = new GenericResponse<OrderDetailEntity>();
		try {
			response.setDatalist(orderDetailService.findByOrderId(request.getId()));
			return response;
		}catch(Exception e){
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage("Ocurrio un error al buscar detalle pedido");
			logger.error("ERORR ==> ",e.getMessage());
			return response;		
		}
	}
	

}

package com.agroshop.app.controller.rest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.DTO.DashboardDTO;
import com.agroshop.app.model.DTO.SearchJobOfferByFieldsDTO;
import com.agroshop.app.model.DTO.SearchOrderByFieldsDTO;
import com.agroshop.app.model.beans.OrderBean;
import com.agroshop.app.model.entities.JobOfferEntity;
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
	public ResponseEntity<GenericResponse<OrderBean>> saveNewOrderByClient(@RequestBody GenericRequest<OrderEntity> request) throws Throwable {
		logger.info("OrderController.saveNewOrderByClient()");
		GenericResponse<OrderBean> response = new GenericResponse<OrderBean>();
		try {
			List<OrderBean> orderList=orderService.saveOrderByManyFarmer(request.getData());
			response.setDatalist(orderList);
			
			response.setResponseMessage("Pedido realizado con exito");
			return new ResponseEntity<GenericResponse<OrderBean>>(response,HttpStatus.CREATED);
		}catch(Exception e){
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage(e.getMessage());
			logger.error("ERORR ==> ",e);
			
			return new ResponseEntity<GenericResponse<OrderBean>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
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
			return response;		}
	}
	
	@PostMapping(path="/gobsf")
	public GenericResponse<OrderEntity> getOrderByStatusAndFarmerId(@RequestBody GenericRequest<OrderEntity> request) throws Throwable {
		logger.info("OrderController.getOrderByStatusAndFarmerId()");
		GenericResponse<OrderEntity> response = new GenericResponse<OrderEntity>();
		try {
			response.setDatalist(orderService.findByStatusAndFarmerId(request.getData().getStatus(),request.getId()));
			return response;
		}catch(Exception e){
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage("Ocurrio un error al buscar el pedido");
			logger.error("ERORR ==> ",e.getMessage());
			return response;
		}
	}

	@PostMapping(path="/globf")
	public ResponseEntity<GenericResponse<OrderEntity>> getListOrderByFields(@RequestBody GenericRequest<SearchOrderByFieldsDTO> request) throws Throwable {
		
		GenericResponse<OrderEntity> response = new GenericResponse<OrderEntity>();
		try {
			List<OrderEntity> list = orderService.getListOrderByFields(request.getData());
			logger.info(list.size());
			if(list.isEmpty()) 
				response.setResponseMessage("No se encontraron ordenes que coincidan con la busqueda");
			else { 
				response.setDatalist(list);
				response.setResponseMessage("Ordenes encontradas");
			}

			response.setResponseCode(Constants.SUCCESS_SHOW_LIST);
			response.setFinalTimesTamp(LocalDateTime.now());
			return new ResponseEntity<GenericResponse<OrderEntity>>(response,HttpStatus.OK);
		}catch(Exception e){
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage(e.getMessage());
			logger.error("ERORR ==> ",e);
			
			return new ResponseEntity<GenericResponse<OrderEntity>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path="/cor")
	public ResponseEntity<GenericResponse<OrderEntity>>cancelOrder(@RequestBody GenericRequest<OrderEntity> request) throws Throwable{
		logger.info("OrderController.cancelOrder()");
		GenericResponse<OrderEntity> response = new GenericResponse<OrderEntity>();
		try {
			boolean check = orderService.isCancel(request.getId());
			if(check){
				Boolean checkDelete = orderService.cancelOrderAndListOrderDetail(request.getId());
				if(checkDelete) {
					logger.warn("Pedido:"+request.getId() + " cancelado");
					response.setResponseMessage("Se canceló correctamente su orden");
					return new ResponseEntity<GenericResponse<OrderEntity>>(response,HttpStatus.OK);
				}
				else { 
					logger.warn("Pedido:"+request.getId() + " no pudo ser cancelado");
					
					response.setResponseMessage("Error al cancelar la orden");
					return new ResponseEntity<GenericResponse<OrderEntity>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			else {
				logger.warn("Pedido:"+request.getId() + " excedió el limite de tiempo");	
				response.setResponseMessage("Error al cancelar la orden, el pedido excedió el limite de tiempo permitido");
				return new ResponseEntity<GenericResponse<OrderEntity>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}catch(Exception e) {
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage("Error al cancelar el pedido, pedido no existe");
			logger.error("ERORR ==> "+ e.getMessage());
			return new ResponseEntity<GenericResponse<OrderEntity>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path="/golbspac")
	public ResponseEntity<GenericResponse<OrderEntity>> getOrderListByStatusPendingAndClientId(@RequestBody GenericRequest<OrderEntity> request) throws Throwable {
		logger.info("OrderController.getOrderListByStatusPendingAndClientId()");
		GenericResponse<OrderEntity> response = new GenericResponse<OrderEntity>();
		try {
			response.setDatalist(orderService.getListOrderByStatusAndClientId(Constants.ORDER_STATUS_PENDING,request.getId()));
			response.setResponseCode(Constants.SUCCESS_SHOW_LIST);
			response.setFinalTimesTamp(LocalDateTime.now());
			return new ResponseEntity<GenericResponse<OrderEntity>>(response,HttpStatus.OK);
		}catch(Exception e){
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage("Ocurrio un error al buscar el pedido");
			logger.error("ERORR ==> ",e.getMessage());
			return new ResponseEntity<GenericResponse<OrderEntity>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/gdb/{id}")
	public GenericResponse<DashboardDTO> getDashboard(@PathVariable Integer id){
		GenericResponse<DashboardDTO> response = new GenericResponse<DashboardDTO>();
		try {
			response.setData(orderService.getDashboard(id));
			response.setFinalTimesTamp(LocalDateTime.now());
			
		}catch(Exception e) {
			response.setResponseCode(Constants.ERROR_PETITION_REQUEST);
			response.setResponseMessage("Ocurrio un error al recolectar los datos del dashboard");
			logger.error("EL TIO DE CONDORI  ==> ",e.getMessage());
			
		}
		
		return response;
	}
	
}

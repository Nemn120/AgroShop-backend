package com.agroshop.app.model.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.agroshop.app.model.DTO.DashboardDTO;
import com.agroshop.app.model.DTO.SearchOrderByFieldsDTO;
import com.agroshop.app.model.beans.FarmerBean;
import com.agroshop.app.model.beans.OrderBean;
import com.agroshop.app.model.beans.OrderDetailBean;
import com.agroshop.app.model.entities.ClientEntity;
import com.agroshop.app.model.entities.FarmerEntity;
import com.agroshop.app.model.entities.OrderDetailEntity;
import com.agroshop.app.model.entities.OrderEntity;
import com.agroshop.app.model.entities.PlaceEntity;
import com.agroshop.app.model.entities.ProductSalesEntity;
import com.agroshop.app.model.entities.UserEntity;
import com.agroshop.app.model.repository.IOrderRepository;
import com.agroshop.app.model.service.IOrderDetailService;
import com.agroshop.app.model.service.IOrderService;
import com.agroshop.app.model.service.IPlaceService;
import com.agroshop.app.model.service.IProductSalesService;
import com.agroshop.app.model.service.IUploadFileService;
import com.agroshop.app.util.Constants;
import com.agroshop.app.util.MailUtil;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
	
	private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private IOrderRepository orderRepo;
	
	@Autowired
	private IProductSalesService productSalesService;
	
	@Autowired
	private IOrderDetailService orderDetailService;
	
	@Autowired
	private IPlaceService placeService;
	
	@Autowired
	private MailUtil mailUtil;
	
	@Autowired
	private IUploadFileService uploadService;
	
	@Override
	public List<OrderEntity> getAll() {
		return orderRepo.findAll();
	}

	@Override
	public OrderEntity getOneById(Integer id) {
		return orderRepo.findById(id).orElse(new OrderEntity());
	}

	@Override
	public OrderEntity save(OrderEntity t) {
		return orderRepo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		orderRepo.deleteById(id);
	}

	@Override
	public List<OrderBean> saveOrderByManyFarmer(OrderEntity order) throws Throwable  {
		logger.info("OrderServiceImpl.saveOrderByManyFarmer()");
		Map<Integer,List<OrderDetailEntity>> mapOrderDetail = new HashMap<Integer,List<OrderDetailEntity>>();
		List<OrderBean> orderListResult = new ArrayList<OrderBean>();
		order.getOrderDetailList().forEach(orderDetail ->{
			if(orderDetail != null) {
				if(mapOrderDetail.containsKey(orderDetail.getProductSales().getFarmerNumber())) {
					mapOrderDetail.get(orderDetail.getProductSales().getFarmerNumber()).add(orderDetail);
				}else {
					List<OrderDetailEntity> odList = new ArrayList<OrderDetailEntity>();
					odList.add(orderDetail);
					mapOrderDetail.put(orderDetail.getProductSales().getFarmerNumber(),odList);
				}
			}
		});
		if(order.getDestinyPlace() != null )
			order.setDestinyPlace(this.placeService.save(order.getDestinyPlace()));
		for (Map.Entry<Integer, List<OrderDetailEntity>> entry : mapOrderDetail.entrySet()) {
		    OrderEntity orderSave = new OrderEntity();
		    BeanUtils.copyProperties(order, orderSave);
		    orderSave.setOrderDetailList(new ArrayList<OrderDetailEntity>());
		    orderSave.setOrderDetailList(entry.getValue());
		    orderSave.setFarmer(new FarmerEntity());
		    orderSave.getFarmer().setId(entry.getKey());
		    orderSave.setClient(new ClientEntity());
		    orderSave.getClient().setId(order.getClient().getId());
		    if(order.getClient().getUser()!= null && order.getClient().getUser().getEmail() != null) {
		    	orderSave.getClient().setUser( new UserEntity());
		    	orderSave.getClient().getUser().setEmail(order.getClient().getUser().getEmail());
		    }
		    if(order.getDestinyPlace() != null) {
		    	orderSave.setDestinyPlace(new PlaceEntity());
			    orderSave.getDestinyPlace().setId(order.getDestinyPlace().getId());
		    }
		    
		    OrderEntity orderResponse = this.saveOrderByFarmer(orderRepo.save(orderSave));
		    if(orderResponse != null) {
		    	OrderBean orderResult = new OrderBean();
		    	BeanUtils.copyProperties(orderResponse, orderResult);
		    	orderResult.setFarmer(new FarmerBean());
		    	orderResult.getFarmer().setId(entry.getKey());
		    	orderResult.setOrderDetailList(new ArrayList<OrderDetailBean>());
		    	if(orderResponse.getOrderDetailList()!= null) {
		    		for (Iterator<OrderDetailEntity> iterator = orderResponse.getOrderDetailList().iterator(); iterator.hasNext(); ) {
		    				OrderDetailEntity odEntity =iterator.next();
		    				OrderDetailBean odbean = new OrderDetailBean();
				    		BeanUtils.copyProperties(odEntity, odbean);
				    		odbean.setCustomOrder(new OrderBean());
				    		if(odEntity.getProductSales() != null) {
				    			odbean.setProductName(odEntity.getProductSales().getProduct().getName());
				    			odbean.setMeasureUnite(odEntity.getProductSales().getMeasureUnite());
				    		}
				    		orderResult.getOrderDetailList().add(odbean);
		    		}
		    	}
		    	orderListResult.add(orderResult);
		    }else {
		    	throw  new RuntimeException("Se produjo un error al realizar el pedido");
		    }
		    
		}
		return orderListResult;
	}

	@Override
	public OrderEntity saveOrderByFarmer(OrderEntity order) throws Throwable  {
	logger.info("OrderServiceImpl.saveOrderByFarmer()");
		order.getOrderDetailList().forEach(od ->{
			od.setCustomOrder(order);
			ProductSalesEntity mp =productSalesService.getProdutSalesByIdAndStatusAndStatusSales(od.getProductSales().getId(),Constants.PRODUCT_SALES_STATUS_ACTIVE,Constants.PRODUCT_SALES_STATUS_AVAILABLE);
			if(mp== null) {
				throw new RuntimeException("El producto " +od.getProductSales().getProduct().getName()+ " no esta disponible.");
			}
				Integer quantityOrder= mp.getAvailableQuantity()-od.getQuantity();
				if(quantityOrder < 0) {
					logger.trace("ProductSales: "+mp.getId() + " estado : "+Constants.PRODUCT_SALES_STATUS_NOT_AVAILABLE);
					throw  new RuntimeException("No hay stock suficiente para realizar pedido");
				}
				if(quantityOrder == 0)
					mp.setStatusSales(Constants.PRODUCT_SALES_STATUS_NOT_AVAILABLE);
				mp.setAvailableQuantity(quantityOrder);
				od.setTotal(od.getQuantity()*od.getPrice());
				orderDetailService.save(od);
				productSalesService.save(mp);
				order.setTotal(order.getTotal() !=null && order.getTotal() != 0.0? order.getTotal()+od.getTotal():od.getTotal());
				order.setQuantity(order.getQuantity() !=null? order.getQuantity()+od.getQuantity(): od.getQuantity());
		});
		order.setStatus(Constants.ORDER_STATUS_PENDING);
		if(order.getClient().getUser()!= null && order.getClient().getUser().getEmail() != null) {
			this.sendEmailOrder(orderRepo.save(order));
		}else
			orderRepo.save(order);
		return order;
	}
	
	private void sendEmailOrder(OrderEntity order) {
		String subject = "Pedido realizado exitosamente";
		StringBuffer body = new StringBuffer("Estimado cliente su pedido ha sido enviado con éxito \n");
			body.append("Dirección: "+order.getDestinationRegion() + " "+ order.getDestinationProvince() +" "+ order.getDestinationDistrict() +"\n");
			body.append("Cantidad de productos: "+order.getQuantity() + "\n");
			body.append("Costo total: "+order.getTotal() + "\n");
			body.append("Productos: \n");
			order.getOrderDetailList().forEach(od ->{
				body.append(od.toString());
			});
		mailUtil.sendEmail(order.getClient().getUser().getEmail(),body.toString() , subject);
	}
	
	@Override
	public List<OrderEntity> findByStatusAndFarmerId(String status, Integer farmerId) throws Throwable {
		return orderRepo.findByStatusAndFarmerId(status, farmerId);
	}
	
	@Override
	public List<OrderEntity> findByStatusAndClientId(String status, Integer clientId) throws Throwable {
		return orderRepo.getListOrderByStatusAndClientId(status, clientId);
	}

	@Override
	public List<OrderEntity> getListOrderByFields(SearchOrderByFieldsDTO dto) {
		return orderRepo.getListOrderByFields(dto);
	}

	@Override
	public boolean isCancel(Integer or) throws Throwable{
		OrderEntity order = this.getOneById(or);

		if(order==null)
			throw new RuntimeException("La order: "+ or+ "no existe ");

		logger.info("order: " + order.getCreateDate());
		logger.info("status: " + order.getStatus());
		
		logger.info("order: " + order.getCreateDate());
		logger.info("status: " + order.getStatus());
		
		if(order.getStatus().equals(Constants.ORDER_STATUS_PENDING)) {
			LocalDateTime time = LocalDateTime.now();

			LocalDateTime timeLimit = order.getCreateDate().plusMinutes(5);
			logger.info("now: " + time);
			logger.info("limit: " + timeLimit);
			return time.isBefore(timeLimit);
		}
		return false;
	}

	@Override
	public boolean cancelOrderAndListOrderDetail(Integer order) {
		logger.info("OrderServiceImpl.cancelOrderAndListOrderDetail()");
		try {			
			orderDetailService.updateOrderDetailStatus(order, Constants.ORDER_DETAIL_STATUS_CANCELED);
			orderRepo.updateOrderStatus(order, Constants.ORDER_STATUS_CANCELED);
			logger.trace("Orden : "+order+ " estado: "+Constants.ORDER_STATUS_CANCELED);
			
			orderDetailService.findByOrderId(order).forEach(od ->{
				ProductSalesEntity pro = productSalesService.getOneById(od.getProductSales().getId());
				Integer cantidad = pro.getAvailableQuantity() + od.getQuantity();
				pro.setAvailableQuantity(cantidad);
				if(cantidad > 0)
					pro.setStatusSales(Constants.PRODUCT_SALES_STATUS_AVAILABLE);
				
				productSalesService.save(pro);
			});
			return true;
		}catch(Exception e) {
			logger.trace("Orden : "+order+" no pudo ser cancelado");
			return false;
		}
	}

	@Override
	public List<OrderEntity> getListOrderByStatusAndClientId(String status,Integer id) {
		
		return orderRepo.getListOrderByStatusAndClientId(status, id);
	}
	
	@Override
	public void confirmArriveOrder(MultipartFile file, Integer id) throws Throwable{
		if (!file.isEmpty()) {
			String nameImage = null;
			try {
				nameImage = uploadService.copy(file);
				orderRepo.updateOrderStatus(id, Constants.ORDER_STATUS_DELIVERED);
				orderRepo.updateOrderPhoto(id, nameImage);
				logger.info("IMAGE" + nameImage);
			} catch(IOException e) {
				logger.error(e.getMessage());
			}
		}
	}

	@Override
	public OrderEntity changeStatusOrder(Integer id) throws Throwable {
		OrderEntity ord = new OrderEntity();
		ord = getOneById(id);
		ord.setStatus(Constants.ORDER_STATUS_DELIVERY);
		ord = save(ord);
		return ord;
	}
	
	public DashboardDTO getDashboard(Integer id) {
		DashboardDTO dash = new DashboardDTO();
		LocalDateTime time = LocalDateTime.now();
		// sales and quantity today
		LocalDateTime initDatet = time.withHour(0).withMinute(0).withSecond(0);
		LocalDateTime finalDatet = time.withHour(23).withMinute(59).withSecond(59);
		Double salesToday = orderRepo.getSales(id, initDatet, finalDatet);
		Integer quantityToday = orderRepo.getQuantity(id, initDatet, finalDatet);
		dash.setSalesToday(salesToday);
		dash.setQuantityToday(quantityToday);
		// sales and quantity yesterday
		LocalDateTime initDatey =initDatet.minusDays(1);
		LocalDateTime finalDatey =finalDatet.minusDays(1);
		Double salesYesterday = orderRepo.getSales(id, initDatey, finalDatey);
		Integer quantityYesterday = orderRepo.getQuantity(id, initDatey, finalDatey);
		dash.setSalesYesterday(salesYesterday);
		dash.setQuantityYesterday(quantityYesterday);
		// sales and quantity last week
		LocalDateTime initDatelw =time.withHour(0).withMinute(0).withSecond(0).minusDays(7+time.getDayOfWeek().getValue()-1);
		LocalDateTime finalDatelw =time.withHour(23).withMinute(59).withSecond(59).minusDays(time.getDayOfWeek().getValue());
		Double salesLastWeek = orderRepo.getSales(id, initDatelw, finalDatelw);
		Integer quantityLastWeek = orderRepo.getQuantity(id, initDatelw, finalDatelw);
		dash.setQuantityLastWeek(quantityLastWeek);
		dash.setSalesLastWeek(salesLastWeek);
		// sales and quantity this week
		LocalDateTime initDatetw =initDatelw.plusWeeks(1);
		LocalDateTime finalDatetw =finalDatelw.plusWeeks(1);
		Double salesThisWeek = orderRepo.getSales(id, initDatetw, finalDatetw);
		Integer quantityThisWeek = orderRepo.getQuantity(id, initDatetw, finalDatetw);
		dash.setQuantityThisWeek(quantityThisWeek);
		dash.setSalesThisWeek(salesThisWeek);
		
		if(salesToday!= null && salesYesterday != null) {
			Double salesVariationDay = (((double)salesToday-(double)salesYesterday)/(double)salesYesterday)*100;
			dash.setSalesVariationDay(salesVariationDay);
		}
		
		if(quantityToday!= null && quantityYesterday != null) {
			Double quantityVariationDay = (((double)quantityToday-(double)quantityYesterday)/(double)quantityYesterday)*100;
			dash.setQuantityVariationDay(quantityVariationDay);
		}
		
		if(salesLastWeek !=null && salesThisWeek !=null) {
			Double variationSalesWeek = (((double)salesThisWeek-(double)salesLastWeek)/(double)salesLastWeek)*100;
			variationSalesWeek = (double) Math.round(variationSalesWeek * 100);
			dash.setSalesVariationWeek(variationSalesWeek/100);
		}
		if(quantityLastWeek != null && quantityThisWeek != null) {
			Double variationQuantityWeeks =  ((((double)quantityThisWeek-(double)quantityLastWeek)/(double)quantityLastWeek)*100);
			variationQuantityWeeks = (double) Math.round(variationQuantityWeeks * 100);
			dash.setQuantityVariationWeek(variationQuantityWeeks/100);
		}
		
		dash.setOrderPending(orderRepo.getListOrderRecentByStatusLimitedTo(5,Constants.ORDER_STATUS_PENDING, id));
		dash.setOrderDelivery(orderRepo.getListOrderRecentByStatusLimitedTo(5,Constants.ORDER_STATUS_DELIVERY, id));
		dash.setOrderDelivered(orderRepo.getListOrderRecentByStatusLimitedTo(5,Constants.ORDER_STATUS_DELIVERED, id));
		
		dash.setId(id);
		
		return dash;

	}

}


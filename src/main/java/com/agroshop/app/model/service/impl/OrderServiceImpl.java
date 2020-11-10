package com.agroshop.app.model.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agroshop.app.model.entities.ClientEntity;
import com.agroshop.app.model.entities.FarmerEntity;
import com.agroshop.app.model.entities.OrderDetailEntity;
import com.agroshop.app.model.entities.OrderEntity;
import com.agroshop.app.model.entities.ProductSalesEntity;
import com.agroshop.app.model.repository.IOrderRepository;
import com.agroshop.app.model.service.IOrderDetailService;
import com.agroshop.app.model.service.IOrderService;
import com.agroshop.app.model.service.IProductSalesService;
import com.agroshop.app.util.Constants;

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
	public List<OrderEntity> saveOrderByManyFarmer(OrderEntity order) throws Throwable  {
		logger.info("OrderServiceImpl.saveOrderByManyFarmer()");
		Map<Integer,List<OrderDetailEntity>> mapOrderDetail = new HashMap<Integer,List<OrderDetailEntity>>();
		List<OrderEntity> orderResult = new ArrayList<OrderEntity>();
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
		for (Map.Entry<Integer, List<OrderDetailEntity>> entry : mapOrderDetail.entrySet()) {
		    OrderEntity orderSave = new OrderEntity();
		    BeanUtils.copyProperties(order, orderSave);
		    orderSave.setOrderDetailList(new ArrayList<OrderDetailEntity>());
		    orderSave.setOrderDetailList(entry.getValue());
		    orderSave.setFarmer(new FarmerEntity());
		    orderSave.getFarmer().setId(entry.getKey());
		    orderSave.setClient(new ClientEntity());
		    orderSave.getClient().setId(order.getClient().getId());
		    OrderEntity orderResponse = this.saveOrderByFarmer(orderRepo.save(orderSave));
		    if(orderResponse != null) {
		    	orderResult.add(orderResponse);
		    }
		    
		}
		
		return orderResult;
	}

	@Override
	public OrderEntity saveOrderByFarmer(OrderEntity order) throws Throwable  {
	
		logger.info("OrderServiceImpl.saveOrderByFarmer()");
		order.getOrderDetailList().forEach(od ->{
			od.setCustomOrder(new OrderEntity());
			od.setCustomOrder(order);
			ProductSalesEntity mp =productSalesService.getProdutSalesByIdAndStatusAndStatusSales(od.getProductSales().getId(),Constants.PRODUCT_SALES_STATUS_ACTIVE,Constants.PRODUCT_SALES_STATUS_AVAILABLE);
			if(mp== null) {
				//throw new Throwable("El producto " +od.getProductSales().getProduct().getName()+ " no esta disponible.");
			}
				Integer quantityOrder= mp.getAvailableQuantity()-od.getQuantity();
				if(quantityOrder < 0) {
					logger.trace("ProductSales: "+mp.getId() + " estado : "+Constants.PRODUCT_SALES_STATUS_NOT_AVAILABLE);
				//	throw new Throwable ("No existe cantidad de productos suficientes para realizar el pedido");
				//	throw new Throwable("Eror al realizar AOP");
				}
				mp.setAvailableQuantity(quantityOrder);
				if(quantityOrder.equals(0))
					mp.setStatusSales(Constants.PRODUCT_SALES_STATUS_NOT_AVAILABLE);
				productSalesService.save(mp);
				orderDetailService.save(od);
				
				order.setTotal(order.getTotal() !=null && order.getTotal() != 0.0? order.getTotal()+od.getPrice():od.getPrice()*od.getQuantity());
				order.setQuantity(order.getQuantity() !=null? order.getQuantity()+od.getQuantity(): od.getQuantity());
		});
		order.setStatus(Constants.ORDER_STATUS_PENDING);
		
		return orderRepo.save(order);
		
	}

}


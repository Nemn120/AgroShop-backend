package com.agroshop.app.model.service.impl;

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
	public List<OrderEntity> saveOrderByManyFarmer(OrderEntity order) {
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
		    orderResult.add(this.saveOrderByFarmer(orderRepo.save(orderSave)));
		}
		
		return orderResult;
	}

	@Override
	public OrderEntity saveOrderByFarmer(OrderEntity order) {
		return null;
	}

}


package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agroshop.app.model.entities.OrderDetailEntity;
import com.agroshop.app.model.repository.IOrderDetailRepository;
import com.agroshop.app.model.service.IOrderDetailService;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService{

	@Autowired
	private IOrderDetailRepository orderDetailRepo;
	
	@Override
	public List<OrderDetailEntity> getAll() {
		return orderDetailRepo.findAll();
	}

	@Override
	public OrderDetailEntity getOneById(Integer id) {
		return orderDetailRepo.findById(id).orElse(new OrderDetailEntity());
	}

	@Override
	public OrderDetailEntity save(OrderDetailEntity t) {
		return orderDetailRepo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		orderDetailRepo.deleteById(id);
	}

	@Override
	public List<OrderDetailEntity> findByOrderId(Integer id) {
		return orderDetailRepo.findByOrderId(id);
	}

	@Override
	public boolean updateOrderDetailStatus(Integer id, String status) {
		try{
			orderDetailRepo.updateOrderDetailStatus(id, status);
			return true;
		}catch(Exception e) {

			return false;
		}
	}
}

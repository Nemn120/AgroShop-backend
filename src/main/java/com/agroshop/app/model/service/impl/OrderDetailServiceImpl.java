package com.agroshop.app.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.DTO.SalesReportDTO;
import com.agroshop.app.model.DTO.SalesReportResponseDTO;
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

	@Override
	public List<SalesReportResponseDTO> getSalesReport(SalesReportDTO dto) {
		
		List<SalesReportResponseDTO> response = new ArrayList<SalesReportResponseDTO>();
		
		orderDetailRepo.getSalesReport(dto).forEach(x ->{
			SalesReportResponseDTO re = new SalesReportResponseDTO();
			re.setTotal(Double.parseDouble(String.valueOf(x[0])));
			re.setCount(Integer.parseInt(String.valueOf(x[1])));
			re.setName(String.valueOf(x[2]));
			re.setPrice(Double.parseDouble(String.valueOf(x[3])));
			response.add(re);
			
		});
		return response;
	}
}

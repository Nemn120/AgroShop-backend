package com.agroshop.app.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.agroshop.app.model.DTO.SearchOrderByFieldsDTO;
import com.agroshop.app.model.beans.OrderBean;
import com.agroshop.app.model.entities.OrderEntity;
import com.agroshop.app.model.entities.ProductEntity;

@Service
public interface IOrderService extends GenericCRUD<OrderEntity, Integer>{
	
	public List<OrderBean> saveOrderByManyFarmer(OrderEntity order)  throws Throwable ;
	
	public OrderEntity saveOrderByFarmer(OrderEntity order)  throws Throwable ;
	
	public List<OrderEntity> findByStatusAndFarmerId(String status,Integer farmerId) throws Throwable ;
	
	public List<OrderEntity> getListOrderByFields(SearchOrderByFieldsDTO dto);
	
	public boolean isCancel(Integer orderId) throws Throwable;
	
	public boolean cancelOrderAndListOrderDetail(Integer orderId);
	
	public List<OrderEntity> getListOrderByStatusAndClientId(String status,Integer id);
	
	public OrderEntity confirmArriveOrder(MultipartFile file, Integer id) throws Throwable;

}

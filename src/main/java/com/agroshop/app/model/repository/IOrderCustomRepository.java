package com.agroshop.app.model.repository;

import java.util.List;

import com.agroshop.app.model.DTO.SearchOrderByFieldsDTO;
import com.agroshop.app.model.entities.OrderEntity;
import com.agroshop.app.model.entities.ProductSalesEntity;
public interface IOrderCustomRepository {

	public List<OrderEntity> getListOrderByFields(SearchOrderByFieldsDTO dto);
	
	public List<OrderEntity> getListOrderRecentByStatusLimitedTo(Integer limit, String status, Integer id);
	
}

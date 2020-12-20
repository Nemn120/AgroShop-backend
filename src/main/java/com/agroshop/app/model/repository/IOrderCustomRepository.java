package com.agroshop.app.model.repository;

import java.util.List;

import com.agroshop.app.model.DTO.SearchOrderByFieldsDTO;
import com.agroshop.app.model.entities.OrderEntity;
public interface IOrderCustomRepository {

	public List<OrderEntity> getListOrderByFields(SearchOrderByFieldsDTO dto);
}

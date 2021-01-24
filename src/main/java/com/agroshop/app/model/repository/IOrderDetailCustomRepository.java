package com.agroshop.app.model.repository;

import java.util.List;

import com.agroshop.app.model.DTO.SalesReportDTO;
import com.agroshop.app.model.entities.OrderDetailEntity;

public interface IOrderDetailCustomRepository {

	public List<Object[]> getSalesReport(SalesReportDTO dto);
}

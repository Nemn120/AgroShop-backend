package com.agroshop.app.model.repository;

import java.time.LocalDate;
import java.util.List;

import com.agroshop.app.model.DTO.SearchProductSalesByFieldsDTO;
import com.agroshop.app.model.entities.ProductSalesEntity;

public interface IProductSalesCustomRepository {
    public List<ProductSalesEntity> getListProductSalesByFields(SearchProductSalesByFieldsDTO spsbf, LocalDate date);
}
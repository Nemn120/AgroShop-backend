package com.agroshop.app.model.beans;

import com.agroshop.app.model.DTO.ProductSummaryDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OrderDetailBean extends MainBean {

	private Integer id;
	private OrderBean customOrder;
	private ProductSalesBean productSales;
	private Integer quantity;
	private Double price;
	private Double total;
	private String productName;
	private String measureUnite;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public OrderBean getCustomOrder() {
		return customOrder;
	}
	public void setCustomOrder(OrderBean customOrder) {
		this.customOrder = customOrder;
	}
	public ProductSalesBean getProductSales() {
		return productSales;
	}
	public void setProductSales(ProductSalesBean productSales) {
		this.productSales = productSales;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getMeasureUnite() {
		return measureUnite;
	}
	public void setMeasureUnite(String measureUnite) {
		this.measureUnite = measureUnite;
	}
}
package com.agroshop.app.model.beans;

public class OrderDetailBean extends MainBean {

	private Integer id;
	private OrderBean order;
	private ProductSalesBean productSales;
	private Integer quantity;
	private Integer price;
	private Integer total;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public OrderBean getOrder() {
		return order;
	}
	public void setOrder(OrderBean order) {
		this.order = order;
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	
}
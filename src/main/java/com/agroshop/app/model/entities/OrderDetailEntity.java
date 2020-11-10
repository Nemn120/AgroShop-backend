package com.agroshop.app.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_detail")
public class OrderDetailEntity extends MainEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "custom_order_id", nullable = false)
	private OrderEntity customOrder;
	@ManyToOne
	@JoinColumn(name = "product_sales_id", nullable = false)
	private ProductSalesEntity productSales;
	private Integer quantity;
	private Double price;
	private Double total;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public OrderEntity getCustomOrder() {
		return customOrder;
	}
	public void setCustomOrder(OrderEntity customOrder) {
		this.customOrder = customOrder;
	}
	public ProductSalesEntity getProductSales() {
		return productSales;
	}
	public void setProductSales(ProductSalesEntity productSales) {
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
}
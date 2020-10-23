package com.agroshop.app.model.beans;

import java.time.LocalDateTime;

public class OrderDetailBean extends MainBean {

	public Integer id;
	public String status; // atendido, entregado , en camino
	private Double price;
	private UserBean userAttend;
	private UserBean userDelivery;
	private ProductBean product;
	private OrderBean order;
	private Integer orderId;
	private Integer menuProductId;
	private LocalDateTime deliveryDate;
	private LocalDateTime penddingDate;
	private String companyName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public UserBean getUserAttend() {
		return userAttend;
	}

	public void setUserAttend(UserBean userAttend) {
		this.userAttend = userAttend;
	}

	public UserBean getUserDelivery() {
		return userDelivery;
	}

	public void setUserDelivery(UserBean userDelivery) {
		this.userDelivery = userDelivery;
	}

	public ProductBean getProduct() {
		return product;
	}

	public void setProduct(ProductBean product) {
		this.product = product;
	}

	public OrderBean getOrder() {
		return order;
	}

	public void setOrder(OrderBean order) {
		this.order = order;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getMenuProductId() {
		return menuProductId;
	}

	public void setMenuProductId(Integer menuProductId) {
		this.menuProductId = menuProductId;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getAttendDate() {
		return AttendDate;
	}

	public void setAttendDate(Date attendDate) {
		AttendDate = attendDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}

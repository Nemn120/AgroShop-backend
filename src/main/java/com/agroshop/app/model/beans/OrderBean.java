package com.agroshop.app.model.beans;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OrderBean extends MainBean {

	private Integer id;
	private Double total;
	private Integer quantity;
	private LocalDateTime deliveryDate;
	private LocalDateTime attendDate;
	private String address;
	private String phone;
	private String reference;
	private ClientBean client;
	private FarmerBean farmer;
	private LocalDateTime deliveredDate;
	
	private List<OrderDetailBean> orderDetailList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public LocalDateTime getAttendDate() {
		return attendDate;
	}

	public void setAttendDate(LocalDateTime attendDate) {
		this.attendDate = attendDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public ClientBean getClient() {
		return client;
	}

	public void setClient(ClientBean client) {
		this.client = client;
	}

	public FarmerBean getFarmer() {
		return farmer;
	}

	public void setFarmer(FarmerBean farmer) {
		this.farmer = farmer;
	}

	public LocalDateTime getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(LocalDateTime deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public List<OrderDetailBean> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetailBean> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	
	

}
package com.agroshop.app.model.beans;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class OrderBean extends MainBean {

	public Integer id;
	private Double total;
	private Integer quantity;
	private List<OrderDetailBean> orderDetail;
	
	private LocalDateTime deliveryDate;
	private LocalDateTime attendDate;
	private String address;
	private String phone;
	private String reference;
	private ClientBean client;
	private FarmerBean farmer;
	private PlaceBean place;
	private LocalDateTime deliveredDate;
	
	private String formaPago;
	private String numCuotas;
	private List<PayInstalmentsBean> feePay;
	
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
	public List<OrderDetailBean> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<OrderDetailBean> orderDetail) {
		this.orderDetail = orderDetail;
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
	public PlaceBean getPlace() {
		return place;
	}
	public void setPlace(PlaceBean place) {
		this.place = place;
	}
	public LocalDateTime getDeliveredDate() {
		return deliveredDate;
	}
	public void setDeliveredDate(LocalDateTime deliveredDate) {
		this.deliveredDate = deliveredDate;
	}
	
	

}
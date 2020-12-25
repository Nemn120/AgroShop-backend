package com.agroshop.app.model.entities;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="order_entity")
public class OrderEntity extends MainEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	private Double total;
	private Integer quantity;
	@Column(name = "delivery_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime deliveryDate;
	@Column(name = "attend_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime attendDate;
	private String address;
	private String phone;
	private String reference;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private ClientEntity client;
	@ManyToOne
	@JoinColumn(name = "farmer_id")
	private FarmerEntity farmer;
	@Column(name = "delivered_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime deliveredDate;
	private String destinationProvince;
	private String destinationRegion;
	private String destinationDistrict;
	private String originProvince;
	private String originRegion;
	private String originDistrict;
	@Transient
	private List<OrderDetailEntity> orderDetailList;
	
	public String getOriginProvince() {
		return originProvince;
	}
	public void setOriginProvince(String originProvince) {
		this.originProvince = originProvince;
	}
	public String getOriginRegion() {
		return originRegion;
	}
	public void setOriginRegion(String originRegion) {
		this.originRegion = originRegion;
	}
	public String getOriginDistrict() {
		return originDistrict;
	}
	public void setOriginDistrict(String originDistrict) {
		this.originDistrict = originDistrict;
	}
	public String getDestinationProvince() {
		return destinationProvince;
	}
	public void setDestinationProvince(String destinationProvince) {
		this.destinationProvince = destinationProvince;
	}
	public String getDestinationRegion() {
		return destinationRegion;
	}
	public void setDestinationRegion(String destinationRegion) {
		this.destinationRegion = destinationRegion;
	}
	public String getDestinationDistrict() {
		return destinationDistrict;
	}
	public void setDestinationDistrict(String destinationDistrict) {
		this.destinationDistrict = destinationDistrict;
	}
	
	public List<OrderDetailEntity> getOrderDetailList() {
		return orderDetailList;
	}
	public void setOrderDetailList(List<OrderDetailEntity> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
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
	public ClientEntity getClient() {
		return client;
	}
	public void setClient(ClientEntity client) {
		this.client = client;
	}

	public FarmerEntity getFarmer() {
		return farmer;
	}
	public void setFarmer(FarmerEntity farmer) {
		this.farmer = farmer;
	}
	public LocalDateTime getDeliveredDate() {
		return deliveredDate;
	}
	public void setDeliveredDate(LocalDateTime deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

}
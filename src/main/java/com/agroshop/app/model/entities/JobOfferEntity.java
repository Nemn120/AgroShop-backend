package com.agroshop.app.model.entities;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="job_offer")
public class JobOfferEntity extends MainEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private Integer id;
	@Column(name = "start_date", columnDefinition = "DATE")
	private LocalDate startDate;
	@Column(name = "final_date", columnDefinition = "DATE")
	private LocalDate finalDate;
	private String statusOffer;
	private String description;
	private String title;
	private Double shippingCost;
	private String requirements;
	private Double totalWeight;
	
	private String originProvince;
	private String originRegion;
	private String originDistrict;

	@ManyToOne
	@JoinColumn(name = "destiny_place_id")
	private PlaceEntity destinyPlace;
	
	@ManyToOne
	@JoinColumn(name = "origin_place_id")
	private PlaceEntity originPlace;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderEntity order;
	
	public PlaceEntity getOriginPlace() {
		return originPlace;
	}
	public void setOriginPlace(PlaceEntity originPlace) {
		this.originPlace = originPlace;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(LocalDate finalDate) {
		this.finalDate = finalDate;
	}
	public String getStatusOffer() {
		return statusOffer;
	}
	public void setStatusOffer(String statusOffer) {
		this.statusOffer = statusOffer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public OrderEntity getOrder() {
		return order;
	}
	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	public Double getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(Double totalWeight) {
		this.totalWeight = totalWeight;
	}
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
}

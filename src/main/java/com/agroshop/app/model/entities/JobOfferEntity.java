package com.agroshop.app.model.entities;

import java.util.Date;
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
	@Column(name = "start_date", columnDefinition = "TIMESTAMP")
	private Date startDate;
	@Column(name = "final_date", columnDefinition = "TIMESTAMP")
	private Date finalDate;
	private String statusOffer;
	private String description;
	private String title;
	private Double shippingCost;
	private String requirements;
	private Double totalWeight;
	private String departmentOrigin;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderEntity order;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
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
	public String getDepartmentOrigin() {
		return departmentOrigin;
	}
	public void setDepartmentOrigin(String departmentOrigin) {
		this.departmentOrigin = departmentOrigin;
	}
	
	

}

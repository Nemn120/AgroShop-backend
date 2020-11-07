package com.agroshop.app.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_sales")
public class ProductSalesEntity extends MainEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private ProductEntity product;
	private Double price;
	private Integer totalQuantity;
	private Integer availableQuantity;
	private String type;
	private Integer farmerNumber; //id del farmer
	private String measureUnite;
	private String validity; //validez
	private String discount;
	private String weight; //peso
	private Double offerPrice;
	private String statusSales;
	
		
	public String getStatusSales() {
		return statusSales;
	}
	public void setStatusSales(String statusSales) {
		this.statusSales = statusSales;
	}
	public String getMeasureUnite() {
		return measureUnite;
	}
	public void setMeasureUnite(String measureUnite) {
		this.measureUnite = measureUnite;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public Double getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	
	public Integer getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getFarmerNumber() {
		return farmerNumber;
	}
	public void setFarmerNumber(Integer farmerNumber) {
		this.farmerNumber = farmerNumber;
	}
}

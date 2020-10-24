package com.agroshop.app.model.beans;

public class ProductSalesBean extends MainBean {

	private Integer id;
	private ProductBean product;
	private Double price;
	private Integer totalQuantity;
	private Integer addQuantity;
	private Integer availableQuantity;
	private String type;
	private Integer farmerNumber;
	private String measureUnite;
	private String validity; //validez
	private String discount;
	private String weight; //peso
	private Double offerPrice;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ProductBean getProduct() {
		return product;
	}
	public void setProduct(ProductBean product) {
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
	public Integer getAddQuantity() {
		return addQuantity;
	}
	public void setAddQuantity(Integer addQuantity) {
		this.addQuantity = addQuantity;
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
	
	
	
}
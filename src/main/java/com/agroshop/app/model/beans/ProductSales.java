package com.agroshop.app.model.beans;

public class ProductSales extends MainBean {

	private Integer id;
	private ProductBean product;
	private Double price;
	private Integer totalQuantity;
	private Integer addQuantity;
	private Integer availableQuantity;
	private String type;
	private Integer farmerNumber;
	
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
	
	
}
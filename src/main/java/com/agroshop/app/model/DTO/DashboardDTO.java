package com.agroshop.app.model.DTO;
import java.util.List;

import com.agroshop.app.model.entities.OrderEntity;
import com.agroshop.app.model.entities.ProductSalesEntity;

public class DashboardDTO {
	private Double salesToday; // ventas del día
	private Double salesYesterday; // ventas de ayer
	private Double salesThisWeek; // ventas de la semana
	private Double salesLastWeek; // ventas de la semana pasada
	private Double salesVariationDay; // variacion de ventas por dia
	private Double salesVariationWeek; // variacion de ventas por semana
	private Integer quantityToday; // cantidad de ventas del día
	private Integer quantityYesterday; // cantidad de ventas de ayer
	private Integer quantityThisWeek; // cantidad de ventas en la semana
	private Integer quantityLastWeek; // cantidad de ventas la semana pasada
	private Double quantityVariationDay; // variacion de cantidad de ventas por dia
	private Double quantityVariationWeek; // variacion de cantidad de ventas por semana
	
	private List<OrderEntity> orderPending;
	private List<OrderEntity> orderDelivery;
	private List<OrderEntity> orderDelivered;
	private List<ProductSalesEntity> favoriteProducts;
	
	private Integer id;
	
	public Double getSalesToday() {
		return salesToday;
	}
	public void setSalesToday(Double salesToday) {
		this.salesToday = salesToday;
	}
	public Double getSalesYesterday() {
		return salesYesterday;
	}
	public void setSalesYesterday(Double salesYesterday) {
		this.salesYesterday = salesYesterday;
	}
	public Double getSalesThisWeek() {
		return salesThisWeek;
	}
	public void setSalesThisWeek(Double salesThisWeek) {
		this.salesThisWeek = salesThisWeek;
	}
	public Double getSalesLastWeek() {
		return salesLastWeek;
	}
	public void setSalesLastWeek(Double salesLastWeek) {
		this.salesLastWeek = salesLastWeek;
	}
	public Double getSalesVariationDay() {
		return salesVariationDay;
	}
	public void setSalesVariationDay(Double salesVariationDay) {
		this.salesVariationDay = salesVariationDay;
	}
	public Double getSalesVariationWeek() {
		return salesVariationWeek;
	}
	public void setSalesVariationWeek(Double salesVariationWeek) {
		this.salesVariationWeek = salesVariationWeek;
	}
	public Integer getQuantityToday() {
		return quantityToday;
	}
	public void setQuantityToday(Integer quantityToday) {
		this.quantityToday = quantityToday;
	}
	public Integer getQuantityYesterday() {
		return quantityYesterday;
	}
	public void setQuantityYesterday(Integer quantityYesterday) {
		this.quantityYesterday = quantityYesterday;
	}
	public Integer getQuantityThisWeek() {
		return quantityThisWeek;
	}
	public void setQuantityThisWeek(Integer quantityThisWeek) {
		this.quantityThisWeek = quantityThisWeek;
	}
	public Integer getQuantityLastWeek() {
		return quantityLastWeek;
	}
	public void setQuantityLastWeek(Integer quantityLastWeek) {
		this.quantityLastWeek = quantityLastWeek;
	}
	public Double getQuantityVariationDay() {
		return quantityVariationDay;
	}
	public void setQuantityVariationDay(Double quantityVariationDay) {
		this.quantityVariationDay = quantityVariationDay;
	}
	public Double getQuantityVariationWeek() {
		return quantityVariationWeek;
	}
	public void setQuantityVariationWeek(Double quantityVariationWeek) {
		this.quantityVariationWeek = quantityVariationWeek;
	}
	public List<OrderEntity> getOrderPending() {
		return orderPending;
	}
	public void setOrderPending(List<OrderEntity> orderPending) {
		this.orderPending = orderPending;
	}
	public List<OrderEntity> getOrderDelivery() {
		return orderDelivery;
	}
	public void setOrderDelivery(List<OrderEntity> orderDelivery) {
		this.orderDelivery = orderDelivery;
	}
	public List<OrderEntity> getOrderDelivered() {
		return orderDelivered;
	}
	public void setOrderDelivered(List<OrderEntity> orderDelivered) {
		this.orderDelivered = orderDelivered;
	}
	public List<ProductSalesEntity> getFavoriteProducts() {
		return favoriteProducts;
	}
	public void setFavoriteProducts(List<ProductSalesEntity> favoriteProducts) {
		this.favoriteProducts = favoriteProducts;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}

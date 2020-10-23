package com.agroshop.app.model.beans;

import java.time.LocalDateTime;
import java.util.List;

public class MenuDayBean extends MainBean{

	public Integer id;
	public String name;
	public String description;
	private LocalDateTime localDateTime;
	private LocalDateTime localDateTimeFinal;
	public String day;
	private List<ProductSales> menuDayProductList;
	private String type;
	private Double total;
	private Integer countUsedMenu;
	private String status;
	private Integer countTotal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public LocalDateTime getLocalDateTimeFinal() {
		return localDateTimeFinal;
	}

	public void setLocalDateTimeFinal(LocalDateTime localDateTimeFinal) {
		this.localDateTimeFinal = localDateTimeFinal;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public List<ProductSales> getMenuDayProductList() {
		return menuDayProductList;
	}

	public void setMenuDayProductList(List<ProductSales> menuDayProductList) {
		this.menuDayProductList = menuDayProductList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getCountUsedMenu() {
		return countUsedMenu;
	}

	public void setCountUsedMenu(Integer countUsedMenu) {
		this.countUsedMenu = countUsedMenu;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCountTotal() {
		return countTotal;
	}

	public void setCountTotal(Integer countTotal) {
		this.countTotal = countTotal;
	}

}

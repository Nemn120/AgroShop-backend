package com.agroshop.app.model.beans;

public class MenuOptionBean extends MainBean {

	private Integer idMenu;
	private String iconMenu;
	private String nameMenu;
	private String urlMenu;
	private Integer orderNumber;
	private ParentMenuOptionBean parent;
	
	
	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public ParentMenuOptionBean getParent() {
		return parent;
	}

	public void setParent(ParentMenuOptionBean parent) {
		this.parent = parent;
	}

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getIconMenu() {
		return iconMenu;
	}

	public void setIconMenu(String iconMenu) {
		this.iconMenu = iconMenu;
	}

	public String getNameMenu() {
		return nameMenu;
	}

	public void setNameMenu(String nameMenu) {
		this.nameMenu = nameMenu;
	}

	public String getUrlMenu() {
		return urlMenu;
	}

	public void setUrlMenu(String urlMenu) {
		this.urlMenu = urlMenu;
	}

}

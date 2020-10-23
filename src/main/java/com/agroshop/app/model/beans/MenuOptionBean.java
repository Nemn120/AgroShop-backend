package com.agroshop.app.model.beans;

public class MenuOptionBean extends MainBean {

	private Integer idMenu;
	private String iconMenu;
	private String nameMenu;
	private String urlMenu;
	private Integer order;
	private MenuOptionBean parent;
	
	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public MenuOptionBean getParent() {
		return parent;
	}

	public void setParent(MenuOptionBean parent) {
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

package com.agroshop.app.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="menu_option")
public class MenuOptionEntity extends MainEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMenu;
	private String iconMenu;
	private String nameMenu;
	private String urlMenu;
	private Integer order;
	@ManyToOne
	@JoinColumn(name = "parent_id", referencedColumnName = "idMenu")
	private MenuOptionEntity parent;
	
	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public MenuOptionEntity getParent() {
		return parent;
	}

	public void setParent(MenuOptionEntity parent) {
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

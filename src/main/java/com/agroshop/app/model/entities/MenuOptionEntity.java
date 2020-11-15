package com.agroshop.app.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "menu_option")
@Where(clause="is_active = 'True'")
public class MenuOptionEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_menu")
	private Integer idMenu;
	private String iconMenu;
	private String nameMenu;
	private String urlMenu;
	private Integer orderNumber;
	@Column(name="is_active")
	private Boolean isActive;
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private ParentMenuOptionEntity parent;

	public ParentMenuOptionEntity getParent() {
		return parent;
	}

	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setParent(ParentMenuOptionEntity parent) {
		this.parent = parent;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
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

	@Override
	public String toString() {
		return "MenuOptionEntity [idMenu=" + idMenu + ", iconMenu=" + iconMenu + ", nameMenu=" + nameMenu + ", urlMenu="
				+ urlMenu + ", orderNumber=" + orderNumber + ", parent=" + parent + "]";
	}
	
	

}

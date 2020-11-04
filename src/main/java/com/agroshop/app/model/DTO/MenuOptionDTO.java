package com.agroshop.app.model.DTO;

import java.util.List;

public class MenuOptionDTO {
	
	private String label;
	private String faIcon;
	private String link;
	private Integer orderNumber;
	private Integer id;
	List<MenuOptionDTO> items;
	
	public MenuOptionDTO(Integer id,String label,String faIcon,Integer orderNumber) {
		this.label=label;
		this.faIcon=faIcon;
		this.orderNumber=orderNumber;
		this.id=id;
	}
	
	public MenuOptionDTO(Integer id,String label,String faIcon,Integer orderNumber,String link) {
		this(id,label, faIcon,orderNumber);
		this.link=link;
	}
	
	public MenuOptionDTO() {}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getFaIcon() {
		return faIcon;
	}
	@Override
	public String toString() {
		return "MenuOptionDTO [label=" + label + ", faIcon=" + faIcon + ", link=" + link + ", orderNumber="
				+ orderNumber + ", id=" + id + ", items=" + items + "]";
	}

	public void setFaIcon(String faIcon) {
		this.faIcon = faIcon;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public List<MenuOptionDTO> getItems() {
		return items;
	}
	public void setItems(List<MenuOptionDTO> items) {
		this.items = items;
	}
	
	
	
	
}

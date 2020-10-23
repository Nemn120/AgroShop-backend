package com.agroshop.app.model.beans;

public class CategoryProductBean extends MainBean {

	private Integer id;
	private String name;
	private String description;
	private String pathPhoto;
	private String iconPath;
	private byte[] photo;

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

	public String getPathPhoto() {
		return pathPhoto;
	}

	public void setPathPhoto(String pathPhoto) {
		this.pathPhoto = pathPhoto;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
}

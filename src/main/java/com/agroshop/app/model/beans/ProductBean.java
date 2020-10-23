package com.agroshop.app.model.beans;

public class ProductBean extends MainBean {

	private Integer id;
	private String name;
	private String description;
	private String pathPhoto;
	private byte[] photo;
	private CategoryProductBean category;

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

	public CategoryProductBean getCategory() {
		return category;
	}

	public void setCategory(CategoryProductBean category) {
		this.category = category;
	}
}

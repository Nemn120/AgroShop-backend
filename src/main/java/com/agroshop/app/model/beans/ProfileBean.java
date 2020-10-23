package com.agroshop.app.model.beans;

public class ProfileBean extends MainBean {

	private Integer idProfile;
	private String name;
	private String description;

	public Integer getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Integer idProfile) {
		this.idProfile = idProfile;
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

}

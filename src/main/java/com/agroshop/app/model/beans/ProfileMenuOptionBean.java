package com.agroshop.app.model.beans;

public class ProfileMenuOptionBean extends MainBean {

	private Integer idMenuRol;
	private ProfileBean profile;
	private MenuOptionBean menu;

	public Integer getIdMenuRol() {
		return idMenuRol;
	}

	public void setIdMenuRol(Integer idMenuRol) {
		this.idMenuRol = idMenuRol;
	}

	public ProfileBean getProfile() {
		return profile;
	}

	public void setProfile(ProfileBean profile) {
		this.profile = profile;
	}

	public MenuOptionBean getMenu() {
		return menu;
	}

	public void setMenu(MenuOptionBean menu) {
		this.menu = menu;
	}

}

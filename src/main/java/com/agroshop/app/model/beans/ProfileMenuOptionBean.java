package com.agroshop.app.model.beans;

public class ProfileMenuOptionBean extends MainBean {

	private Integer profileMenuId;
	private ProfileBean profile;
	private MenuOptionBean menu;

	public ProfileBean getProfile() {
		return profile;
	}

	public Integer getProfileMenuId() {
		return profileMenuId;
	}

	public void setProfileMenuId(Integer profileMenuId) {
		this.profileMenuId = profileMenuId;
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

package com.agroshop.app.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="profile_menu_option")
public class ProfileMenuOptionEntity extends MainEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer profileMenuId;
	@ManyToOne
	@JoinColumn(name = "profile_id", nullable = false, referencedColumnName = "idProfile")
	private ProfileEntity profile;
	@ManyToOne
	@JoinColumn(name = "menu_id", nullable = false, referencedColumnName = "idMenu")
	private MenuOptionEntity menu;

	public Integer getProfileMenuId() {
		return profileMenuId;
	}

	public void setProfileMenuId(Integer profileMenuId) {
		this.profileMenuId = profileMenuId;
	}

	public ProfileEntity getProfile() {
		return profile;
	}

	public void setProfile(ProfileEntity profile) {
		this.profile = profile;
	}

	public MenuOptionEntity getMenu() {
		return menu;
	}

	public void setMenu(MenuOptionEntity menu) {
		this.menu = menu;
	}

}

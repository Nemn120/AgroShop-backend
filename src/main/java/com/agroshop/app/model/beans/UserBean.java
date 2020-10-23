package com.agroshop.app.model.beans;

import java.time.LocalDate;

public class UserBean extends MainBean {

	private Integer id;
	private String name;
	private String password;
	private String status;
	private String address;
	private String cellPhone;
	private String username;
	private String email;
	private String documentTypeId;
	private String documentNumber;
	private LocalDate birthdate;
	private String lastName;
	private String enableUser;
	private byte[] photo;
	private ProfileBean profile;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDocumentTypeId() {
		return documentTypeId;
	}

	public void setDocumentTypeId(String documentTypeId) {
		this.documentTypeId = documentTypeId;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public ProfileBean getProfile() {
		return profile;
	}

	public void setProfile(ProfileBean profile) {
		this.profile = profile;
	}
	
	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getEnableUser() {
		return enableUser;
	}

	public void setEnableUser(String enableUser) {
		this.enableUser = enableUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

package com.agroshop.app.model.beans;

import java.time.LocalDate;
public class CompanyBean extends MainBean {

	private Integer id;
	private String nombre;
	private String ruc;
	private String businessName;
	private String description;
	private String address;
	private String phone;
	private String status;
	private LocalDate anniversaryDate;
	private UserBean userAdmin;
	private byte[] photo;
	private byte[] imagePanel;
	private String companyStatus;
	private Double qualification;
	private String additionalInformation;
	private PlaceBean place;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyStatus() {
		return companyStatus;
	}

	public void setCompanyStatus(String companyStatus) {
		this.companyStatus = companyStatus;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getAnniversaryDate() {
		return anniversaryDate;
	}

	public void setAnniversaryDate(LocalDate anniversaryDate) {
		this.anniversaryDate = anniversaryDate;
	}

	public UserBean getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(UserBean userAdmin) {
		this.userAdmin = userAdmin;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public byte[] getImagePanel() {
		return imagePanel;
	}

	public void setImagePanel(byte[] imagePanel) {
		this.imagePanel = imagePanel;
	}

	public Double getQualification() {
		return qualification;
	}

	public void setQualification(Double qualification) {
		this.qualification = qualification;
	}

	public PlaceBean getPlace() {
		return place;
	}

	public void setPlace(PlaceBean place) {
		this.place = place;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

}
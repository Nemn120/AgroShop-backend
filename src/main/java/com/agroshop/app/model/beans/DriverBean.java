package com.agroshop.app.model.beans;

public class DriverBean {
	
	private Integer id;
	private String driverLicenseNumber;
	private String yearsOfExperience;
	private Double qualification;
	private UserBean user;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDriverLicenseNumber() {
		return driverLicenseNumber;
	}
	public void setDriverLicenseNumber(String driverLicenseNumber) {
		this.driverLicenseNumber = driverLicenseNumber;
	}
	public String getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public Double getQualification() {
		return qualification;
	}
	public void setQualification(Double qualification) {
		this.qualification = qualification;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	
	
	
	
	
	
	

}

package com.agroshop.app.controllerTests;

import com.agroshop.app.model.entities.DriverEntity;

public class RegisterDTO {
	
	private DriverEntity driver;
	private String userType;
	public DriverEntity getDriver() {
		return driver;
	}
	public void setDriver(DriverEntity driver) {
		this.driver = driver;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}

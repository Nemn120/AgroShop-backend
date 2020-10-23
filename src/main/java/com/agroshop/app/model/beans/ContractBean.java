package com.agroshop.app.model.beans;

import java.time.LocalDateTime;

public class ContractBean extends MainBean{
	private Integer id;
	private LocalDateTime initDate;
	private LocalDateTime finalDate;
	private String contractPath;
	private Integer contractDay;
	private DriverBean driver;
	private CompanyBean company;
	private FarmerBean farmer;
	private String info;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getInitDate() {
		return initDate;
	}
	public void setInitDate(LocalDateTime initDate) {
		this.initDate = initDate;
	}
	public LocalDateTime getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(LocalDateTime finalDate) {
		this.finalDate = finalDate;
	}
	public String getContractPath() {
		return contractPath;
	}
	public void setContractPath(String contractPath) {
		this.contractPath = contractPath;
	}

	public Integer getContractDay() {
		return contractDay;
	}
	public void setContractDay(Integer contractDay) {
		this.contractDay = contractDay;
	}
	public DriverBean getDriver() {
		return driver;
	}
	public void setDriver(DriverBean driver) {
		this.driver = driver;
	}
	public CompanyBean getCompany() {
		return company;
	}
	public void setCompany(CompanyBean company) {
		this.company = company;
	}
	public FarmerBean getFarmer() {
		return farmer;
	}
	public void setFarmer(FarmerBean farmer) {
		this.farmer = farmer;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	
	
}

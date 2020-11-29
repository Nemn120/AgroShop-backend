package com.agroshop.app.model.DTO;

import java.util.Date;

public class SearchJobOfferByFieldsDTO {

	private String status;
	private String departmentIni;
	private String departmentFin;
	private Date dateIni;
	private Date dateFin;
	private Double weightIni;
	private Double weightFin;
	private Double priceIni;
	private Double priceFin;
	private Integer idFarmer;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDepartmentIni() {
		return departmentIni;
	}
	public void setDepartmentIni(String departmentIni) {
		this.departmentIni = departmentIni;
	}
	public String getDepartmentFin() {
		return departmentFin;
	}
	public void setDepartmentFin(String departmentFin) {
		this.departmentFin = departmentFin;
	}
	public Date getDateIni() {
		return dateIni;
	}
	public void setDateIni(Date dateIni) {
		this.dateIni = dateIni;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Double getWeightIni() {
		return weightIni;
	}
	public void setWeightIni(Double weightIni) {
		this.weightIni = weightIni;
	}
	public Double getWeightFin() {
		return weightFin;
	}
	public void setWeightFin(Double weightFin) {
		this.weightFin = weightFin;
	}
	public Double getPriceIni() {
		return priceIni;
	}
	public void setPriceIni(Double priceIni) {
		this.priceIni = priceIni;
	}
	public Double getPriceFin() {
		return priceFin;
	}
	public void setPriceFin(Double priceFin) {
		this.priceFin = priceFin;
	}
	public Integer getIdFarmer() {
		return idFarmer;
	}
	public void setIdFarmer(Integer idFarmer) {
		this.idFarmer = idFarmer;
	}
	
	
}

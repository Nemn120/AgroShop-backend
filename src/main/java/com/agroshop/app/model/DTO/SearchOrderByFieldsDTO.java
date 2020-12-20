package com.agroshop.app.model.DTO;

import java.time.LocalDateTime;

public class SearchOrderByFieldsDTO {
	
	private Integer farmer;
	private String status;
	private Double priceIni;
	private Double priceFin;
	private String destinationProvince;
	private String destinationRegion;
	private String destinationDistrict;
	private String documentNumber;
	private LocalDateTime dateIni;
	private LocalDateTime dateFin;
	
	
	public Integer getFarmer() {
		return farmer;
	}
	public void setFarmer(Integer farmer) {
		this.farmer = farmer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getDestinationProvince() {
		return destinationProvince;
	}
	public void setDestinationProvince(String destinationProvince) {
		this.destinationProvince = destinationProvince;
	}
	public String getDestinationRegion() {
		return destinationRegion;
	}
	public void setDestinationRegion(String destinationRegion) {
		this.destinationRegion = destinationRegion;
	}
	public String getDestinationDistrict() {
		return destinationDistrict;
	}
	public void setDestinationDistrict(String destinationDistrict) {
		this.destinationDistrict = destinationDistrict;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public LocalDateTime getDateIni() {
		return dateIni;
	}
	public void setDateIni(LocalDateTime dateIni) {
		this.dateIni = dateIni;
	}
	public LocalDateTime getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	
	
}

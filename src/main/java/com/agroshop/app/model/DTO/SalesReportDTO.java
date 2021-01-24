package com.agroshop.app.model.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class SalesReportDTO {

	private Integer farmer;
	private String status;
	private LocalDateTime dateIni;
	private LocalDateTime dateFin;
	private List<Integer> ids;
	
	
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
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	
}

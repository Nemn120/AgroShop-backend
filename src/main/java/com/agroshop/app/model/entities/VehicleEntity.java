package com.agroshop.app.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="vehicle")
@Where(clause="is_Deleted = 'False'")
public class VehicleEntity extends MainEntity{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private Integer id;
	private String plateNumber;
	private String serialNumber;
	private String vehicleBrand;
	private String vehicleModel;
	private String vehicleHolder;
	private Integer yearsOfUse;
	private String statusCar;
	private String fuelType;
	private Double netWeight;
	private Double grossWeight;
	
	@JsonIgnore
	@Column(name = "photo", updatable = false)
	private byte[] photo;
	
	@ManyToOne
	@JoinColumn(name = "driver_id", referencedColumnName = "id")
	private DriverEntity driver;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleHolder() {
		return vehicleHolder;
	}

	public void setVehicleHolder(String vehicleHolder) {
		this.vehicleHolder = vehicleHolder;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public DriverEntity getDriver() {
		return driver;
	}

	public void setDriver(DriverEntity driver) {
		this.driver = driver;
	}

	public Integer getYearsOfUse() {
		return yearsOfUse;
	}

	public void setYearsOfUse(Integer yearsOfUse) {
		this.yearsOfUse = yearsOfUse;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public Double getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(Double netWeight) {
		this.netWeight = netWeight;
	}

	public Double getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(Double grossWeight) {
		this.grossWeight = grossWeight;
	}

	public String getStatusCar() {
		return statusCar;
	}

	public void setStatusCar(String statusCar) {
		this.statusCar = statusCar;
	}

	
	
}

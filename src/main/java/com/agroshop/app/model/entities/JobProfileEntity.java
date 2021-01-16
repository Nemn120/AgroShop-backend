package com.agroshop.app.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="job_profile")
public class JobProfileEntity extends MainEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private Integer id;
	private Integer yearsOfExperience;
	private String  typeOfLicense;
	private String  typeOfAvailability; // tipo de disponibilidad
	private Boolean IsHastools; //Tiene herramientas?
	private String  academicDegree; //grado academico
	private String  personalDescription;
	private Double minSalaryAccept;
	private String currentSituation;
	private String descriptionPerfil;
	
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private DriverEntity driver;

	public Double getMinSalaryAccept() {
		return minSalaryAccept;
	}
	public void setMinSalaryAccept(Double minSalaryAccept) {
		this.minSalaryAccept = minSalaryAccept;
	}
	public String getCurrentSituation() {
		return currentSituation;
	}
	public void setCurrentSituation(String currentSituation) {
		this.currentSituation = currentSituation;
	}
	public String getDescriptionPerfil() {
		return descriptionPerfil;
	}
	public void setDescriptionPerfil(String descriptionPerfil) {
		this.descriptionPerfil = descriptionPerfil;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public String getTypeOfLicense() {
		return typeOfLicense;
	}
	public void setTypeOfLicense(String typeOfLicense) {
		this.typeOfLicense = typeOfLicense;
	}
	public String getTypeOfAvailability() {
		return typeOfAvailability;
	}
	public void setTypeOfAvailability(String typeOfAvailability) {
		this.typeOfAvailability = typeOfAvailability;
	}
	public Boolean getIsHastools() {
		return IsHastools;
	}
	public void setIsHastools(Boolean isHastools) {
		IsHastools = isHastools;
	}
	public String getAcademicDegree() {
		return academicDegree;
	}
	public void setAcademicDegree(String academicDegree) {
		this.academicDegree = academicDegree;
	}
	public String getPersonalDescription() {
		return personalDescription;
	}
	public void setPersonalDescription(String personalDescription) {
		this.personalDescription = personalDescription;
	}
	public DriverEntity getDriver() {
		return driver;
	}
	public void setDriver(DriverEntity driver) {
		this.driver = driver;
	}
	
}

package com.agroshop.app.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_profile")
public class JobProfileEntity {

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
	private Boolean IsSpeakEnglish; 
	private String  personalDescription;
	
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
	public Boolean getIsSpeakEnglish() {
		return IsSpeakEnglish;
	}
	public void setIsSpeakEnglish(Boolean isSpeakEnglish) {
		IsSpeakEnglish = isSpeakEnglish;
	}
	public String getPersonalDescription() {
		return personalDescription;
	}
	public void setPersonalDescription(String personalDescription) {
		this.personalDescription = personalDescription;
	}
	
	
}

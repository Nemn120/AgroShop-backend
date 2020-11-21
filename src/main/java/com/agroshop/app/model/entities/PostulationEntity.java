package com.agroshop.app.model.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="job_offer")
public class PostulationEntity extends MainEntity{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private Integer id;
	private String statusPostulation;
	@Column(name = "postulation_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime postulationDate;
	private String detail;
	private String reply;
	
	@ManyToOne
	@JoinColumn(name = "job_offer_id")
	private JobOfferEntity jobOffer;
	
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private DriverEntity driver;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatusPostulation() {
		return statusPostulation;
	}

	public void setStatusPostulation(String statusPostulation) {
		this.statusPostulation = statusPostulation;
	}

	public LocalDateTime getPostulationDate() {
		return postulationDate;
	}

	public void setPostulationDate(LocalDateTime postulationDate) {
		this.postulationDate = postulationDate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public JobOfferEntity getJobOffer() {
		return jobOffer;
	}

	public void setJobOffer(JobOfferEntity jobOffer) {
		this.jobOffer = jobOffer;
	}

	public DriverEntity getDriver() {
		return driver;
	}

	public void setDriver(DriverEntity driver) {
		this.driver = driver;
	}
	
	

}

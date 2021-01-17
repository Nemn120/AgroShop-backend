package com.agroshop.app.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contrato")
public class ContractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private LocalDate initDate;

	@Column(nullable = false)
	private Integer timeContract;

	@Column(nullable = true)
	private LocalDate endContract;

	@Column(nullable = true)
	private String nameContract;

	@Column(nullable = false)
	private Boolean expired;

	private String status;

	@Column(nullable = true)
	private String fileContract;

	private LocalDateTime createDate;

	private Boolean isDeleted;

	private LocalDateTime updateDate;

	@OneToOne
	@JoinColumn(name = "postulation_id", referencedColumnName = "id")
	private PostulationEntity postulation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getInitDate() {
		return initDate;
	}

	public void setInitDate(LocalDate initDate) {
		this.initDate = initDate;
	}

	public Integer getTimeContract() {
		return timeContract;
	}

	public void setTimeContract(Integer timeContract) {
		this.timeContract = timeContract;
	}

	public LocalDate getEndContract() {
		return endContract;
	}

	public void setEndContract(LocalDate endContract) {
		this.endContract = endContract;
	}

	public String getNameContract() {
		return nameContract;
	}

	public void setNameContract(String nameContract) {
		this.nameContract = nameContract;
	}

	public Boolean getExpired() {
		return expired;
	}

	public void setExpired(Boolean expired) {
		this.expired = expired;
	}

	public PostulationEntity getPostulation() {
		return postulation;
	}

	public void setPostulation(PostulationEntity postulation) {
		this.postulation = postulation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFileContract() {
		return fileContract;
	}

	public void setFileContract(String fileContract) {
		this.fileContract = fileContract;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

}

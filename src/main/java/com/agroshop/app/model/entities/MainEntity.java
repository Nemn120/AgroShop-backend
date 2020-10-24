package com.agroshop.app.model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class MainEntity  implements Serializable  {

	@Column(name = "create_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime createDate;
	@Column(name = "update_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime updateDate;
	private Integer userCreateId;
	private Integer userUpdatedId;
	private Integer organizationId;
	private String status;
	private Boolean isDeleted;
	
	
	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Integer getUserCreateId() {
		return userCreateId;
	}

	public void setUserCreateId(Integer userCreateId) {
		this.userCreateId = userCreateId;
	}

	public Integer getUserUpdatedId() {
		return userUpdatedId;
	}

	public void setUserUpdatedId(Integer userUpdatedId) {
		this.userUpdatedId = userUpdatedId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

package com.agroshop.app.model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@MappedSuperclass
@JsonInclude(Include.NON_NULL)
public class MainEntity  implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "create_date", columnDefinition = "TIMESTAMP", updatable = false)
	private LocalDateTime createDate;
	@Column(name = "update_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime updateDate;
	private Integer userCreateId;
	private Integer userUpdatedId;
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

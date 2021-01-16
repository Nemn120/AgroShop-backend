package com.agroshop.app.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "farmer")
public class FarmerEntity extends MainEntity{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer employeCode;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "origin_place_id")
	private PlaceEntity originPlace;
	
	@ManyToOne
	@JoinColumn(name = "destiny_place_id")
	private PlaceEntity destinyPlace;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEmployeCode() {
		return employeCode;
	}
	public void setEmployeCode(Integer employeCode) {
		this.employeCode = employeCode;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
	
}

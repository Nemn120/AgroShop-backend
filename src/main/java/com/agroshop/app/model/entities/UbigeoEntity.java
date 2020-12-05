package com.agroshop.app.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UBIGEO")
public class UbigeoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDUBIGEO",nullable=false)
	private Integer idUbigeo;
	@Column(name="CODIGODEPARTAMENTO")
	private String codigoDepartamento;
	@Column(name="CODIGOPROVINCIA")
	private String codigoProvincia;
	@Column(name="CODIGODISTRITO")
	private String codigoDistrito;
	@Column(name="NOMBREUBIGEO")
	private String nombreUbigeo;
	
	public Integer getIdUbigeo() {
		return idUbigeo;
	}
	public void setIdUbigeo(Integer idUbigeo) {
		this.idUbigeo = idUbigeo;
	}
	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}
	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}
	public String getCodigoProvincia() {
		return codigoProvincia;
	}
	public void setCodigoProvincia(String codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}
	public String getCodigoDistrito() {
		return codigoDistrito;
	}
	public void setCodigoDistrito(String codigoDistrito) {
		this.codigoDistrito = codigoDistrito;
	}
	public String getNombreUbigeo() {
		return nombreUbigeo;
	}
	public void setNombreUbigeo(String nombreUbigeo) {
		this.nombreUbigeo = nombreUbigeo;
	}

}

package com.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "postales")
public class Postal implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "zip_code")
	private int zipCode;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "municipio")
	private String municipio;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@Column(name = "asentamiento")
	private String asentamiento;
	
	@Column(name = "tipo_asentamiento")
	private String tipoAsentamiento;
	
	@Column(name = "zona")
	private String zona;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getAsentamiento() {
		return asentamiento;
	}
	public void setAsentamiento(String asentamiento) {
		this.asentamiento = asentamiento;
	}
	public String getTipoAsentamiento() {
		return tipoAsentamiento;
	}
	public void setTipoAsentamiento(String tipoAsentamiento) {
		this.tipoAsentamiento = tipoAsentamiento;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	
	
	
	
	

}

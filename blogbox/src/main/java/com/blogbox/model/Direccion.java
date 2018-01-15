package com.blogbox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Direccion {
	
	@JsonProperty("street")
	private String calle;
	
	@JsonProperty("suite")
	private String habitacion;
	
	@JsonProperty("city")
	private String ciudad;
	
	@JsonProperty("zipcode")
	private String codZip;
	
	@JsonProperty("geo")
	private Coordenada ubicacionGeo;

	public Direccion() {
	}
		
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodZip() {
		return codZip;
	}

	public void setCodZip(String codZip) {
		this.codZip = codZip;
	}

	public Coordenada getUbicacionGeo() {
		return ubicacionGeo;
	}

	public void setUbicacionGeo(Coordenada ubicacionGeo) {
		this.ubicacionGeo = ubicacionGeo;
	}

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", habitacion=" + habitacion + ", ciudad=" + ciudad + ", codZip=" + codZip
				+ ", ubicacionGeo=" + ubicacionGeo + "]";
	}
	
}

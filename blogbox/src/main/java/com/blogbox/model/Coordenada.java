package com.blogbox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordenada {
	
	@JsonProperty("lat")
	private double latitud;
	
	@JsonProperty("lng")
	private double longitud;
	
	public Coordenada() {
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Coordenada [latitud=" + latitud + ", longitud=" + longitud + "]";
	}
	
}

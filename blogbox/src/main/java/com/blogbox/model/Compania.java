package com.blogbox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Compania {

	@JsonProperty("name")
	private String nombre;

	@JsonProperty("catchPhrase")
	private String slogan;

	@JsonProperty("bs")
	private String bs;
	
	public Compania() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	@Override
	public String toString() {
		return "Compania [nombre=" + nombre + ", slogan=" + slogan + ", bs=" + bs + "]";
	}
	
}

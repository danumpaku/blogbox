package com.blogbox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Galeria {

	@JsonProperty("id")
	private long id;
	
	@JsonProperty("userId")
	private long idUsuario;
	
	@JsonProperty("title")
	private String titulo;
	
	public Galeria() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "GalleriaInfo [id=" + id + ", idUsuario=" + idUsuario + ", titulo=" + titulo + "]";
	}
	
}

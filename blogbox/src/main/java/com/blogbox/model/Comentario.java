package com.blogbox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comentario {

	@JsonProperty("id")
	private long id;

	@JsonProperty("postId")
	private long idPublicacion;

	@JsonProperty("name")
	private String nombre;

	@JsonProperty("email")
	private String email;

	@JsonProperty("body")
	private String cuerpo;

	public Comentario() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(long idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", idPublicacion=" + idPublicacion + ", nombre=" + nombre + ", email=" + email
				+ ", cuerpo=" + cuerpo + "]";
	}
	
}

package com.blogbox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario {

	@JsonProperty("id")
	private long id;

	@JsonProperty("name")
	private String nombre;

	@JsonProperty("username")
	private String nomUsuario;

	@JsonProperty("email")
	private String email;

	@JsonProperty("address")
	private Direccion direccion;

	@JsonProperty("phone")
	private String telefono;

	@JsonProperty("website")
	private String sitioWeb;

	@JsonProperty("company")
	private Compania compania;
	
	public Usuario() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public Compania getCompania() {
		return compania;
	}

	public void setCompania(Compania compania) {
		this.compania = compania;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", nomUsuario=" + nomUsuario + ", email=" + email
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", sitioWeb=" + sitioWeb + ", compania="
				+ compania + "]";
	}
	
	
}

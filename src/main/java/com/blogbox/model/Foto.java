package com.blogbox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Foto {
	
	@JsonProperty("id")
	private long id;
	
	@JsonProperty("albumId")
	private long idAlbum;
	
	@JsonProperty("title")
	private String titulo;
	
	@JsonProperty("url")
	private String urlFoto;
	
	@JsonProperty("thumbnailUrl")
	private String urlMiniatura;

	public Foto() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(long idAlbum) {
		this.idAlbum = idAlbum;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getUrlMiniatura() {
		return urlMiniatura;
	}

	public void setUrlMiniatura(String urlMiniatura) {
		this.urlMiniatura = urlMiniatura;
	}

	@Override
	public String toString() {
		return "Foto [id=" + id + ", idAlbum=" + idAlbum + ", titulo=" + titulo + ", urlFoto=" + urlFoto
				+ ", urlMiniatura=" + urlMiniatura + "]";
	}
	
}

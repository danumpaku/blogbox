package com.blogbox.model;

public class Perfil {

	private Usuario usuario;
	private String urlFotoPerfil;
	
	public Perfil() {
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getUrlFotoPerfil() {
		return urlFotoPerfil;
	}

	public void setUrlFotoPerfil(String urlFotoPerfil) {
		this.urlFotoPerfil = urlFotoPerfil;
	}

	@Override
	public String toString() {
		return "Perfil [usuario=" + usuario + ", urlFotoPerfil=" + urlFotoPerfil + "]";
	}
	
}

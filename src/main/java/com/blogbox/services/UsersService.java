package com.blogbox.services;

import java.util.List;

import com.blogbox.model.Perfil;
import com.blogbox.model.Usuario;

public interface UsersService {

	public List<Perfil> getAllPerfiles();
	
	public List<Usuario> getAllUsuarios();
	
	public Usuario getUsuarioById (long idUsuario);
	
	public Perfil getPerfilById(long idUsuario);
	
}

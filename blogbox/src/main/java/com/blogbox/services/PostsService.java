package com.blogbox.services;

import java.util.List;

import com.blogbox.model.Comentario;
import com.blogbox.model.Publicacion;

public interface PostsService {

	public List<Publicacion> getAllPublicacionesByUsuario (long idUsuario);
	
	public List<Comentario> getAllComentariosByPublicacion (long idPublicacion);
	
}

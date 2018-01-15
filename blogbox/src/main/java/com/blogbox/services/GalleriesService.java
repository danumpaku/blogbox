package com.blogbox.services;

import java.util.List;

import com.blogbox.model.Galeria;
import com.blogbox.model.Foto;

public interface GalleriesService {

	public List<Galeria> getAllAlbumesByUsuario (long idUsuario);
	
	public List<Foto> getAllFotosByAlbum (long idAlbum);
	
}

package com.blogbox.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blogbox.constants.Const;
import com.blogbox.logs.Logger;
import com.blogbox.model.Galeria;
import com.blogbox.model.Foto;
import com.blogbox.model.Perfil;
import com.blogbox.model.Usuario;
import com.blogbox.services.GalleriesService;
import com.blogbox.services.UsersService;

import static com.blogbox.constants.Const.*;

@Service(SERV_USERS)
public class UserServiceImpl implements UsersService {

	private static final Logger logger = new Logger(UserServiceImpl.class);
	
	@Autowired
	@Qualifier(SERV_GALLERY)
	private GalleriesService galleriesService;
	
	//TODO Haria falta un servicio que retorne la url de la foto con el usuario directamente para no estar consumiendo el de la galeria, o modificar el actual de usuarios
	@Override
	public List<Perfil> getAllPerfiles() {
		
		logger.info("getAllPerfiles", "Consutando perfiles");
		List<Perfil> perfiles = new ArrayList<>();
		
		try {
			List<Usuario> usuarios = getAllUsuarios();
			for (Usuario usuario : usuarios) {
				
				Perfil perfil = new Perfil();
				perfil.setUsuario(usuario);
				
				List<Galeria> albums = galleriesService.getAllAlbumesByUsuario(usuario.getId());
				List<Foto> fotosPerfil = null;
				
				if (albums != null && ! albums.isEmpty()) {
					fotosPerfil = galleriesService.getAllFotosByAlbum(albums.get(0).getId()); 	//TODO se esta asumiendo que el primer album es el de fotos de perfil
				}
				
				if (fotosPerfil != null && ! fotosPerfil.isEmpty()) {
					perfil.setUrlFotoPerfil(fotosPerfil.get(0).getUrlFoto());
				}
				else {
					logger.info("getAllPerfiles", "El usuario no tiene fotos, se coloca foto por defecto");
					perfil.setUrlFotoPerfil(DEFAULT_PHOTO);
				}
				
				perfiles.add(perfil);
			}
			
			logger.info("getAllPerfiles", "Se obtuvieron " + perfiles.size() + " perfiles");
		}
		catch (Exception e){
			logger.info("getAllPerfiles", "Error al consumir el recurso");
			perfiles = null;
		}
		
		return perfiles;
	}
	
	@Override
	public List<Usuario> getAllUsuarios() {
		
		logger.info("getAllUsuarios", "Consutando usuarios");
		List<Usuario> usuarios = null;
		
		try {
			String url = Const.URL_SERV_USUARIOS;
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Usuario[]> responseEntity = restTemplate.getForEntity(url, Usuario[].class);
			usuarios = Arrays.asList(responseEntity.getBody());
			
			logger.info("getAllUsuarios", "Se obtuvieron " + usuarios.size() + " usuarios");
		}
		catch (Exception e){
			logger.info("getAllUsuarios", "Error al consumir el recurso");
		}
		
		return usuarios;
	}

	@Override
	public Usuario getUsuarioById(long idUsuario) {
		
		logger.info("getUsuarioById", "Consutando usuario id=" + idUsuario);
		
		List<Usuario> usuarios = getAllUsuarios();
		Usuario usuario = null;
		
		if (usuarios != null && ! usuarios.isEmpty()){
			for (Usuario u : usuarios){
				if (u.getId() == idUsuario){
					usuario = u;
					break;
				}
			}
		}
		
		if (usuario != null){
			logger.info("getUsuarioById", "Usuario encontrado");
		}
		else {
			logger.info("getUsuarioById", "NO se encontro el usuario id=" + idUsuario);
		}
		
		return usuario;
	}

}

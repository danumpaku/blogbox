package com.blogbox.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blogbox.constants.Const;
import com.blogbox.logs.Logger;
import com.blogbox.model.Comentario;
import com.blogbox.model.Publicacion;
import com.blogbox.services.PostsService;
import com.blogbox.util.StringUtil;

import static com.blogbox.constants.Const.*;

@Service(SERV_POSTS)
public class PostServiceImpl implements PostsService {

	private static final Logger logger = new Logger(PostServiceImpl.class);

	@Override
	public List<Publicacion> getAllPublicacionesByUsuario(long idUsuario) {
		
		logger.info("getAllPublicacionesByUsuario", "Consutando publicaciones del usuario id=" + idUsuario);
		List<Publicacion> publicaciones = null;
		
		try{
			String url = StringUtil.buildUrl(Const.URL_SERV_PUBLICACIONES, Const.PARAM_ID_USUARIO, idUsuario);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Publicacion[]> responseEntity = restTemplate.getForEntity(url, Publicacion[].class);
			publicaciones = Arrays.asList(responseEntity.getBody());
			
			logger.info("getAllPublicacionesByUsuario", "Se obtuvieron " + publicaciones.size() + " publicaciones");
		}
		catch (Exception e){
			logger.info("getAllPublicacionesByUsuario", "Error al consumir el recurso");
		}
		
		return publicaciones;
	}

	@Override
	public List<Comentario> getAllComentariosByPublicacion(long idPublicacion) {
		
		logger.info("getAllComentariosByPublicacion", "Consutando comentarios de la publicacion id=" + idPublicacion);
		List<Comentario> comentarios = null;
		
		try{
			String url = StringUtil.buildUrl(Const.URL_SERV_COMENTARIOS, Const.PARAM_ID_PUBLICACION, idPublicacion);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Comentario[]> responseEntity = restTemplate.getForEntity(url, Comentario[].class);
			comentarios = Arrays.asList(responseEntity.getBody());
			
			logger.info("getAllComentariosByPublicacion", "Se obtuvieron " + comentarios.size() + " comentarios");
		}
		catch (Exception e){
			logger.info("getAllComentariosByPublicacion", "Error al consumir el recurso");
		}
		
		return comentarios;
	}

}

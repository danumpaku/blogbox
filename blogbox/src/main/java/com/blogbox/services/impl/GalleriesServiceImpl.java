package com.blogbox.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blogbox.constants.Const;
import com.blogbox.logs.Logger;
import com.blogbox.model.Galeria;
import com.blogbox.model.Foto;
import com.blogbox.services.GalleriesService;
import com.blogbox.util.StringUtil;

import static com.blogbox.constants.Const.*;

@Service(SERV_GALLERY)
public class GalleriesServiceImpl implements GalleriesService {

	private static final Logger logger = new Logger(GalleriesServiceImpl.class);
	
	@Override
	public List<Galeria> getAllAlbumesByUsuario(long idUsuario) {
		
		logger.info("getAllAlbumesByUsuario", "Consutando albumes del usuario id=" + idUsuario);
		List<Galeria> albumes = null;
		
		try{
			String url = StringUtil.buildUrl(Const.URL_SERV_ALBUMES, Const.PARAM_ID_USUARIO, idUsuario);
			logger.info("getAllAlbumesByUsuario", "url consumo="+url);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Galeria[]> responseEntity = restTemplate.getForEntity(url, Galeria[].class);
			albumes = Arrays.asList(responseEntity.getBody());
			
			logger.info("getAllAlbumesByUsuario", "Se obtuvieron " + albumes.size() + " albumes");
		}
		catch (Exception e){
			logger.info("getAllAlbumesByUsuario", "Error al consumir el recurso");
		}
		
		return albumes;
	}

	@Override
	public List<Foto> getAllFotosByAlbum(long idAlbum) {
		logger.info("getAllFotosByAlbum", "Consutando fotos del album id=" + idAlbum);
		List<Foto> fotos = null;
		
		try{
			String url = StringUtil.buildUrl(Const.URL_SERV_FOTOS, Const.PARAM_ID_ALBUM, idAlbum);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Foto[]> responseEntity = restTemplate.getForEntity(url, Foto[].class);
			fotos = Arrays.asList(responseEntity.getBody());
			
			logger.info("getAllFotosByAlbum", "Se obtuvieron " + fotos.size() + " fotos");
		}
		catch (Exception e){
			logger.info("getAllFotosByAlbum", "Error al consumir el recurso");
		}
		
		return fotos;
	}

}

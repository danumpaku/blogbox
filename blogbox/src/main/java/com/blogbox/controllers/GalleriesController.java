package com.blogbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blogbox.logs.Logger;
import com.blogbox.model.Perfil;
import com.blogbox.model.Usuario;
import com.blogbox.services.GalleriesService;
import com.blogbox.services.UsersService;

import static com.blogbox.constants.Const.*;

@Controller
@RequestMapping(REQ_GALLERY)
public class GalleriesController {
	
	private static final Logger logger = new Logger(GalleriesController.class); 

	@Autowired
	@Qualifier(SERV_USERS)
	UsersService usersService;
	
	@Autowired
	@Qualifier(SERV_GALLERY)
	GalleriesService galleriesService;
	
	@GetMapping("")
	public ModelAndView getGalleriesByUser(@RequestParam("user") long userId){
		
		logger.info("getGalleriesByUser", "Buscando galerias de usuario id=" + userId);
		
		ModelAndView mav = new ModelAndView(VIEW_GALLERY);
		Perfil perfil = usersService.getPerfilById(userId);
		Usuario usu = perfil.getUsuario();

		mav.addObject("usuario", usu);
		mav.addObject("urlPhoto", perfil.getUrlFotoPerfil());
		mav.addObject("pageName", usu.getNomUsuario());
		mav.addObject("galleries", galleriesService.getAllGaleriasByUsuario(userId));
		return mav;
	}
	
	@GetMapping("/photos")
	public ModelAndView getPhotosByGallery(@RequestParam("user") long userId, @RequestParam("idGal") long idGal){
		
		logger.info("getPhotosByGallery", "Buscando fotos de la galeria id=" + idGal);
		
		ModelAndView mav = new ModelAndView(VIEW_PHOTOS);
		Perfil perfil = usersService.getPerfilById(userId);
		Usuario usu = perfil.getUsuario();

		mav.addObject("usuario", usu);
		mav.addObject("urlPhoto", perfil.getUrlFotoPerfil());
		mav.addObject("pageName", usu.getNomUsuario());
		mav.addObject("photos", galleriesService.getAllFotosByAlbum(idGal));
		return mav;
	}
}

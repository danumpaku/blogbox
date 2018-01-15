package com.blogbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blogbox.logs.Logger;
import com.blogbox.model.Usuario;
import com.blogbox.services.PostsService;
import com.blogbox.services.UsersService;

import static com.blogbox.constants.Const.*;

@Controller
@RequestMapping(REQ_POSTS)
public class PostsController {

	private static final Logger logger = new Logger(PostsController.class); 

	@Autowired
	@Qualifier(SERV_USERS)
	UsersService usersService;
	
	@Autowired
	@Qualifier(SERV_POSTS)
	PostsService postsService;
	
	@GetMapping("")
	public ModelAndView getPostsByUser(@RequestParam("user") long userId){
		
		logger.info("getPostsByUser", "Buscando publicaciones de usuario id=" + userId);
		
		ModelAndView mav = new ModelAndView(VIEW_POSTS);
		Usuario usu = usersService.getUsuarioById(userId);
		logger.info("debug", usu.toString());
		mav.addObject("usuario", usu);
		mav.addObject("posts", postsService.getAllPublicacionesByUsuario(userId));
		return mav;
	}
	
}


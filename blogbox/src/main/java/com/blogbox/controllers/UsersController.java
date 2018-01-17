package com.blogbox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.blogbox.logs.Logger;
import com.blogbox.model.Perfil;
import com.blogbox.services.UsersService;

import static com.blogbox.constants.Const.*;

import java.util.List;

@Controller
@RequestMapping(REQ_USERS)
public class UsersController {
	
	private static final Logger logger = new Logger(UsersController.class); 

	@Autowired
	@Qualifier(SERV_USERS)
	UsersService usersService;
	
	@GetMapping("/")
	public ModelAndView showUsers () {
		ModelAndView mav = new ModelAndView(VIEW_USERS);
		
		logger.info("showUsers", "Consultando usuarios");
		
		List<Perfil> perfiles = usersService.getAllPerfiles();
		mav.addObject("perfiles", perfiles);
		
		return mav;
	}
	
	
}

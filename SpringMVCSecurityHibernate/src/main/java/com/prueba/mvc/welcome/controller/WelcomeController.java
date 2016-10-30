package com.prueba.mvc.welcome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		return "redirect:/generosMusicales";
	}
	
	@RequestMapping(value = "/SpringMVCHibernate", method = RequestMethod.GET)
	public String welcomePage(Model model) {
		return "redirect:/generosMusicales";
	}

}

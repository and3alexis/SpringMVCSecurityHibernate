package com.prueba.mvc.generomusical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prueba.mvc.generomusical.domain.GeneroMusical;
import com.prueba.mvc.generomusical.service.GeneroMusicalService;

@Controller
public class GeneroMusicalController {
	
	@Autowired(required=true)
	private GeneroMusicalService generoMusicalService;
	
	@RequestMapping(value = "/generosMusicales", method = RequestMethod.GET)
	public String listGenerosMusicales(Model model) {
		model.addAttribute("listGenerosMusicales", this.generoMusicalService.listGenerosMusicales());
		return "list_generoMusical";
	}
	
	@RequestMapping(value= "/generoMusical/add", method = RequestMethod.POST)
	public String addGeneroMusical(@ModelAttribute("generoMusical") GeneroMusical generoMusical){
		
		if(generoMusical.getId() == null || generoMusical.getId() == 0){
			this.generoMusicalService.createGeneroMusical(generoMusical);
		}else{
			this.generoMusicalService.updateGeneroMusical(generoMusical);
		}
		
		return "redirect:/generosMusicales";
		
	}
	
	@RequestMapping("/generoMusical/remove/{id}")
    public String removeGeneroMusical(@PathVariable("id") int id){
        this.generoMusicalService.removeGeneroMusical(id);
        return "redirect:/generosMusicales";
    }
 
    @RequestMapping("/generoMusical/edit/{id}")
    public String editGeneroMusical(@PathVariable("id") int id, Model model){
        model.addAttribute("generoMusical", this.generoMusicalService.getGeneroMusicalById(id));
        return "edit_generoMusical";
    }
    
    @RequestMapping("/generoMusical/create")
    public String createGeneroMusical(Model model){
    	model.addAttribute("generoMusical", new GeneroMusical());
        return "create_generoMusical";
    }
    
    @RequestMapping("/generoMusical/cancel")
    public String cancelGeneroMusical(Model model){
    	model.addAttribute("listGenerosMusicales", this.generoMusicalService.listGenerosMusicales());
		return "list_generoMusical";
    }

}

package com.prueba.mvc.generomusical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prueba.mvc.exception.ExceptionHandler;
import com.prueba.mvc.exception.IHandler;
import com.prueba.mvc.generomusical.domain.GeneroMusical;
import com.prueba.mvc.generomusical.service.GeneroMusicalService;

@Controller
public class GeneroMusicalController {
	
	@Autowired
	private GeneroMusicalService generoMusicalService;
	
	@Autowired
	private GeneroMusicalValidator generoMusicalValidator;
	
	@Autowired
	private IHandler handler;
	
	@RequestMapping(value = "/generosMusicales", method = RequestMethod.GET)
	public String listGenerosMusicales(Model model) {
		model.addAttribute("listGenerosMusicales", this.generoMusicalService.listGenerosMusicales());
		return "list_generoMusical";
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
	
	@RequestMapping(value= "/generoMusical/add", method = RequestMethod.POST)
	public String addGeneroMusical(@ModelAttribute("generoMusical")GeneroMusical generoMusical, BindingResult bindingResult, Model model){
		try {
			if(validateGeneroMusicalForm(generoMusical, bindingResult)){
				return "create_generoMusical";
			}
			this.generoMusicalService.createGeneroMusical(generoMusical);
			success(model, "message.generomusical.messageAlert.success");
		} catch (Exception e) {
			return findCorrectException(e, model, "create_generoMusical");
		}
		return "list_generoMusical";
		
	}
	
	@RequestMapping(value= "/generoMusical/update", method = RequestMethod.POST)
	public String updateGeneroMusical(@ModelAttribute("generoMusical") @Validated GeneroMusical generoMusical, BindingResult bindingResult, Model model){
		try {
			if(validateGeneroMusicalForm(generoMusical, bindingResult)){
				return "edit_generoMusical";
			}
			this.generoMusicalService.updateGeneroMusical(generoMusical);
			success(model, "message.generomusical.messageAlert.success");
		} catch (Exception e) {
			return findCorrectException(e, model, "edit_generoMusical");
		}
		return "list_generoMusical";
		
	}
	
	private boolean validateGeneroMusicalForm(GeneroMusical generoMusical, BindingResult bindingResult){
		this.generoMusicalValidator.validate(generoMusical, bindingResult);
		if (bindingResult.hasErrors()) {
			return true;
		}
		return false;
	}
	
	@RequestMapping("/generoMusical/remove/{id}")
    public String removeGeneroMusical(@PathVariable("id") int id, Model model){
		try {
			this.generoMusicalService.removeGeneroMusical(id);
	        success(model, "message.generomusical.messageAlert.delete.success");
		} catch (Exception e) {
			return findCorrectException(e, model, "list_generoMusical");
		}
        return "list_generoMusical";
    }
	
	private void success(Model model, String msg){
		model.addAttribute("listGenerosMusicales", this.generoMusicalService.listGenerosMusicales());
		model.addAttribute("messageAlert", msg);
		model.addAttribute("messageType", "info");
	}
	
	private String findCorrectException(Exception e, Model model, String url){
		ExceptionHandler exHandler = this.handler.getExceptionChain();
		model.addAttribute("messageAlert", exHandler.proccess(e));
		model.addAttribute("messageType", "error");
		return url;
	}
	
}

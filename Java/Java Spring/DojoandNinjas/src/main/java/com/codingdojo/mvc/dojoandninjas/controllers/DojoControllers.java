package com.codingdojo.mvc.dojoandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.dojoandninjas.models.Dojo;
import com.codingdojo.mvc.dojoandninjas.models.Ninja;
import com.codingdojo.mvc.dojoandninjas.services.DojoServcie;


@Controller
public class DojoControllers {

	private final DojoServcie dojoServcie;
	public DojoControllers(DojoServcie dojoServcie) {
	this.dojoServcie=dojoServcie;
	}
	
	@GetMapping("/")
	public String home() {
		return "redirect:/dojos";
	}
	@GetMapping("/dojos")
	public String adddojo(@ModelAttribute ("dojo") Dojo dojo,Model model) {
			return "adddojo.jsp";
	}
	@PostMapping("/add")
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo ,BindingResult result ,Model model) {
        if (result.hasErrors()) {
            return "adddojo.jsp";
        } else {
        	dojoServcie.createLookify(dojo);
            return "redirect:/dojos";
        }
    }
	@GetMapping("/ninjas")
	public String addninja(@ModelAttribute ("ninja") Ninja ninja,Model model) {
			model.addAttribute("alldojos",dojoServcie.findAll());
			return "addninja.jsp";
	}
	@PostMapping("/newninja")
    public String createninja(@Valid @ModelAttribute("ninja") Ninja ninja ,BindingResult result ,Model model) {
        if (result.hasErrors()) {
            return "adddojo.jsp";
        } else {
        	dojoServcie.createNinja(ninja);
            return "redirect:/ninjas";
        }
	}
        
    @GetMapping("/dojos/{id}")
    public String show2(@PathVariable("id") Long id,Model model){
    	model.addAttribute("show",dojoServcie.findLookify(id));

    	return "show.jsp";
    }

}

package com.codingdojo.mvc.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.mvc.languages.models.language;
import com.codingdojo.mvc.languages.servcies.LanguageService;

@Controller
public class LanguagesTest {
	
	private final LanguageService langService;
	public LanguagesTest(LanguageService langService) {
	this.langService=langService;
	}
	
	@GetMapping("/")
	public String home() {
		return "redirect:/languages";
	}
	@GetMapping("/languages")
	public String languages(@ModelAttribute ("language") language lang,Model model) {
			List<language> allLanguages = langService.findAll();
			model.addAttribute("lang", allLanguages);
			return "lang.jsp";
	}
	 @PostMapping("/addlangugae")
	    public String create(@Valid @ModelAttribute("language") language lang ,BindingResult result ,Model model) {
	        if (result.hasErrors()) {
	        	List<language> allLanguages = langService.findAll();
	    		model.addAttribute("lang", allLanguages);
	            return "lang.jsp";
	        } else {
	        	langService.createLanguage(lang);
	            return "redirect:/languages";
	        }
	    }
	 @DeleteMapping("/delete/{id}")
	 public String delete(@PathVariable("id") Long id) {
		 langService.deleteLanguage(id);
		 return "redirect:/languages";
	 }
	 @GetMapping("/lang/{id}")
	 public String showSingle(@PathVariable("id")Long id,Model model) {
		 language lang = langService.findLanguage(id);
		 model.addAttribute("language", lang);
		 return "Show.jsp";
	 }
	 @GetMapping("/edit/{id}")
	 public String edit(@PathVariable("id")Long id,Model model) {
		 language lang = langService.findLanguage(id);
		 model.addAttribute("language", lang);
		 return "edit.jsp";
	 }
	 @PutMapping("/edit/{id}")
	 public String update(@Valid @ModelAttribute("language") language lang,BindingResult result) {
		   if (result.hasErrors()) {
	            return "edit.jsp";
	            }
		   else {
			   langService.updateLanguage(lang);
			   return "redirect:/";
		   }
		 
	 }
	
}

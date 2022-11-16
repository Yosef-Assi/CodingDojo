package com.codingdojo.mvc.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.lookify.models.Lookify;
import com.codingdojo.mvc.lookify.servcies.LookifyService;

@Controller
public class LookifyTest {
	private final LookifyService lookifyService;
	
	public LookifyTest(LookifyService lookifyService) {
		this.lookifyService=lookifyService;
	}
	
	@GetMapping("/")
	public String home() {
		return "Home.jsp";
	}
	@GetMapping("/add1")
	public String home2() {
		return "add.jsp";
	}
	@GetMapping("/lookifies")
	public String languages1(Model model) {
		
			List<Lookify> allLookifys = lookifyService.findAll();
			model.addAttribute("lookify", allLookifys);
			return "Search.jsp";
	}
	@GetMapping("/add")
	public String languages(@ModelAttribute ("yosef") Lookify lang,Model model) {
			return "add.jsp";
	}
	 @PostMapping("/add")
	    public String create(@Valid @ModelAttribute("yosef") Lookify lang ,BindingResult result ,Model model) {
	        if (result.hasErrors()) {
	            return "add.jsp";
	        } else {
	        	lookifyService.createLookify(lang);
	            return "redirect:/lookifies";
	        }
	    }
	@PostMapping("/search")
	public String dashboard(@RequestParam("search") String artist,Model model) {
		model.addAttribute("artist", artist);
		return "redirect:/search/"+artist;
	}
	@GetMapping("/search/{artist}")
	public String search(@PathVariable("artist") String artist, Model model) {
		List<Lookify> songs = lookifyService.findByArtist(artist);
		model.addAttribute("songs", songs);
		return "new.jsp";
	}
	
	@GetMapping("/thetop")
	public String topTen(Model model) {
		List<Lookify> songs = lookifyService.topSong();
		model.addAttribute("songs", songs);
		return "Top.jsp";
	}
	
}

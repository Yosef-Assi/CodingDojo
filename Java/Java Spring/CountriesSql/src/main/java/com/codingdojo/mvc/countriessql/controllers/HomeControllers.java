package com.codingdojo.mvc.countriessql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.mvc.countriessql.services.WorldService;

@RestController
public class HomeControllers {
	
	@Autowired
	WorldService worldService;
	
	
	@RequestMapping("/api/selvone")
	public List<Object[]> allCountry() {
		List<Object[]> all = worldService.allCountries();
		
		return all;
	}
	@RequestMapping("/api/q2")
	public List<Object[]> displayTotalCities() {
		List<Object[]> all = worldService.displayTotalCities();
		
		return all;
	}
	
	@RequestMapping("/api/q3")
	public List<Object[]> q3() {
		List<Object[]> all = worldService.q3();
		
		return all;
	}
	
	
	@RequestMapping("/api/q4")
	public List<Object[]> q4() {
		List<Object[]> all = worldService.q4();
		
		return all;
	}
	
	@RequestMapping("/api/q5")
	public List<Object[]> q5() {
		List<Object[]> all = worldService.q5();
		
		return all;
	}
	@RequestMapping("/api/q6")
	public List<Object[]> q6() {
		List<Object[]> all = worldService.q6();
		
		return all;
	}
	@RequestMapping("/api/q7")
	public List<Object[]> q7() {
		List<Object[]> all = worldService.q7();
		
		return all;
	}
	@RequestMapping("/api/q8")
	public List<Object[]> q8() {
		List<Object[]> all = worldService.q8();
		
		return all;
	}
}

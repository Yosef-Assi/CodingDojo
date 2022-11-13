package com.codingdojo.mvc.countriessql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.countriessql.reposiries.WorldRepo;

@Service
public class WorldService {

	@Autowired
	WorldRepo worldrepo;
	
	
	public List<Object[]> allCountries(){
		
		return worldrepo.allCountries();
	}  
	
	public List<Object[]> displayTotalCities(){
		
		return worldrepo.displayTotalCities();
	}  
	
	
	public List<Object[]> q3(){
		
		return worldrepo.q3();
	}  
	
	public List<Object[]> q4(){
		
		return worldrepo.q4();
}
	
	public List<Object[]> q5(){
		
		return worldrepo.q6();
}
	public List<Object[]> q6(){
		
		return worldrepo.q6();
}
	
	public List<Object[]> q7(){
		
		return worldrepo.q7();
}
	public List<Object[]> q8(){
		
		return worldrepo.q8();
}
	

	
	
}

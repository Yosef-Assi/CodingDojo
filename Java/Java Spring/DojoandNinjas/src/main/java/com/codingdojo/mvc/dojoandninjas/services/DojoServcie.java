package com.codingdojo.mvc.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.dojoandninjas.models.Dojo;
import com.codingdojo.mvc.dojoandninjas.models.Ninja;
import com.codingdojo.mvc.dojoandninjas.repositories.DojoRepo;
import com.codingdojo.mvc.dojoandninjas.repositories.NinjaRepo;


@Service
public class DojoServcie {
	
	
	private final DojoRepo dojoRepo;
	private final NinjaRepo ninja;

	public DojoServcie(DojoRepo dojoRepo,NinjaRepo ninja) {
		this.dojoRepo=dojoRepo;
		this.ninja=ninja;
		
	}
	
	
	public List<Dojo> findAll(){
		return dojoRepo.findAll();
	}
	public Dojo createLookify(Dojo lang) {
		return dojoRepo.save(lang);
	}
	
	public Dojo findLookify(Long id) {
		Optional<Dojo> lookify = dojoRepo.findById(id);
		if(lookify.isPresent()) {
			return lookify.get();
		}
		else {
			return null;
		}
	}
	public Ninja createNinja(Ninja ninj) {
		return ninja.save(ninj);
	}
	public List<Ninja> findNinja(){
		return ninja.findAll();
	}
}

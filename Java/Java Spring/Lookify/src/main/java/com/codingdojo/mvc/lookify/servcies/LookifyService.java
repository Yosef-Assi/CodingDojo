package com.codingdojo.mvc.lookify.servcies;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.lookify.models.Lookify;
import com.codingdojo.mvc.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {

	private final LookifyRepository lookifyRepository;
	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository=lookifyRepository;
		
	}
	public List<Lookify> findAll(){
		return lookifyRepository.findAll();
	}
	public Lookify createLookify(Lookify lang) {
		return lookifyRepository.save(lang);
	}
	
	public Lookify findLookify(Long id) {
		Optional<Lookify> lookify = lookifyRepository.findById(id);
		if(lookify.isPresent()) {
			return lookify.get();
		}
		else {
			return null;
		}
	}
	public void deleteLookify(Long id) {
		Optional<Lookify> lookify = lookifyRepository.findById(id);
		if(lookify.isPresent()) {
			lookifyRepository.deleteById(id);
		}
		
	} 
	public Lookify updateLookify(Lookify lang) {
		return lookifyRepository.save(lang);
	}
	public List<Lookify> findByArtist(String artist){
		return lookifyRepository.findByArtist(artist);
	}
	public List<Lookify> topSong() {
		return lookifyRepository.getTopTen();
	}
}

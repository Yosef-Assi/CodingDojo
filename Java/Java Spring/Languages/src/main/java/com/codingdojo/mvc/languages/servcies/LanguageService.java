package com.codingdojo.mvc.languages.servcies;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.languages.models.language;
import com.codingdojo.mvc.languages.repositories.LanguageRepositore;

@Service
public class LanguageService {
	private final LanguageRepositore languageRepo;
	public LanguageService(LanguageRepositore languageRepo) {
		this.languageRepo=languageRepo;
	}
	public List<language> findAll(){
		return languageRepo.findAll();
	}
	public language createLanguage(language lang) {
		return languageRepo.save(lang);
	}
	
	public language findLanguage(Long id) {
		Optional<language> flanguage = languageRepo.findById(id);
		if(flanguage.isPresent()) {
			return flanguage.get();
		}
		else {
			return null;
		}
	}
	public void deleteLanguage(Long id) {
		Optional<language> flanguage = languageRepo.findById(id);
		if(flanguage.isPresent()) {
			languageRepo.deleteById(id);
		}
		
	} 
	public language updateLanguage(language lang) {
		return languageRepo.save(lang);
	}

}

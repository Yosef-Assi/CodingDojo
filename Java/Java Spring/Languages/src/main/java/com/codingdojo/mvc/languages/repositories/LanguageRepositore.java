package com.codingdojo.mvc.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.languages.models.language;

@Repository
public interface LanguageRepositore extends CrudRepository<language, Long>{
	List<language> findAll();

}

package com.codingdojo.mvc.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.lookify.models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long>{
	List<Lookify> findAll();
	List<Lookify> findByArtist(String artist);
	@Query(value = "select * from lookify order by rating desc limit 10", nativeQuery = true) 
	List<Lookify> getTopTen();

}

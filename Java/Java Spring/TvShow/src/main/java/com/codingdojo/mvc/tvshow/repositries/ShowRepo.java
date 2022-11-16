package com.codingdojo.mvc.tvshow.repositries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.tvshow.models.Show;

@Repository
public interface ShowRepo extends CrudRepository<Show, Long>{
	List<Show> findAll();
	


}

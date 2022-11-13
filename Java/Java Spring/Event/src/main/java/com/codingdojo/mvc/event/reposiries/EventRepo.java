package com.codingdojo.mvc.event.reposiries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.mvc.event.models.Event;

public interface EventRepo extends CrudRepository<Event, Long>{
	List<Event> findAll();
}

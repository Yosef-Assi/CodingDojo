package com.codingdojo.mvc.event.reposiries;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.mvc.event.models.Event;

public interface EventRepo extends CrudRepository<Event, Long>{
	List<Event> findAll();
	List<Event> findBylocation(String loc);
	@Query(value="select * from evnets order by avg_rate desc limit 10",nativeQuery = true)
	List<Event> TopRate();

}

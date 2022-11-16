package com.codingdojo.mvc.event.reposiries;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.event.models.event_rate;

@Repository
public interface RateRepo extends CrudRepository<event_rate, Long>{
	List<event_rate> findAll();
	
	@Query(value= "select AVG(rate) from events_rate where event_id = ?1" , nativeQuery = true)
	Double rate(Long id);
	
}

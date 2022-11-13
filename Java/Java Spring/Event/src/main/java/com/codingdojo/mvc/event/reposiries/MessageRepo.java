package com.codingdojo.mvc.event.reposiries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.event.models.Message;
@Repository
public interface MessageRepo extends CrudRepository<Message, Long> {
	List<Message> findAll();
}

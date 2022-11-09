package com.codingdojo.mvc.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.dojooverflow.models.Question;
import com.codingdojo.mvc.dojooverflow.models.Tag;

@Repository
public interface TagRepo extends CrudRepository<Tag, Long>{
	List<Tag> findAll();
	List<Tag> findAllByQuestions(Question question);
}

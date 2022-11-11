package com.codingdojo.mvc.projectmanager.repositries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.projectmanager.models.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long>{
	List<Task> findAll();
}

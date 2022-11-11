package com.codingdojo.mvc.projectmanager;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.codingdojo.mvc.projectmanager.models.Project;
import com.codingdojo.mvc.projectmanager.repositries.ProjectRepo;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

@SpringBootTest
class ProjectManagerApplicationTests {
	@Autowired
	private ProjectRepo repo;

	@Test
	void contextLoads() {
	}
	
	

}

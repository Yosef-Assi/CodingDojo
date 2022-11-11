package com.codingdojo.mvc.projectmanager.services;


import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.mvc.projectmanager.models.LoginUser;
import com.codingdojo.mvc.projectmanager.models.Project;
import com.codingdojo.mvc.projectmanager.models.Task;
import com.codingdojo.mvc.projectmanager.models.User;
import com.codingdojo.mvc.projectmanager.repositries.ProjectRepo;
import com.codingdojo.mvc.projectmanager.repositries.TaskRepo;
import com.codingdojo.mvc.projectmanager.repositries.UserRepository;



@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    TaskRepo taskRepo;
    
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
    	
    	Optional<User> opuser = userRepo.findByEmail(newUser.getEmail());
    	if(opuser.isPresent()) {
    		result.rejectValue("email", "Matches", "An account with that email already exists!");
    	}
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");

    	}
    	
    	if(result.hasErrors()) {
    		return null;
    	}
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return userRepo.save(newUser);
    	
    }
    public User login(LoginUser newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return user;
        }
    }
    public User findUser(Long id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		else {
			return null;
		}
	}
    
    public Project findProject(Long id) {
		Optional<Project> book = projectRepo.findById(id);
		if(book.isPresent()) {
			return book.get();
		}
		else {
			return null;
		}
    }
	
    public List<Project> findAll(){
		return projectRepo.findAll();
	}
	public Project createProject(Project project) {
		return projectRepo.save(project);
	}
	
	 public void deleteProject(Long id) {
	  	   Optional<Project> ex = projectRepo.findById(id);
	         if(ex.isPresent()) {
	        	 projectRepo.deleteById(id);
	         }
	  }
	 public List<Project> allP(Long id) {
		 return projectRepo.findAllByUserId(id);
	 }
//	 public List<Object[]> allpro(Long id) {
//		 return projectRepo.joinPojectsAndUsers(id);
//	 }
	 public List<Project> allos(User user) {
		 return projectRepo.findByusersNotContains(user);
	 }
	 public Task createTask(Task task) {
			return taskRepo.save(task);
		}
    
	 
	 public List<Task> findAllTask(){
			return taskRepo.findAll();
		}
}

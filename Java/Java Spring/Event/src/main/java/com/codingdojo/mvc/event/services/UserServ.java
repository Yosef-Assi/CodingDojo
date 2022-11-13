package com.codingdojo.mvc.event.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.mvc.event.models.LoginUser;
import com.codingdojo.mvc.event.models.User;
import com.codingdojo.mvc.event.reposiries.UserRepo;

@Service
public class UserServ {
	
	
	@Autowired
	UserRepo userRepo;
	
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
}

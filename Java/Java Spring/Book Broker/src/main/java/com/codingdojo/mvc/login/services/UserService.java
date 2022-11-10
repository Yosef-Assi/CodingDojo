package com.codingdojo.mvc.login.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.mvc.login.models.Book;
import com.codingdojo.mvc.login.models.LoginUser;
import com.codingdojo.mvc.login.models.User;
import com.codingdojo.mvc.login.repositories.BookRepo;
import com.codingdojo.mvc.login.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    @Autowired
    BookRepo bookRepo;
    
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
    public Book findBook(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		if(book.isPresent()) {
			return book.get();
		}
		else {
			return null;
		}
    }
	
    public List<Book> findAll(){
		return bookRepo.findAll();
	}
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	 public void deleteBook(Long id) {
	  	   Optional<Book> ex = bookRepo.findById(id);
	         if(ex.isPresent()) {
	        	 bookRepo.deleteById(id);
	         }
	  }
	 public void addBorrower(Book book, User user) {
			book.setBorrow(user);
			bookRepo.save(book);
		}
	 
	 public void deleteBorrower(Book book, User user) {
			book.setBorrow(null);
			bookRepo.save(book);
		}
	 
	 
	 public List<Book> bookBrrow(User user){
			return bookRepo.findAllByUser(user);
		}
	 public List<Book> unborrowedBooks(User user){
			return bookRepo.findByBorrow_idIsOrUser_idIs(null, user.getId());
		}
	 
	 public List<Book> bookBrrow2(User user){
			return bookRepo.findByBorrow_idIs(user.getId());
		}
	 
	 public List<Book> notBookBrrow(User user){
			return bookRepo.findByBorrow_idNotContains(user.getId());
		}
	 public List<Book> AllBookNoBorrow(User user){
			return bookRepo.AllBookNoBorrow(user.getId());
		}
	 
	 public List<Book> findByBorrowNull(){
		 return bookRepo.findByBorrowNull();
	 }
    
}

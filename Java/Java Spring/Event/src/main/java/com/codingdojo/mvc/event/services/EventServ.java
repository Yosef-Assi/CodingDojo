package com.codingdojo.mvc.event.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.event.models.Event;
import com.codingdojo.mvc.event.reposiries.EventRepo;

@Service
public class EventServ {

	@Autowired
	
	EventRepo eventrepo;
	
	
	 public Event findEvent(Long id) {
			Optional<Event> book = eventrepo.findById(id);
			if(book.isPresent()) {
				return book.get();
			}
			else {
				return null;
			}
	    }
		
	    public List<Event> findAll(){
			return eventrepo.findAll();
		}
		public Event createProject(Event event) {
			return eventrepo.save(event);
		}
		
		 public void deleteProject(Long id) {
		  	   Optional<Event> ex = eventrepo.findById(id);
		         if(ex.isPresent()) {
		        	 eventrepo.deleteById(id);
		         }
		  }
		    public List<Event> findByloc(String name){
				return eventrepo.findBylocation(name);
			}
		    
		    
		    
		    
		    
		    public List<Event> topRte(){
				return eventrepo.TopRate();
			}
		    
		    
		    
}

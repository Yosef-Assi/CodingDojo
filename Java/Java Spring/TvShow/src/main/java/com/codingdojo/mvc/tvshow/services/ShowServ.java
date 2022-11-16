package com.codingdojo.mvc.tvshow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.tvshow.models.Show;
import com.codingdojo.mvc.tvshow.repositries.ShowRepo;

@Service
public class ShowServ {

	@Autowired
	ShowRepo showRepo;
	
	
	 public Show findShow(Long id) {
			Optional<Show> book = showRepo.findById(id);
			if(book.isPresent()) {
				return book.get();
			}
			else {
				return null;
			}
	    }
		
	    public List<Show> findAll(){
			return showRepo.findAll();
		}
		public Show createShow(Show event) {
			return showRepo.save(event);
		}
		
		 public void deleteShow(Long id) {
		  	   Optional<Show> ex = showRepo.findById(id);
		         if(ex.isPresent()) {
		        	 showRepo.deleteById(id);
		         }
		  }
		  
}

package com.codingdojo.mvc.event.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.event.models.Message;
import com.codingdojo.mvc.event.reposiries.MessageRepo;

@Service
public class MessageServ {
	
	@Autowired
	MessageRepo messageRepo;
	 public Message findMessage(Long id) {
			Optional<Message> book = messageRepo.findById(id);
			if(book.isPresent()) {
				return book.get();
			}
			else {
				return null;
			}
	    }
		
	    public List<Message> findAll(){
			return messageRepo.findAll();
		}
		public Message createMessage(Message event) {
			return messageRepo.save(event);
		}
		
		 public void deleteMessage(Long id) {
		  	   Optional<Message> ex = messageRepo.findById(id);
		         if(ex.isPresent()) {
		        	 messageRepo.deleteById(id);
		         }
		  }
		

}

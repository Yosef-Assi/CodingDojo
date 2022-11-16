package com.codingdojo.mvc.event.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.event.models.event_rate;
import com.codingdojo.mvc.event.reposiries.RateRepo;

@Service
public class RateServ {
	@Autowired
	RateRepo rateRepo;
	 public event_rate findRate(Long id) {
			Optional<event_rate> rate = rateRepo.findById(id);
			if(rate.isPresent()) {
				return rate.get();
			}
			else {
				return null;
			}
	    }
		
	    public List<event_rate> findAll(){
			return rateRepo.findAll();
		}
		public event_rate createRate(event_rate rate) {
			return rateRepo.save(rate);
		}
		
		 public void deleteRate(Long id) {
		  	   Optional<event_rate> ex = rateRepo.findById(id);
		         if(ex.isPresent()) {
		        	 rateRepo.deleteById(id);
		         }
		  }
		 
		 public Double avgRate(Long id) {
			 return rateRepo.rate(id);
		 }
		
}

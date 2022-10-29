package com.codingdojo.daikichipathvariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiPathVariables {
	@RequestMapping("/daikichi/travel/{city}")
	public String print1(@PathVariable("city") String city) {
		return "Congratulations! You will soon travel to : "+city;
		
	}
	@RequestMapping("/daikichi/lotto/{number}")
	public String print2(@PathVariable("number") int number) {
		if(number%2 ==0) {
		return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
	}

}

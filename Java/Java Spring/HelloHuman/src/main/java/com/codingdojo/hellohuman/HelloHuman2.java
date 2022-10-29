package com.codingdojo.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHuman2 {

	@RequestMapping("/")
	public String home(@RequestParam(value="name" , required=false) String name,@RequestParam(value="last" , required=false) String last ,@RequestParam(value="times" , required=false) String time1) {
		if(name == null && last == null && time1 == null) {	
			return "Hello Human";
		}
		else if (last == null && time1==null) {
			return "Hello "+name;
		}
		else if (time1 == null) {
		return "Hello "+name + "  " + last;
		}
		else {
			String s1="";
			for(int i =1 ;i<=Integer.parseInt(time1);i++) {
				 s1 += "Hello "+name +" ";
			}
			return s1;
		}
	}
}

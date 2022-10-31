package com.codingdojo.displaydate;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class DisplayDate1Application {

	public static void main(String[] args) {
		SpringApplication.run(DisplayDate1Application.class, args);
	}
	@RequestMapping("/")
	public String index(Model model) {
		
		return "index.jsp";
	}
}




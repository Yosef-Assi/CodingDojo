package com.codingdojo.omikujform;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class main {
	@RequestMapping("/")
	public String home() {
		return "omikuji.jsp";
	}
	@RequestMapping(value="/send" , method=RequestMethod.POST)
	public String form1(@RequestParam(value="name") String name ,@RequestParam(value="city") String city,@RequestParam(value="person") String person,@RequestParam(value="hobby") String hobby,@RequestParam(value="liv") String liv,@RequestParam(value="some") String some,HttpSession session) {
		session.setAttribute("name", name);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("liv", liv);
		session.setAttribute("some", some);

		return "redirect:/dashboard";
	}
	@RequestMapping("/dashboard")
	public String form2() {
		return "index1.jsp";
	}
	
}

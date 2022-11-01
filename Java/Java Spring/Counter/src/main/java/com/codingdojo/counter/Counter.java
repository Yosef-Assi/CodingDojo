package com.codingdojo.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Counter {

	
	@RequestMapping("/")
	public String count1(HttpSession session,Model model) {
			model.addAttribute("count", session.getAttribute("count"));
			model.addAttribute("count1", session.getAttribute("count1"));
			  
			
		return "index.jsp";
	}
	@RequestMapping("/your_server")
	public String count(HttpSession session,Model model) {
		if(session.getAttribute("count")==null) {
			session.setAttribute("count",1);
			
		}
		else {
			Integer co = (Integer) session.getAttribute("count");
			co++;
			session.setAttribute("count",co);
			model.addAttribute("count", session.getAttribute("count"));
		}
		return "index2.jsp";
	}
	
	@RequestMapping("/your_server2")
	public String count2(HttpSession session,Model model) {
		if(session.getAttribute("count1")==null) {
			session.setAttribute("count1",2);
		}
		else {
			Integer co = (Integer) session.getAttribute("count1");
			co+=2;
			session.setAttribute("count1",co);
			model.addAttribute("count1", session.getAttribute("count1"));
		}
		return "index3.jsp";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/";
	}
}

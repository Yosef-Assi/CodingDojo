package com.codingdojo.ninjagold;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Gold {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.isNew()) {
			session.setAttribute("gold",0);
			session.setAttribute("log", new ArrayList<String>());
		}
		return "Gold.jsp";
	}
	
	@RequestMapping(value="/process" , method =RequestMethod.POST)
	public String index2(@RequestParam(value="hide") String hide ,HttpSession session,Model model) {
		System.out.println(hide);
		Random random = new Random();
		if(hide.equals("farm")) {
			Integer rand = random.nextInt(10) + 10;
			Integer gold = (Integer) session.getAttribute("gold");
			ArrayList<String> list1 = (ArrayList<String>) session.getAttribute("log");
			session.setAttribute("gold", gold+rand);
//			session.setAttribute("log",list);
			
			list1.add("You are earned " + rand +" from "+hide+" and Time Is :"+ new Date());
			System.out.println(list1);
	
		}
		else if(hide.equals("cave")) {
			Integer rand = random.nextInt(10) + 10;
			Integer gold = (Integer) session.getAttribute("gold");
			ArrayList<String> list1 = (ArrayList<String>) session.getAttribute("log");
			session.setAttribute("gold", gold+rand);
//			session.setAttribute("log",list);
			
			list1.add("You are earned " + rand +" from "+hide+" from "+hide+" and Time Is :"+ new Date());
			System.out.println(list1);
	
		}
		else if(hide.equals("house")) {
			Integer rand = random.nextInt(10) + 10;
			Integer gold = (Integer) session.getAttribute("gold");
			ArrayList<String> list1 = (ArrayList<String>) session.getAttribute("log");
			session.setAttribute("gold", gold+rand);
//			session.setAttribute("log",list);
			
			list1.add("You are earned " + rand +" from "+hide+" and Time Is :"+ new Date());
			System.out.println(list1);
	
		}
		else if(hide.equals("quest")) {
			Integer rand = random.nextInt(50+50)-50;
			Integer gold = (Integer) session.getAttribute("gold");
			ArrayList<String> list1 = (ArrayList<String>) session.getAttribute("log");
			session.setAttribute("gold", gold+rand);
//			session.setAttribute("log",list);
			if(rand >0) {
				list1.add("You are earned " + rand +" from "+hide+" and Time Is :"+ new Date());

			}
			else {
				list1.add("You are earned and lost  " + rand +" from "+hide+" and Time Is :"+ new Date());

			}
			System.out.println(list1);
	
		}
		return "redirect:/";
//
		
		
	}
	@RequestMapping("/main")
	public String index3() {
		return "Gold.jsp";
	}

}

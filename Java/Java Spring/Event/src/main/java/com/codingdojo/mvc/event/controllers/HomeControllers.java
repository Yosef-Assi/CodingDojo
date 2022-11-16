package com.codingdojo.mvc.event.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.event.models.Event;
import com.codingdojo.mvc.event.models.LoginUser;
import com.codingdojo.mvc.event.models.Message;
import com.codingdojo.mvc.event.models.User;
import com.codingdojo.mvc.event.models.event_rate;
import com.codingdojo.mvc.event.services.EventServ;
import com.codingdojo.mvc.event.services.MessageServ;
import com.codingdojo.mvc.event.services.RateServ;
import com.codingdojo.mvc.event.services.UserServ;

@Controller
public class HomeControllers {
	 @Autowired
     UserServ userServ;
	 @Autowired
	 EventServ eventServ;
	 @Autowired
	 MessageServ messageServ;
	 @Autowired
	 RateServ rateServ;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
    	userServ.register(newUser, result);
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "login.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
      
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
    
        return "redirect:/";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
         User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }
        session.setAttribute("user_id", user.getId());
        
    
        return "redirect:/dashboard";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    	
    }
    @GetMapping("/dashboard")
    public String home(Model model,HttpSession session) {
        model.addAttribute("user1",userServ.findUser((Long) session.getAttribute("user_id")));
        model.addAttribute("events",eventServ.findAll());
      
        model.addAttribute("top",eventServ.topRte());

    	return "dashboard.jsp";
    }
    
    
    
    @GetMapping("/event")
    public String addEvent(HttpSession session,@ModelAttribute("event") Event event,Model model) {
        model.addAttribute("newLogin", new Event());
        model.addAttribute("user",userServ.findUser((Long) session.getAttribute("user_id")));
    	return "createEvent.jsp";
    	
    }
    @PostMapping("/newevent")
    public String createEvent(@Valid @ModelAttribute("event") Event event ,BindingResult result ,Model model,HttpSession session) {
		User user = userServ.findUser((Long)session.getAttribute("user_id"));

        if (result.hasErrors()) {
            return "createEvent.jsp";
        } else {
        	
        	eventServ.createProject(event);
        	user.getEvents().add(event);
        	eventServ.createProject(event);
            return "redirect:/dashboard";
        }
    }
    
    @RequestMapping("/join/event/{id}")
    public String joinEvent(@PathVariable("id") Long id,HttpSession session) {
    		Event event = eventServ.findEvent(id);
    		User user = userServ.findUser((Long)session.getAttribute("user_id"));
    	
    		user.getEvents().add(event);
//   		System.out.println(user.getEvents().contains(event));
    		eventServ.createProject(event);

            return "redirect:/dashboard";
        
    }
    @RequestMapping("/leaveevent/{id}")
    public String leaveEvent(@PathVariable("id") Long id,HttpSession session) {
    		Event event = eventServ.findEvent(id);
    		User user = userServ.findUser((Long)session.getAttribute("user_id"));
    		user.getEvents().remove(event);
    		eventServ.createProject(event);

            return "redirect:/dashboard";
        
    }
    @RequestMapping("/delete/event/{id}")
    public String deleteEvent(@PathVariable("id") Long id,HttpSession session) {
    		Event event = eventServ.findEvent(id);
    		eventServ.deleteProject(event.getId());

            return "redirect:/dashboard";
        
    }
    @GetMapping("edit/event/{id}")
 	 public String editEvent(@PathVariable("id")Long id,Model model) {
 		 Event event = eventServ.findEvent(id);
 		 model.addAttribute("event", event);
 		 return "Editevent.jsp";
 	 }
     @PutMapping("edit/event/{id}")
 	 public String updateEvent(@Valid @ModelAttribute("event") Event event,BindingResult result,HttpSession session) {
 		   if (result.hasErrors()) {
 	            return "Editevent.jsp";
 	            }
 		   else {
 			 eventServ.createProject(event);
// 			 User user = userServ.findUser((Long)session.getAttribute("user_id"));
// 			user.getProjects().add(project);
//    		userServ.createProject(project);
    	
 			   return "redirect:/dashboard";
 		   }
 		 
 	 }
     @GetMapping("/show/event/{id}")
   	 public String showOneEvent(@PathVariable("id")Long id,Model model,HttpSession session,@ModelAttribute("message") Message message,@ModelAttribute("rate") event_rate rate) {
   		 Event event = eventServ.findEvent(id);
   		 model.addAttribute("events", event);
   		 model.addAttribute("event2", event);
   		 model.addAttribute("user", userServ.findUser((Long)session.getAttribute("user_id")));
   		 model.addAttribute("messages", messageServ.findAll());
   		 System.out.println(rateServ.avgRate(id));
    	 Double avgr=rateServ.avgRate(id);
    	 eventServ.findEvent(id).setAvgRate(avgr);
    	

    	 eventServ.createProject(event);
    	 System.out.println(eventServ.findEvent(id).getAvgRate());
    	 eventServ.createProject(event);
   		 return "showEvent.jsp";
   	 }
     @PostMapping("/new/message")
     public String createMessage(@Valid @ModelAttribute("message") Message message ,BindingResult result ,Model model,HttpSession session) {
         if (result.hasErrors()) {
             return "showEvent.jsp";
         } else {
        	 messageServ.createMessage(message);
             return "redirect:/dashboard";
         }
     }
     
     @PutMapping("/new/rate/{id}")
     public String addRate(@Valid @ModelAttribute("rate") event_rate rate ,BindingResult result ,Model model,HttpSession session,@PathVariable("id") Long id) {
         if (result.hasErrors()) {
             return "showEvent.jsp";
         } else {
        	 Event event = eventServ.findEvent(id);
        	 rateServ.createRate(rate);
        	 System.out.println(rateServ.avgRate(id));
        	 Double avgr=rateServ.avgRate(id);
        	 eventServ.findEvent(id).setAvgRate(avgr);
        	

        	 eventServ.createProject(event);
             return "redirect:/dashboard";
         }
     }
     
     
     @PostMapping("/search")
     public String search(@RequestParam("name") String location, Model model,HttpSession session) {
             return "redirect:/search/"+location; 
     }
     
     @GetMapping("/search/{loc}")
   	 public String searchevent(@PathVariable("loc")String loc,Model model,HttpSession session) {
    	 model.addAttribute("event2", eventServ.findByloc(loc));
   		 return "showEvent2.jsp";
   	 }
    
}

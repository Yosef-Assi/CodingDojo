package com.codingdojo.mvc.tvshow.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.mvc.tvshow.models.LoginUser;
import com.codingdojo.mvc.tvshow.models.Show;
import com.codingdojo.mvc.tvshow.models.User;
import com.codingdojo.mvc.tvshow.services.ShowServ;
import com.codingdojo.mvc.tvshow.services.UserService;



@Controller
public class HomeController {
    
    // Add once service is implemented:
	 @Autowired
     UserService userServ;
	 @Autowired
     ShowServ showServ;
    
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
    ///////////////////////////////////////////////////////////////////////////////
    
    @GetMapping("/dashboard")
    public String home(Model model,HttpSession session) {
    	model.addAttribute("shows", showServ.findAll());
    	model.addAttribute("user", userServ.findUser((Long) session.getAttribute("user_id")));

    	return "dashboard.jsp";
    }
    
    @GetMapping("/show")
    public String addEvent(HttpSession session,@ModelAttribute("show") Show event,Model model) {
        model.addAttribute("newLogin", new Show());
        model.addAttribute("user",userServ.findUser((Long) session.getAttribute("user_id")));
    	return "createShow.jsp";
    	
    }
    @PostMapping("/newshow")
    public String createEvent(@Valid @ModelAttribute("event") Show event ,BindingResult result ,Model model,HttpSession session) {
		User user = userServ.findUser((Long)session.getAttribute("user_id"));

        if (result.hasErrors()) {
            return "createShow.jsp";
        } else {
        	
        	showServ.createShow(event);

            return "redirect:/dashboard";
        }
    }
    
    
    
    
}

package com.codingdojo.mvc.projectmanager.controlleas;

import java.util.List;

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

import com.codingdojo.mvc.projectmanager.models.LoginUser;
import com.codingdojo.mvc.projectmanager.models.Project;
import com.codingdojo.mvc.projectmanager.models.Task;
import com.codingdojo.mvc.projectmanager.models.User;
import com.codingdojo.mvc.projectmanager.services.UserService;



@Controller
public class HomeController {
    
    // Add once service is implemented:
	 @Autowired
     UserService userServ;
    
    
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
    	List<Project> projects = userServ.findAll();
    	model.addAttribute("projects", projects);
    	User user = userServ.findUser((Long) session.getAttribute("user_id"));
    	List<Project> projects2 = userServ.allos(user);
    	
    	model.addAttribute("projects2", projects2);

    	model.addAttribute("user", user);
    	return "dashboard.jsp";
    }
    
    @GetMapping("/project")
    public String addProject(HttpSession session,@ModelAttribute("project") Project project,Model model) {
        model.addAttribute("newLogin", new Project());
        model.addAttribute("user",userServ.findUser((Long) session.getAttribute("user_id")));
    	return "createProject.jsp";
    	
    }
    @PostMapping("/newproject")
    public String createProject(@Valid @ModelAttribute("project") Project project ,BindingResult result ,Model model,HttpSession session) {
        if (result.hasErrors()) {
            return "createProject.jsp";
        } else {
        	
         	userServ.createProject(project);
    		User user = userServ.findUser((Long)session.getAttribute("user_id"));
         	user.getProjects().add(project);
    		userServ.createProject(project);
            return "redirect:/dashboard";
        }
    }
    
    @RequestMapping("/jointeam/{projectId}")
    public String joinTeam(@PathVariable("projectId") Long projectId,HttpSession session) {
    		Project project = userServ.findProject(projectId);
    		User user = userServ.findUser((Long)session.getAttribute("user_id"));
    		user.getProjects().add(project);
    		userServ.createProject(project);

            return "redirect:/dashboard";
        
    }
    
    @RequestMapping("/LeaveTeam/{id}")
    public String leaveteam(@PathVariable("id") Long projectId,HttpSession session) {
    		Project project = userServ.findProject(projectId);
    		User user = userServ.findUser((Long)session.getAttribute("user_id"));
    		user.getProjects().remove(project);
    		userServ.createProject(project);

            return "redirect:/dashboard";
        
    }
    
    @GetMapping("edit/project/{projectId}")
  	 public String edit(@PathVariable("projectId")Long id,Model model) {
  		 Project project = userServ.findProject(id);
  		 model.addAttribute("project", project);
  		 return "Editproject.jsp";
  	 }
      @PutMapping("edit/project/{id}")
  	 public String update(@Valid @ModelAttribute("project") Project project,BindingResult result,HttpSession session) {
  		   if (result.hasErrors()) {
  	            return "Editproject.jsp";
  	            }
  		   else {
  			 userServ.createProject(project);
  			 User user = userServ.findUser((Long)session.getAttribute("user_id"));
  			user.getProjects().add(project);
     		userServ.createProject(project);
     	
  			   return "redirect:/dashboard";
  		   }
  		 
  	 }
     @GetMapping("/getproject/{id}")
   	 public String show(@PathVariable("id")Long id,Model model) {
   		 Project project = userServ.findProject(id);
   		 model.addAttribute("project", project);
   		 return "show.jsp";
   	 }
     
     
     @GetMapping("/gettask/{id}")
     public String addtask(HttpSession session,@ModelAttribute("task") Task task,Model model,@PathVariable("id") Long id) {
    
         model.addAttribute("user",userServ.findUser((Long) session.getAttribute("user_id")));
         model.addAttribute("project",userServ.findProject(id));
         model.addAttribute("Tasks",userServ.findAllTask());


     	return "createtask.jsp";
     	
     }
     @PostMapping("/newtask")
     public String createtask(@Valid @ModelAttribute("task") Task task ,BindingResult result ,Model model,HttpSession session) {
         if (result.hasErrors()) {
             return "createtask.jsp";
         } else {
          	userServ.createTask(task);
             return "redirect:/dashboard";
         }
     }
     
     
     
     @GetMapping("/showproject/{id}")
   	 public String showP(@PathVariable("id")Long id,Model model) {
   		 Project project = userServ.findProject(id);
   		 model.addAttribute("project", project);
   		 return "showproject.jsp";
   	 }
    
    
    
    
}

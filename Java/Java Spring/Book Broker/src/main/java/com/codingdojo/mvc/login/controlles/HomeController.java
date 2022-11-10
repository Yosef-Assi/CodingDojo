package com.codingdojo.mvc.login.controlles;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.login.models.Book;
import com.codingdojo.mvc.login.models.LoginUser;
import com.codingdojo.mvc.login.models.User;
import com.codingdojo.mvc.login.services.UserService;

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
    @GetMapping("/welcome")
    public String welcome(Model model,HttpSession session) {
    	if (session.getAttribute("user_id") != null) {
    	User user = userServ.findUser((Long) session.getAttribute("user_id"));
    	List<Book> bk = userServ.bookBrrow2(user);
//    	System.out.println(bk);
    	List<Book> bk2 = userServ.unborrowedBooks(user);
//    	List<Book> ss = userServ.AllBookNoBorrow(user);
    	List<Book> Nulls = userServ.findByBorrowNull();

//    	System.out.println(ss.get(0).getTitle());
        model.addAttribute("newUser", user);
        model.addAttribute("bk", bk);
        model.addAttribute("bk2", bk2);
        model.addAttribute("booknoborrow", Nulls);

        System.out.println(Nulls);
    	model.addAttribute("allbook", userServ.findAll());

        return "home.jsp";
    	}
    	else {
    		return "redirect:/";
    	}
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
        
    
        return "redirect:/welcome";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    	
    }
    @GetMapping("/book")
    public String addbook(HttpSession session,@ModelAttribute("book") Book book,Model model) {
        model.addAttribute("newLogin", new Book());
//    	User user = userServ.findUser((Long) session.getAttribute("user_id"));
        model.addAttribute("user",userServ.findUser((Long) session.getAttribute("user_id")));
    	return "createbook.jsp";
    	
    }
    @PostMapping("/newbook")
    public String createBook(@Valid @ModelAttribute("book") Book book ,BindingResult result ,Model model,HttpSession session) {
        if (result.hasErrors()) {
            return "createbook.jsp";
        } else {
        
         	userServ.createBook(book);
            return "redirect:/welcome";
        }
    }
    @RequestMapping("/getbook/{id}")
    public String allbooks(@PathVariable("id") Long id,Model model) {
    	
    	model.addAttribute("allbook", userServ.findBook(id));
    	System.out.println(userServ.findBook(id));
    	return "showbook.jsp";
    }
    
    @GetMapping("edit/getbook/{id}")
	 public String edit(@PathVariable("id")Long id,Model model) {
		 Book book = userServ.findBook(id);
		 model.addAttribute("book", book);
		 return "Editbook.jsp";
	 }
    @PutMapping("edit/getbook/{id}")
	 public String update(@Valid @ModelAttribute("book") Book book,BindingResult result) {
		   if (result.hasErrors()) {
	            return "Editbook.jsp";
	            }
		   else {
			   userServ.createBook(book);
			   return "redirect:/welcome";
		   }
		 
	 }
    @DeleteMapping("/delete/{id}")
	 public String delete(@PathVariable("id") Long id) {
    	userServ.deleteBook(id);
	return "redirect:/welcome";
	 }
//    @GetMapping("/addborrow/{id}")
//    public String BookBorrow(Model model,HttpSession session,@PathVariable("id") Long id) {
//            return "redirect:/welcome";
//        
//    }
    @RequestMapping("/addborrow/{bookId}")
    public String createBookBorrow(@PathVariable("bookId") Long bookId,HttpSession session) {
    		Book book = userServ.findBook(bookId);
    		User user = userServ.findUser((Long)session.getAttribute("user_id"));
//    		user.getBook().add(book);
//    		userServ.createBook(book);
    		userServ.addBorrower(book, user);
            return "redirect:/welcome";
        
    }
    
    @RequestMapping("/Removeborrow/{bookId}")
    public String removeBookBorrow(@PathVariable("bookId") Long bookId,HttpSession session) {
    		Book book = userServ.findBook(bookId);
    		User user = userServ.findUser((Long)session.getAttribute("user_id"));
//    		user.getBook().add(book);
//    		userServ.createBook(book);
    		userServ.deleteBorrower(book, user);
            return "redirect:/welcome";
        
    }
    
    
    
    
}

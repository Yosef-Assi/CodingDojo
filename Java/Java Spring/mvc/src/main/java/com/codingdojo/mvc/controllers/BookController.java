package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.servcies.BookService;

@Controller
public class BookController {
//
//	@Autowired
//	BookService bookServices;
    private final BookService bookService;
    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @RequestMapping("/")
    public String index0() {
    	return "redirect:/books";
    }
    
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "Show.jsp";
    }
	@RequestMapping("/books/{id}")
	public String index(Model model, @PathVariable("id") Long id) {
		
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "index.jsp";
		
	}
	

	
	
}

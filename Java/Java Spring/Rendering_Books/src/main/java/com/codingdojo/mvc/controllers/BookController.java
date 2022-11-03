package com.codingdojo.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.servcies.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookServices;
	
	@RequestMapping("/books/{id}")
	public String index(Model model, @PathVariable("id") Long id) {
		
		Book book = bookServices.findBook(id);
		model.addAttribute("book", book);
		return "Show.jsp";
		
	}
	
	
}

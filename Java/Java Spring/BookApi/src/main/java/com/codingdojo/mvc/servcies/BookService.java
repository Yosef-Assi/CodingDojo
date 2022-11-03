package com.codingdojo.mvc.servcies;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
		
	}
    public List<Book> allBooks() { 
        return bookRepository.findAll();
    }
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book book = findBook(id);
		if(book.getId()== id) {
			book.setTitle(title);
			book.setDescription(desc);
			book.setLanguage(lang);
			book.setNumberOfPages(numOfPages);
			return createBook(book);
		}else {
			return null;
		}
	}
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    public void deleteBook(Long id) {
    	   Optional<Book> optionalBook = bookRepository.findById(id);
           if(optionalBook.isPresent()) {
        	   bookRepository.deleteById(id);
           }
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}

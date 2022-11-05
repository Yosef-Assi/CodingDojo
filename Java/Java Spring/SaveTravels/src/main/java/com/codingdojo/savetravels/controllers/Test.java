package com.codingdojo.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.servcies.ExpenseService;

@Controller
public class Test {

	private final ExpenseService expenseservice;
	public Test(ExpenseService expenseservice) {
		this.expenseservice=expenseservice;
	}
	@GetMapping("/")
	public String index() {

		return "redirect:/show";
	}
	
	@GetMapping("/show")
	public String expense(@ModelAttribute("expense")Expense expense,Model model) {
		List<Expense> exlist = expenseservice.allExpense();
		model.addAttribute("ex", exlist);
		return "index.jsp";
	}
	 @PostMapping("/go")
	    public String create(@Valid @ModelAttribute("expense") Expense expense ,BindingResult result ,Model model) {
	        if (result.hasErrors()) {
	        	List<Expense> exlist = expenseservice.allExpense();
	    		model.addAttribute("ex", exlist);
	            return "index.jsp";
	        } else {
	        	expenseservice.createExpense(expense);
	            return "redirect:/show";
	        }
	    }
	 @GetMapping("/ex/{id}")
	 public String edit(@PathVariable("id")Long id,Model model) {
		 Expense expense = expenseservice.findExpense(id);
		 model.addAttribute("expense", expense);
		 return "Show.jsp";
	 }
	 
	 @PutMapping("/edit/{id}")
	 public String update(@Valid @ModelAttribute("expense") Expense expense,BindingResult result) {
		   if (result.hasErrors()) {
	            return "Show.jsp";
	            }
		   else {
			   expenseservice.updateExpense(expense);
			   return "redirect:/";
		   }
		 
	 }
	 @DeleteMapping("/delete/{id}")
	 public String delete(@PathVariable("id") Long id) {
		 expenseservice.deleteExpense(id);
		 return "redirect:/";
	 }
	 @GetMapping("/exp/{id}")
	 public String showSingle(@PathVariable("id")Long id,Model model) {
		 Expense expense = expenseservice.findExpense(id);
		 model.addAttribute("expense", expense);
		 return "single_expense.jsp";
	 }
}

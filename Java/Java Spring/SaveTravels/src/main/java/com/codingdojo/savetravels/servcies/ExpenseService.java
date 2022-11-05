package com.codingdojo.savetravels.servcies;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenserepository;
	public ExpenseService(ExpenseRepository expenserepository) {
		this.expenserepository=expenserepository;
	}
	
	public List<Expense> allExpense(){
		return expenserepository.findAll();
	}
	
	public Expense createExpense(Expense e) {
		return expenserepository.save(e);
	}
	public Expense findExpense(Long id) {
		Optional<Expense> ex = expenserepository.findById(id);
		if(ex.isPresent()) {
			return ex.get();
		}
		else {
			return null;
		}
//		return expenserepository.findById(id);
	}
	public Expense updateExpense(Expense e) {
	return expenserepository.save(e);
	}
	 public void deleteExpense(Long id) {
  	   Optional<Expense> ex = expenserepository.findById(id);
         if(ex.isPresent()) {
        	 expenserepository.deleteById(id);
         }
  }
	
}


package com.codingdojo.mvc.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.productsandcategories.models.Categorie;
import com.codingdojo.mvc.productsandcategories.models.Product;
import com.codingdojo.mvc.productsandcategories.services.Services;

@Controller
public class Test {
	
private final Services dojoservice;

	public Test (Services dojoservice) {
		this.dojoservice=dojoservice;
	}
	
	@GetMapping("/")
	public String home() {
		return "redirect:/home";
	}
	@GetMapping("/home")
	public String index(Model model) {
			model.addAttribute("product",dojoservice.findAll());
			model.addAttribute("cat",dojoservice.findNinja());

			return "Home.jsp";
	}
	@GetMapping("/products")
	public String addproduct(@ModelAttribute ("product") Product product,Model model) {
			return "newproduct.jsp";
	}
	@PostMapping("/add")
    public String create(@Valid @ModelAttribute("product") Product product ,BindingResult result ,Model model) {
        if (result.hasErrors()) {
            return "newproduct.jsp";
        } else {
        	dojoservice.createLookify(product);
            return "redirect:/products";
        }
    }
	@GetMapping("/cat")
	public String addcat(@ModelAttribute ("categorie") Categorie categorie,Model model) {
			return "newcat.jsp";
	}
	@PostMapping("/addcat")
    public String create(@Valid @ModelAttribute("categorie") Categorie categorie ,BindingResult result ,Model model) {
        if (result.hasErrors()) {
            return "newcat.jsp";
        } else {
        	dojoservice.createNinja(categorie);
            return "redirect:/cat";
        }
    }
	 @GetMapping("/product/{productId}")
	    public String show2(@PathVariable("productId") Long id,Model model){
	    	model.addAttribute("show",dojoservice.findLookify(id));
	    	 Product product = dojoservice.findLookify(id);
	    	model.addAttribute("allcat",dojoservice.allproductbycat(product));
	        
	    	model.addAttribute("procat",dojoservice.proCat(product));
	    	

	    	
	    	return "showproduct.jsp";
	    }
	 @PostMapping("/product/{id}")
	    public String createnew(@PathVariable("id") Long id, @RequestParam(value="categoryId") Long catId,  Model model) {
	        Product product = dojoservice.findLookify(id);
	        Categorie category = dojoservice.findCat(catId);
	    	product.getCategories().add(category);
	    	dojoservice.updateProduct(product);
	    	Long ids=id;
	        return "redirect:/product/"+ids;   
		}
	 
	 
	 /////////////////////product//////////////////
	 
	 
	 @GetMapping("/cat/{catid}")
	    public String showcat(@PathVariable("catid") Long id,Model model){
	    	model.addAttribute("show",dojoservice.findCat(id));
	        Categorie category = dojoservice.findCat(id);

	    	model.addAttribute("allprodu",dojoservice.ProductNitcontains(category));
	    	model.addAttribute("procat",dojoservice.catPro(category));
	    	return "showcat.jsp";
	    }
	 @PostMapping("/cat/{id}")
	    public String createprod(@PathVariable("id") Long id, @RequestParam(value="productid") Long catId,  Model model) {
	        Product product = dojoservice.findLookify(catId);
	        Categorie category = dojoservice.findCat(id);
	    	category.getProducts().add(product);
	    	dojoservice.updateCat(category);
	    	Long ids=id;
	        return "redirect:/cat/"+ids;   
		}
	   
}

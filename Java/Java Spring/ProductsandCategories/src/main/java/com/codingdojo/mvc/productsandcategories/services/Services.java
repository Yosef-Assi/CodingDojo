package com.codingdojo.mvc.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.productsandcategories.models.Categorie;
import com.codingdojo.mvc.productsandcategories.models.Product;
import com.codingdojo.mvc.productsandcategories.repositories.CategoryRepo;
import com.codingdojo.mvc.productsandcategories.repositories.ProductRepo;


@Service
public class Services {
	
	private final CategoryRepo categoryRepo;
	private final ProductRepo productRepo;
	
	public Services (CategoryRepo categoryRepo,ProductRepo productRepo) {
		
		this.categoryRepo=categoryRepo;
		this.productRepo=productRepo;
	}
	public List<Product> findAll(){
		return productRepo.findAll();
	}
	public Product createLookify(Product lang) {
		return productRepo.save(lang);
	}
	
	public Product findLookify(Long id) {
		Optional<Product> lookify = productRepo.findById(id);
		if(lookify.isPresent()) {
			return lookify.get();
		}
		else {
			return null;
		}
	}
	public Categorie createNinja(Categorie ninj) {
		return categoryRepo.save(ninj);
	}
	public List<Categorie> findNinja(){
		return categoryRepo.findAll();
	}
	public Categorie findCat(Long id) {
		Optional<Categorie> lookify1 = categoryRepo.findById(id);
		if(lookify1.isPresent()) {
			return lookify1.get();
		}
		else {
			return null;
		}
	}
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
	public Categorie updateCat(Categorie product) {
		return categoryRepo.save(product);
	}
	
//	public List<CategoryProduct> proCat(Long id){
//		return productRepo.proCat(id);
//	}
	public List<Categorie> proCat(Product product){
		return categoryRepo.findAllByProducts(product);
	}
	
	public List<Product> catPro(Categorie cat){
		return productRepo.findAllByCategories(cat);
	}
	
}

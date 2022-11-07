package com.codingdojo.mvc.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.productsandcategories.models.Categorie;
import com.codingdojo.mvc.productsandcategories.models.Product;

@Repository
public interface CategoryRepo extends CrudRepository<Categorie, Long> {
	List<Categorie> findAll();
	List<Categorie> findAllByProducts(Product product);
}

package com.codingdojo.mvc.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.productsandcategories.models.Categorie;
import com.codingdojo.mvc.productsandcategories.models.CategoryProduct;
import com.codingdojo.mvc.productsandcategories.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
	List<Product> findAll();
	List<Product> findAllByCategories(Categorie cat);
	@Query(value="select categories_products.id,categories.name from products  join categories_products on products.id= categories_products.product_id join categories on categories_products.category_id=categories.id where products.id=?1",nativeQuery = true)
	List<CategoryProduct> proCat(Long id);
	
	List<Product> findByCategoriesNotContains(Categorie cat);


}

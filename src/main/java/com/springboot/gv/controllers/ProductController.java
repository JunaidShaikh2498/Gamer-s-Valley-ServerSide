package com.springboot.gv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Category;
import com.springboot.gv.entities.Product;
import com.springboot.gv.services.CategoryService;
import com.springboot.gv.services.ProductService;

@RestController

public class ProductController {
	
	@Autowired
	ProductService ps;
	
	@Autowired
	CategoryService cs;
	
	@GetMapping("/")
	public List<Product> getAllProductList(){
		return ps.getAllProducts();
	}
	@GetMapping("/home/{cname}")
	public ResponseEntity<List<Product>> getByCategory(@PathVariable("cname") String cname){
		Category cat = cs.getCategoryByName(cname);
		
		if(cat==null) {
			 return ResponseEntity.notFound().build();
		}
		 List<Product> products = ps.getByCategory(cat);
		 
		 return ResponseEntity.ok(products);
	}
	
	public List<Product> getByLesserPrice(double price){
		return ps.getByPriceLessThan(price);
	}
	
	public List<Product> getByGreaterPrice(double price){
		return ps.getByPriceGreaterThan(price);
	}
}

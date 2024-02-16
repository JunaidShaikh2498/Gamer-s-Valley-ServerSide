package com.springboot.gv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Category;
import com.springboot.gv.entities.InsertProduct;
import com.springboot.gv.entities.Product;
import com.springboot.gv.services.CategoryService;
import com.springboot.gv.services.ProductService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	@Autowired
	CategoryService cs;
	
	@GetMapping("/")
	public List<Product> getAllProductList(){
		return ps.getAllProducts();
	}
	@GetMapping("/products/{cname}")
	public ResponseEntity<List<Product>> getByCategory(@PathVariable("cname") String cname){
		Category cat = cs.getCategoryByName(cname);
		
		if(cat==null) {
			 return ResponseEntity.notFound().build();
		}
		 List<Product> products = ps.getByCategory(cat);
		 
		 return ResponseEntity.ok(products);
	}
	
	@GetMapping("/home/{cname}")
	public ResponseEntity<List<Product>> getByCategoryName(@PathVariable("cname") String cname){
		Category cat = cs.getCategoryByName(cname);
		
		if(cat==null) {
			 return ResponseEntity.notFound().build();
		}
		 List<Product> products = ps.getByCategory(cat);
		 
		 return ResponseEntity.ok(products);
	}
	
	@GetMapping("/productlistltp")
	public List<Product> getByLesserPrice(double price){
		return ps.getByPriceLessThan(price);
	}
	@GetMapping("/productlistgtp")
	public List<Product> getByGreaterPrice(double price){
		return ps.getByPriceGreaterThan(price);
	}
	
	@PostMapping("addProduct/{cid}")
	public Product addProd(@PathVariable("cid") int cid, @RequestBody InsertProduct ip) {
		Category cat = cs.getByCategoryId(cid);
		System.out.println(cat);
		Product prod = new Product(ip.getProductName(), ip.getProductDescription(), ip.getProductPrice(), cat);
		
		return ps.addProduct(prod);
	}
}

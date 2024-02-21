package com.springboot.gv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.Category;
import com.springboot.gv.entities.InsertProduct;
import com.springboot.gv.entities.Product;
import com.springboot.gv.repositories.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo pr;
	
	
	public List<Product> getAllProducts(){
		return pr.findAll();
	}
	
	public List<Product> getByCategory(Category cat){
		return pr.findByCategory(cat);
	}
	
	public List<Product> getByPriceLessThan(double price){
		return pr.findByProductPriceLessThan(price);
	}
	
	public List<Product> getByPriceGreaterThan(double price){
		return pr.findByProductPriceGreaterThan(price);
	}
	public Product addProduct(Product p) {
		return pr.save(p);
	}
	public int updateProdPrice(double price,int pid) {
		return pr.updatePrice(price, pid);
	}
}

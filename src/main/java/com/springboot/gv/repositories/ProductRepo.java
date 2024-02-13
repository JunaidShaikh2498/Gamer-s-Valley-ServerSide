package com.springboot.gv.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gv.entities.Category;
import com.springboot.gv.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	public List<Product> findByCategory(Category category);
	
	public List<Product> findByProductPriceLessThan(double price);
	
	public List<Product> findByProductPriceGreaterThan(double price);
}

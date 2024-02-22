package com.springboot.gv.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.gv.entities.Category;
import com.springboot.gv.entities.Product;

@Repository
@Transactional
public interface ProductRepo extends JpaRepository<Product, Integer> {

	public List<Product> findByCategory(Category category);
	
	public List<Product> findByProductPriceLessThan(double price);
	
	public List<Product> findByProductPriceGreaterThan(double price);
	
	
	
	@Modifying
	@Query(value="update products set product_price =:price where product_id =:pid",nativeQuery = true)
	public int updatePrice(double price,int pid);
}

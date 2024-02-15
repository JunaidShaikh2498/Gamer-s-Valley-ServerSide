package com.springboot.gv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.Category;
import com.springboot.gv.repositories.CategoryRepo;



@Service
public class CategoryService {
	
	@Autowired
	CategoryRepo cr;
	
	public List<Category> getCategories(){
		return cr.findAll();
	}
	
	public Category getCategoryByName(String name) {
		return cr.findByCategoryName(name);
	}
	
	public Category saveCategory(Category cat) {
		return cr.save(cat); 
	}
	
	public Category getByCategoryId(int catId) {
		Category c = null;
		Optional<Category> oc = cr.findById(catId);
		try {
			c=oc.get();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}


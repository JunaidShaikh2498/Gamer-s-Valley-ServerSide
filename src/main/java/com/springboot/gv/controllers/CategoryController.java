package com.springboot.gv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Category;
import com.springboot.gv.services.CategoryService;

@RestController


public class CategoryController {
	
	@Autowired
	CategoryService cs;
	
	@GetMapping("/home")
	public List<Category> getAllCategories(){
		return cs.getCategories();
	}
}

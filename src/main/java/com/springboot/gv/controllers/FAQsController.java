package com.springboot.gv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Category;
import com.springboot.gv.entities.Customer;
import com.springboot.gv.entities.FAQ;
import com.springboot.gv.entities.InsertFAQ;
import com.springboot.gv.services.CategoryService;
import com.springboot.gv.services.CustomerService;
import com.springboot.gv.services.FAQsService;

@RestController
@CrossOrigin("http://localhost:3000")
public class FAQsController {
	
	@Autowired
	FAQsService fs;
	
	@Autowired
	CategoryService cs;
	
	
	
	@GetMapping("/faq_list/{categoryId}")
	public List<FAQ> getFAQs(@PathVariable ("categoryId") int cid){
		Category cat = cs.getByCategoryId(cid);
		
		return fs.getFAQsByCategory(cat);
	}
	
	@PostMapping("/addfaq")
	public FAQ addQuestion(@RequestBody InsertFAQ ifq) {
		Category cat = cs.getByCategoryId(ifq.getCategoryId());
		FAQ fq = new FAQ(ifq.getQuestion(), ifq.getAnswer(), cat);
		return fq;
	}
}

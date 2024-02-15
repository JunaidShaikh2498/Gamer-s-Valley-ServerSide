package com.springboot.gv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Category;
import com.springboot.gv.entities.Expert;
import com.springboot.gv.services.CategoryService;
import com.springboot.gv.services.ExpertService;
import com.springboot.gv.services.RegisteredService;

@RestController
@CrossOrigin("http://localhost:3000")
public class AdminController {
	
	@Autowired
	ExpertService er;
	
	@Autowired
	CategoryService cs;
	
	@Autowired
	RegisteredService rs;
	
	@GetMapping("/expertlist")
	public List<Expert> getExpertList(){
		return er.getExperts();
	}
	
	@PutMapping("/approve/{regid}")
	public boolean approveExpert(@PathVariable ("regid") int regid) {
		boolean approved=false;
		if(rs.approveExpert(regid)==1) {
			approved=true;
		}
		return approved;
	}
	
	@PutMapping("/revoke/{regid}")
	public boolean revokeExpert(@PathVariable ("regid") int regid) {
		boolean revoked=false;
		if(rs.revokeExpert(regid)==0) {
			revoked=true;
		}
		return revoked;
	}
	
	@PostMapping("/add-category")
	public Category addCategory(Category c) {
		return cs.saveCategory(c);
	}
}

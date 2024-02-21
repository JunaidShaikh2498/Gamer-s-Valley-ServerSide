package com.springboot.gv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Category;
import com.springboot.gv.entities.Expert;
import com.springboot.gv.entities.InsertCategory;
import com.springboot.gv.entities.InsertProduct;
import com.springboot.gv.entities.Product;
import com.springboot.gv.entities.RegisteredUser;
import com.springboot.gv.services.CategoryService;
import com.springboot.gv.services.ExpertService;
import com.springboot.gv.services.RegisteredService;

@RestController
@CrossOrigin("http://localhost:3000")
public class AdminController {
	
	@Autowired
	JavaMailSender sender;
	
	@Autowired
	ExpertService es;
	
	@Autowired
	CategoryService cs;
	
	@Autowired
	RegisteredService rs;
	
	@GetMapping("/expertlist")
	public List<Expert> getExpertList(){
		return es.getAuthorizedExperts();
	}
	
	@PutMapping("/approve/{regid}")
	public boolean approveExpert(@PathVariable ("regid") int regid) {
		RegisteredUser ru = rs.findByRegId(regid);
		boolean approved=false;
		try {
			if(rs.approveExpert(regid)==1) {
				approved=true;
				Expert e = es.getExpertByRid(ru);
				SimpleMailMessage mailMsg = new SimpleMailMessage();
				mailMsg.setFrom("hrishi3bhogade@gmail.com");
				mailMsg.setSubject("Admin's Approval Granted");
		        mailMsg.setText("Congratulations "+e.getFirstname()+". You have given access as an Expert. You can now login and enjoy your Expert's experience. Thank you!!!");
		        sender.send(mailMsg);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return approved;
	}
	
	@PutMapping("/revoke/{regid}")
	public boolean revokeExpert(@PathVariable ("regid") int regid) {
		RegisteredUser ru = rs.findByRegId(regid);
		boolean revoked=false;
		try {
			if(rs.approveExpert(regid)==1) {
				revoked=true;
				Expert e = es.getExpertByRid(ru);
				SimpleMailMessage mailMsg = new SimpleMailMessage();
				mailMsg.setFrom("hrishi3bhogade@gmail.com");
				mailMsg.setSubject("Admin's Approval Revoked");
		        mailMsg.setText("Dear "+e.getFirstname()+", We regret to inform you that certain permissions on our website have been revoked. For details, contact us.");
		        sender.send(mailMsg);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return revoked;
	}
	
	@PostMapping("/add-category")
	public Category addCategory(@RequestBody InsertCategory ic) {
		Category c= new Category(ic.getCategoryName(), ic.getCategoryDescription());
		return cs.saveCategory(c);
	}
	
	
}

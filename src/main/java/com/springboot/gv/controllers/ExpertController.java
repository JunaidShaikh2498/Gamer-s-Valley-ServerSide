package com.springboot.gv.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Expert;
import com.springboot.gv.entities.RegisteredUser;
import com.springboot.gv.entities.UpdateExp;
import com.springboot.gv.services.ExpertService;
import com.springboot.gv.services.RegisteredService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ExpertController {
	
	@Autowired
	ExpertService es;
	
	@Autowired
	RegisteredService rs;
	
	@PutMapping("update/{expertid}")
	public boolean upExp(@PathVariable("expertid") int expId, @RequestBody UpdateExp ue) {
		boolean flag = false;
		Expert e = es.findByExpId(expId);
		int reg = e.getRegistered().getRegistration_id();
		rs.updateRuser(ue.getUsername(), ue.getPassword(), reg);
		 
		int res = es.updateExp(ue.getFirstname(), ue.getLastname(), ue.getEmail(), ue.getQualification(),reg);
		if(res==1) {
			flag = true;
		}
		return flag;
	}
	@GetMapping("/expert_list")
	public List<Expert> getExperts(){
		return es.getAuthorizedExperts();
	}
}

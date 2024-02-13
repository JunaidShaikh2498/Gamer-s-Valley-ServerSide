package com.springboot.gv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.LoginChecker;
import com.springboot.gv.entities.RegisteredUser;
import com.springboot.gv.services.RegisteredService;

@RestController
@CrossOrigin("http://localhost:3000")
public class LoginController {

	@Autowired
	RegisteredService rs;
	
	@PostMapping("/login")
	public int LoginUserRole(@RequestBody LoginChecker lc) {
		int role=-1;
		RegisteredUser ru = rs.findByUname(lc.getUsername());
		if(ru==null) {
			return role=-1;
		}
		
		if(ru.getUsername().equals(lc.getUsername())  && ru.getPassword().equals(lc.getPassword())&&(ru.getApproved()==1)) {
			role = ru.getRole_id();
			System.out.println(role);
			if(role!=2 && role!=3) {
				role=-1;
			}
		}
		return role;
	}
	
}

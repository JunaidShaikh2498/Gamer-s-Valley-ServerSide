package com.springboot.gv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.LoggedUser;
import com.springboot.gv.entities.LoginChecker;
import com.springboot.gv.entities.RegisteredUser;
import com.springboot.gv.services.RegisteredService;

@RestController
@CrossOrigin("http://localhost:3000")
public class LoginController {

	@Autowired
	RegisteredService rs;
	
	@PostMapping("/login")
	public ResponseEntity<LoggedUser> LoginUserRole(@RequestBody LoginChecker lc) {
		
			ResponseEntity<LoggedUser> rru=null;
			
			RegisteredUser ru = rs.findByUname(lc.getUsername());
			
			if(ru==null) {
				rru= ResponseEntity.notFound().build();
			}
			
	
			if(ru.getUsername().equals(lc.getUsername())  && ru.getPassword().equals(lc.getPassword())&&(ru.getApproved()==1)) { 
				int role = ru.getRoleId();
				System.out.println(role);
			if(role!=2 && role!=3) {
					role=-1;
				}
			}
	
			if(ru.getUsername().equals(lc.getUsername())  && ru.getPassword().equals(lc.getPassword())) {
				LoggedUser lu = new LoggedUser(ru.getRegistrationId(),ru.getRoleId(),ru.getUsername(),ru.getApproved());
				rru= ResponseEntity.ok(lu);
			}
			
			return rru;
	
		
	}
}

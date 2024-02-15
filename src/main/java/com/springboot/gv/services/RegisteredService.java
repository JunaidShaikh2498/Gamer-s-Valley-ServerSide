package com.springboot.gv.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.gv.entities.RegisteredUser;
import com.springboot.gv.repositories.RegisterUserRepo;

@Service
public class RegisteredService {

	@Autowired
	RegisterUserRepo rur;
	
	public RegisteredUser findByUname( String uname) {
		RegisteredUser ru =rur.findByUsername(uname);
		return ru;
	}
	 public RegisteredUser saveRegistered(RegisteredUser r) {
	       return rur.save(r);
	    }
	 public RegisteredUser findByRegId(int rid) {
		 RegisteredUser r = null;
		 Optional<RegisteredUser> oru = rur.findById(rid);
		 try {
			 r=oru.get();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 return r;
	 }
	 
	 public int updateRuser(String username, String password, int rid) {
		 return rur.updateRU(username, password, rid);
	 }
}

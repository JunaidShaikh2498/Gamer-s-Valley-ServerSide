package com.springboot.gv.services;


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
	 
	 public int approveExpert(int rid) {
		 return rur.updateApproval(rid);
	 }
	 
	 public int revokeExpert(int rid) {
		 return rur.revokeApproval(rid);
	 }
}

package com.springboot.gv.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.Expert;
import com.springboot.gv.entities.RegisteredUser;
import com.springboot.gv.repositories.ExpertRepo;
import com.springboot.gv.repositories.RegisterUserRepo;

@Service
public class ExpertService {
	
	@Autowired
	ExpertRepo er;
	
	@Autowired
	RegisterUserRepo rur;
	
	public Expert saveExpert(Expert e) {
		return er.save(e);
	}
	
	public Expert findByExpId(int rid) {
		return er.findByExpert_Id(rid);
	}
	
	public Expert updateExp(String firstname,String lastname, String email, String qualification,int regId) {
		
		return er.updateExpert(firstname,lastname,email,qualification,regId);
	}
}

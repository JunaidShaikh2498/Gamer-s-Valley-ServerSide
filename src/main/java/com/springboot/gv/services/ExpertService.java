package com.springboot.gv.services;

<<<<<<< HEAD
import java.util.List;
=======
import java.util.Optional;
>>>>>>> 3f314094bd4f3db7428cc565bf9e62bd177565a8

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
	
<<<<<<< HEAD
	public List<Expert> getExperts(){
		return er.findAll();
=======
	public Expert findByExpId(int rid) {
		return er.findByExpertid(rid);
	}
	
	public int updateExp(String firstname,String lastname, String email, String qualification,int regId) {
		
		return er.updateExpert(firstname,lastname,email,qualification,regId);
>>>>>>> 3f314094bd4f3db7428cc565bf9e62bd177565a8
	}
}

package com.springboot.gv.services;


import java.util.List;


import java.util.List;
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

	public List<Expert> getAll(){
		return er.findAll();
	}
	

	public List<Expert> getAuthorizedExperts(){
		return er.getAuthExperts();
	}

	public Expert findByExpId(int rid) {
		Expert e =null;
		Optional<Expert> oe = er.findById(rid);
		try {
			e=oe.get();
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		return e;
	}
	
	public int updateExp(String firstname,String lastname, String email, String qualification,int regId) {
		
		return er.updateExpert(firstname,lastname,email,qualification,regId);
	}

	public Expert getExpertByRid(RegisteredUser ru) {
		return er.getByRegId(ru);
	}


	public Expert findByRegId(int regId)
	{
		return er.getByRegId(regId);
	}
	

}

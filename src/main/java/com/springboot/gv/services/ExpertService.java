package com.springboot.gv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.Expert;
import com.springboot.gv.repositories.ExpertRepo;

@Service
public class ExpertService {
	
	@Autowired
	ExpertRepo er;
	
	public Expert saveExpert(Expert e) {
		return er.save(e);
	}
	
	public List<Expert> getExperts(){
		return er.findAll();
	}
}

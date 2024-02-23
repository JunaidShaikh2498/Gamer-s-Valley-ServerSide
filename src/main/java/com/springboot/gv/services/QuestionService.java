package com.springboot.gv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.Customer;
import com.springboot.gv.entities.Question;
import com.springboot.gv.repositories.QuestionRepo;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepo qr;
	
	
	public List<Question> getByCustomer(Customer c){
		return qr.findByCustomer(c);
	}
	public Question askQues(Question que) {
		return qr.save(que);
	}
	
	public Question getById(int id) {
		Question q = null;
		Optional<Question> oq = qr.findById(id);
		try {
			q=oq.get();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return q;
	}
	
	public List<Question> getAllQuestions(){
		return qr.findAll();
	}
}

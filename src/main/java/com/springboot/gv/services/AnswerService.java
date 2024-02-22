package com.springboot.gv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.Answer;
import com.springboot.gv.entities.Question;
import com.springboot.gv.repositories.AnswerRepo;

@Service

public class AnswerService {
	
	@Autowired
	AnswerRepo ar;
	
	public List<Answer> getByQuestion(Question que){
		return ar.findByQuestion(que);
	}
	
	public Answer answerQue(Answer ans) {
		return ar.save(ans);
	}
	
	public Answer getById(int id) {
		Answer a=null;
		Optional<Answer> oa = ar.findById(id);
		try {
			a=oa.get();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
}

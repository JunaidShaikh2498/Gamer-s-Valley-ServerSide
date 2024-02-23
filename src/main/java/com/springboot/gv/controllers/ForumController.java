package com.springboot.gv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Answer;
import com.springboot.gv.entities.Question;
import com.springboot.gv.services.AnswerService;
import com.springboot.gv.services.QuestionService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ForumController {

	@Autowired
	QuestionService qs;
	
	@Autowired
	AnswerService as;
	
	@GetMapping("/getquestions")
	public List<Question> getAllQues(){
		return qs.getAllQuestions();
	}
	@GetMapping("/getanswer/{qid}")
	public List<Answer> getByQues(@PathVariable("qid") int qid){
		Question q = qs.getById(qid);
		return as.getByQuestion(q);
	}
	
}

package com.springboot.gv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Answer;
import com.springboot.gv.entities.AnswerBody;
import com.springboot.gv.entities.Expert;
import com.springboot.gv.entities.Question;
import com.springboot.gv.entities.RegisteredUser;
import com.springboot.gv.entities.UpdateExp;
import com.springboot.gv.services.AnswerService;
import com.springboot.gv.services.ExpertService;
import com.springboot.gv.services.QuestionService;
import com.springboot.gv.services.RegisteredService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ExpertController {
	
	@Autowired
	AnswerService as;
	
	@Autowired
	ExpertService es;
	
	@Autowired
	RegisteredService rs;
	
	@Autowired
	QuestionService qs;
	
	@PutMapping("update/{regid}")
	public boolean upExp(@PathVariable("regid") int regId, @RequestBody UpdateExp ue) {
		boolean flag = false;

		RegisteredUser ru = rs.findByRegId(regId);
		Expert e = es.getExpertByRid(ru);
		int reg = e.getRegistered().getRegistrationId();
		rs.updateRuser(ue.getUsername(), reg);
		 
		int res = es.updateExp(ue.getFirstname(), ue.getLastname(), ue.getEmail(), ue.getQualification(),reg);
		if(res==1) {
			flag = true;
		}
		return flag;
	}
	

	
	@GetMapping("/getexpert/{rid}")
	public Expert getByRid(@PathVariable ("rid") int rid) {
		RegisteredUser ru = rs.findByRegId(rid);
		Expert e = es.getExpertByRid(ru);
		return e;
	}
	
	@PostMapping("/answer/{qid}")
	public Answer answerTheQuestion(@PathVariable("qid") int qid,@RequestParam int eid,@RequestBody AnswerBody ab) {
		Expert exp = es.findByExpId(eid);
		Question que = qs.getById(qid);
		Answer a= new Answer(ab.getAns(), que, exp);
		return as.answerQue(a);
	}
}

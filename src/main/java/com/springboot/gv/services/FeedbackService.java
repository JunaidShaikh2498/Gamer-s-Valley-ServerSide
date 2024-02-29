package com.springboot.gv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.Feedback;
import com.springboot.gv.repositories.FeedbackBRepo;

@Service
public class FeedbackService {
	
	@Autowired
	FeedbackBRepo fr;
	
	public Feedback giveFeedback(Feedback f) {
		return fr.save(f);
	}
}

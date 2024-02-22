package com.springboot.gv.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.gv.entities.Answer;
import com.springboot.gv.entities.Question;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Integer> {
	
	public List<Answer> findByQuestion(Question que);
}

package com.springboot.gv.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.gv.entities.Customer;
import com.springboot.gv.entities.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
	
	public List<Question> findByCustomer(Customer cust);
}

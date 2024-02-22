package com.springboot.gv.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.gv.entities.Category;
import com.springboot.gv.entities.FAQ;


public interface FAQsRepository extends JpaRepository<FAQ, Integer> {

	
	public List<FAQ> findByCategory(Category c);

}

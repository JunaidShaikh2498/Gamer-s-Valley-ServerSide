package com.springboot.gv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.Category;
import com.springboot.gv.entities.FAQ;
import com.springboot.gv.repositories.FAQsRepository;
@Service
public class FAQsService {

	@Autowired
	FAQsRepository fr;
	
	
	public List<FAQ> getFAQsByCategory(Category cat) {
		
		return fr.findByCategory(cat);
	}

}

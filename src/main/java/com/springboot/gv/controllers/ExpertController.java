package com.springboot.gv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Expert;
import com.springboot.gv.services.ExpertService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ExpertController 
{

	@Autowired
	private ExpertService es;
	
	@GetMapping("/expert_list")
	public List<Expert> getAll()
	{
		return es.getAll();
	}
}

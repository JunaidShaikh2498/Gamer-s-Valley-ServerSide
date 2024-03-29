package com.springboot.gv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.services.OrderStatusService;

@RestController
@CrossOrigin("http://localhost:3000") 
public class OrderStatusController {
	@Autowired
	OrderStatusService oss;
}

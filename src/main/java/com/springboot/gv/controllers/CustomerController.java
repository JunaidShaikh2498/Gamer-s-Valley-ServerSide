package com.springboot.gv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Customer;
import com.springboot.gv.entities.UpdateCustomer;
import com.springboot.gv.services.CustomerService;
import com.springboot.gv.services.RegisteredService;

@RestController
@CrossOrigin("http://localhost:3000")
public class CustomerController {
	@Autowired
	CustomerService cs;
	
	@Autowired
	RegisteredService rs;
	
	@PutMapping("updateC/{customerid}")
	public boolean upCust(@PathVariable("customerid") int regId, @RequestBody UpdateCustomer uc) {
		boolean flag = false;
		Customer c = cs.findByCustId(regId);
		int reg = c.getRegistered().getRegistration_id();
		rs.updateRuser(uc.getUsername(),reg);
		 
		int res = cs.updateCust(uc.getFirstname(), uc.getLastname(), uc.getEmail(), uc.getContact(),uc.getAddress(),reg);
		if(res==1) {
			flag = true;
		}
		return flag;
	}
}

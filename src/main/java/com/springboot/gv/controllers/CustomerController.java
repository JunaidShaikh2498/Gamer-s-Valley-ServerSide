package com.springboot.gv.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Customer;
import com.springboot.gv.entities.Question;
import com.springboot.gv.entities.QuestionBody;
import com.springboot.gv.entities.UpdateCustomer;
import com.springboot.gv.services.CustomerService;
import com.springboot.gv.services.QuestionService;
import com.springboot.gv.services.RegisteredService;

@RestController
@CrossOrigin("http://localhost:3000")
public class CustomerController {
	@Autowired
	CustomerService cs;
	
	@Autowired
	RegisteredService rs;
	
	
	@Autowired
	QuestionService qs;
	

	@PutMapping("/updateC/{customerid}")
	public boolean upCust(@PathVariable("customerid") int regId, @RequestBody UpdateCustomer uc) {
		boolean flag = false;
		Customer c = cs.findByCustId(regId);
		int reg = c.getRegistered().getRegistrationId();
		rs.updateRuser(uc.getUsername(),reg);

		rs.updateRuser(uc.getUsername(),reg);

		 
		int res = cs.updateCust(uc.getFirstname(), uc.getLastname(), uc.getEmail(), uc.getContact(),uc.getAddress(),reg);
		if(res==1) {
			flag = true;
		}
		return flag;
	}
	

	@PostMapping("/ask/{cid}")
	public Question askAQuestion(@PathVariable("cid") int cid ,@RequestBody QuestionBody qb) {
		Customer c = cs.findByCustId(cid);
		
		Question q = new Question(qb.getQue(),c);
		return qs.askQues(q);
	}	

	@GetMapping("getCustByRegId/{registration_id}")
    public Customer getCustomerByRegistrationId(@PathVariable int registration_id) {
        Customer customerOptional = cs.getCustomerByRegistrationId(registration_id);

        return customerOptional;
    }
}

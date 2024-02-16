package com.springboot.gv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.*;
import com.springboot.gv.entities.InsertUser;
import com.springboot.gv.services.CustomerService;
import com.springboot.gv.services.ExpertService;
import com.springboot.gv.services.RegisteredService;


@RestController
@RequestMapping("/registered")
@CrossOrigin("http://localhost:3000")
public class RegisteredController {

	
	@Autowired
    private RegisteredService rs;

    @Autowired
    private CustomerService cs;
    
    @Autowired
    private ExpertService es;

    @PostMapping("/save")
    public boolean saveRegistration(@RequestBody InsertUser iu) {
    	boolean flag = false;
    	RegisteredUser rr = new RegisteredUser(iu.getRoleId(),iu.getUsername(),iu.getPassword(),iu.getApproved());
    	RegisteredUser r= rs.saveRegistered(rr);
        
        Customer c = new Customer(iu.getFirstname(),iu.getLastname(),iu.getEmail(),iu.getContact(),iu.getAddress(),r);
        cs.saveCustomer(c);

        if(rr!=null && c!=null) {
        	flag = true;
        }
        return flag;
    }
    @PostMapping("/saveExp")
    public boolean saveExpReg(@RequestBody InsertExpert ie) {
    	boolean flag = false;
    	RegisteredUser rr = new RegisteredUser(ie.getRoleId(),ie.getUsername(),ie.getPassword(),ie.getApproved());
    	RegisteredUser r= rs.saveRegistered(rr);
        
        Expert e = new Expert(ie.getFirstname(),ie.getLastname(),ie.getEmail(),ie.getQualification(),r);
        es.saveExpert(e);

        if(rr!=null && e!=null) {
        	flag = true;
        }
        return flag;
    }
}

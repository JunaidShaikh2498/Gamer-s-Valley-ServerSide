package com.springboot.gv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.Customer;
import com.springboot.gv.repositories.CustomerRepo;
@Service
public class CustomerService {
	@Autowired
    private CustomerRepo cr;

    public Customer saveCustomer(Customer c) {
       return cr.save(c);
    }
    
    public Customer findByCustId(int cid) {
    	Customer c =null;
    	Optional<Customer> oc = cr.findById(cid);
    	try {
    		c=oc.get();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return c;
    }
    
    public Customer getByRegId(int regId) {
    	List<Customer> clist = cr.findAll();
    	Customer cust=null;
    	for(Customer c : clist) {
    		if(c.getRegistered().getRegistration_id()==regId) {
    			cust=c;
    		}
    	}
    	return cust;
    }
    
    public int updateCust(String firstname,String lastname, String email, String contact, String address, int regId) {
    	return cr.updateCustomer(firstname, lastname, email, contact, address, regId);
    }
}

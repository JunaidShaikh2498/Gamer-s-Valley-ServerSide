package com.springboot.gv.services;

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
    
    public Customer findByCustId(int rid) {
    	return cr.findByCustomerId(rid);
    }
    
    public int updateCust(String firstname,String lastname, String email, String contact, String address, int regId) {
    	return cr.updateCustomer(firstname, lastname, email, contact, address, regId);
    }
}

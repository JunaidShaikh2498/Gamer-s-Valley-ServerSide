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
}

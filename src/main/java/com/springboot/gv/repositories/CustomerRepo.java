package com.springboot.gv.repositories;

import com.springboot.gv.entities.Customer;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	
	@Transactional
	@Modifying
	@Query(value ="update customers set firstname =:firstname,lastname =:lastname,email =:email, contact =:contact, address =:address where registration_id =:registration_Id",nativeQuery = true)
	public int updateCustomer(String firstname,String lastname, String email, String contact, String address, int registration_Id);
}

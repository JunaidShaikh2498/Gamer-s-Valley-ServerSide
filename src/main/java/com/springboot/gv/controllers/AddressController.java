package com.springboot.gv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Address;
import com.springboot.gv.services.AddressService;

@RestController
@CrossOrigin("http://localhost:3000") 
public class AddressController {
	@Autowired
	AddressService as;
	
	@GetMapping("/getAddByCustomerId")
	public List<Address> getAddByCustomerId(@RequestParam int cid){
		return as.getAddByCustId(cid);
	}
}

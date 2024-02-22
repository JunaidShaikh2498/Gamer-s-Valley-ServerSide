package com.springboot.gv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.Address;
import com.springboot.gv.repositories.AddressRepo;

@Service
public class AddressService {
	
	@Autowired
	AddressRepo ar;
	
	public Address save(Address a) {
		return ar.save(a);
	}
	
	public Address getAddress(int aid) {
		Optional<Address> ad = ar.findById(aid);
		Address a = null;
		try {
			a = ad.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public List<Address> getAddByCustId(int cid){
		return ar.getAddressByCustId(cid);
	}
}

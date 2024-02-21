package com.springboot.gv.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.Role;
import com.springboot.gv.repositories.RoleRepo;

@Service
public class RoleService {
	
	@Autowired
	RoleRepo rr;
	
	public Role getById(int id) {
		Role r = null;
		Optional<Role> or = rr.findById(id);
		try {
			r=or.get();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
}

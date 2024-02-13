package com.springboot.gv.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.gv.entities.RegisteredUser;


public interface RegisterUserRepo extends JpaRepository<RegisteredUser, Integer> {

	//@Query(value="select * from registered where username =:username",nativeQuery = true)
	public RegisteredUser findByUsername(String username);
}

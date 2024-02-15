package com.springboot.gv.repositories;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.springboot.gv.entities.RegisteredUser;


public interface RegisterUserRepo extends JpaRepository<RegisteredUser, Integer> {

	//@Query(value="select * from registered where username =:username",nativeQuery = true)
	public RegisteredUser findByUsername(String username);
	
	@Modifying
	@Transactional
	@Query(value="update Registered set Username =:username, Password =:password where Registration_Id =:rid",nativeQuery = true)
	public int updateRU(String username, String password, int rid);
	
}

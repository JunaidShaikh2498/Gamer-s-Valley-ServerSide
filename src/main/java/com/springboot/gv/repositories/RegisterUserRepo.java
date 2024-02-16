package com.springboot.gv.repositories;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.gv.entities.RegisteredUser;

@Repository
@Transactional
public interface RegisterUserRepo extends JpaRepository<RegisteredUser, Integer> {

	//@Query(value="select * from registered where username =:username",nativeQuery = true)
	public RegisteredUser findByUsername(String username);
	
	@Modifying
<<<<<<< HEAD
	@Query("update RegisteredUser set approved = 1 where registration_id =:reg_id")
	public int updateApproval(int reg_id);
	
	@Modifying
	@Query("update RegisteredUser set approved = 0 where registration_id =:reg_id")
	public int revokeApproval(int reg_id);
=======
	@Transactional
	@Query(value="update Registered set Username =:username, Password =:password where Registration_Id =:rid",nativeQuery = true)
	public int updateRU(String username, String password, int rid);
	
>>>>>>> 3f314094bd4f3db7428cc565bf9e62bd177565a8
}

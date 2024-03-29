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

	
	public RegisteredUser findByUsername(String username);
	
	@Modifying
	@Query("update RegisteredUser set approved = 1 where registration_id =:reg_id")
	public int updateApproval(int reg_id);
	
	
	
	@Modifying
	@Query("update RegisteredUser set approved = null where registration_id =:reg_id")
	public int revokeApproval(int reg_id);

	@Modifying
	@Query(value="update Registered set username =:username where registration_id =:rid",nativeQuery = true)
	public int updateRU(String username, int rid);
	}

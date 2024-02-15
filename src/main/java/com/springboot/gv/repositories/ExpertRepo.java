package com.springboot.gv.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot.gv.entities.Expert;
@Repository
public interface ExpertRepo extends JpaRepository<Expert, Integer> {
	
	public Expert findByExpertid(int regId);
	
	@Transactional
	@Modifying
	@Query(value ="update experts set Firstname =:firstname,Lastname =:lastname,Email =:email,Qualification =:qualification where Registration_Id =:registration_Id",nativeQuery = true)
	public int updateExpert(String firstname,String lastname, String email, String qualification,int registration_Id);
	
}

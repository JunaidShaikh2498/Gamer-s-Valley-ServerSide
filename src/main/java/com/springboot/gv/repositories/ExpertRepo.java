package com.springboot.gv.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot.gv.entities.Expert;import com.springboot.gv.entities.RegisteredUser;


@Transactional
@Repository
public interface ExpertRepo extends JpaRepository<Expert, Integer> {
	
	@Query("select e from Expert e where e.registered = :regid")
	public Expert findByExpertid(RegisteredUser regid);
	
	
	@Modifying
	@Query(value ="update experts set Firstname =:firstname,Lastname =:lastname,Email =:email,Qualification =:qualification where Registration_Id =:registration_Id",nativeQuery = true)
	public int updateExpert(String firstname,String lastname, String email, String qualification,int registration_Id);


	@Query(value="select * from experts e where e.registration_id in (select registration_id from registered r where r.approved is not null)",nativeQuery = true)
	public List<Expert> getAuthExperts();
	

}

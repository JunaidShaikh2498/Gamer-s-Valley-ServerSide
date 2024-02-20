package com.springboot.gv.repositories;


import java.util.List;
import com.springboot.gv.entities.Expert;




import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot.gv.entities.Expert;



@Transactional
@Repository
public interface ExpertRepo extends JpaRepository<Expert, Integer> {
	
	@Query(value="select * from experts e,registered r where e.registration_id=r.registration_id ",nativeQuery = true)
	public Expert getByRegId(int regId);
	
	@Query(value="select * from experts e where e.registration_id in (select registration_id from registered r where r.approved is not null)",nativeQuery = true)
	public List<Expert> getAuthExperts();
	
	@Modifying
	@Query(value ="update experts set firstname =:firstname,lastname =:lastname,email =:email,qualification =:qualification where registration_id =:registration_Id",nativeQuery = true)
	public int updateExpert(String firstname,String lastname, String email, String qualification,int registration_Id);


}

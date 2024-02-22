package com.springboot.gv.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.gv.entities.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

	@Query("select a from Address a where customer_id=:cid")
	public List<Address> getAddressByCustId(int cid);
}

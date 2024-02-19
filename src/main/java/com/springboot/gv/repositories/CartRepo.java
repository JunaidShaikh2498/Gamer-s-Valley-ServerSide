package com.springboot.gv.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.gv.entities.Cart;
@Transactional
@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
	@Query("select c from Cart c where customer_id=:cid")
	public List<Cart> getAllItems(int cid);
	
	@Modifying
	@Query("delete from Cart c where customer_id=:cid")
	public int deleteAllItems(int cid);
}

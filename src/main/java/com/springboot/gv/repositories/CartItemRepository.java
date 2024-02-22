package com.springboot.gv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.gv.entities.CartItem;

@Repository 
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}

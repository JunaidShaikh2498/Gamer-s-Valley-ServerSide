package com.springboot.gv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gv.entities.CartItem;

public interface CartItemRepo extends JpaRepository<CartItem, Integer> {

}

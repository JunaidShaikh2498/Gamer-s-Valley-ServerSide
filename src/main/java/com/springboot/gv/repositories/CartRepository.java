package com.springboot.gv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gv.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}

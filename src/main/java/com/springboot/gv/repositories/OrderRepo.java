package com.springboot.gv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gv.entities.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}

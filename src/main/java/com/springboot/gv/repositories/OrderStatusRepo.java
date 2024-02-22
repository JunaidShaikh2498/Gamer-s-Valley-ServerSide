package com.springboot.gv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gv.entities.Order_Status;

public interface OrderStatusRepo extends JpaRepository<Order_Status, Integer> {

}

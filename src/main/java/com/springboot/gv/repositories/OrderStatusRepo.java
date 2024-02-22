package com.springboot.gv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gv.entities.OrderStatus;

public interface OrderStatusRepo extends JpaRepository<OrderStatus, Integer> {

}

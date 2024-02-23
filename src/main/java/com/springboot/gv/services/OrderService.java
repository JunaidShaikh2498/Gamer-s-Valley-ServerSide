package com.springboot.gv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.Order;
import com.springboot.gv.repositories.OrderRepo;
@Service
public class OrderService  {
	
	@Autowired
	OrderRepo or;
	
	public Order placeOrder(Order o) {
		return or.save(o);
	}
	public List<Order> getOrders(){
		return or.findAll();
	}
}

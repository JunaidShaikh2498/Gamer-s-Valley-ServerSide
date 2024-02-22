package com.springboot.gv.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.OrderStatus;
import com.springboot.gv.repositories.OrderStatusRepo;

@Service
public class OrderStatusService {
	@Autowired
	OrderStatusRepo osr;
	
	public OrderStatus getOrderStatusById(int osid) {
		Optional<OrderStatus> os = osr.findById(osid);
		OrderStatus o = null;
		try {
			o = os.get();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return o;
	}
}

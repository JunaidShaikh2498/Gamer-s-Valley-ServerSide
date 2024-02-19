package com.springboot.gv.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.gv.entities.Order_Status;
import com.springboot.gv.repositories.OrderStatusRepo;

@Service
public class OrderStatusService {
	@Autowired
	OrderStatusRepo osr;
	
	public Order_Status getOrderStatusById(int osid) {
		Optional<Order_Status> os = osr.findById(osid);
		Order_Status o = null;
		try {
			o = os.get();
		} catch (Exception e) {
			e.printStackTrace();    // TODO: handle exception
		}
		return o;
	}
}

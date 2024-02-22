package com.springboot.gv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.OrderItem;
import com.springboot.gv.repositories.OrderItemRepo;

@Service
public class OrderItemService {
	@Autowired
	OrderItemRepo oir;
	
	public OrderItem getOrderItemsByOrderItemId(int oiid) {
		Optional<OrderItem> oi = oir.findById(oiid);
		OrderItem o = null;
		try {
			o = oi.get();
		} catch (Exception e) {
			e.printStackTrace();    // TODO: handle exception
		}
		return o;
	}
	
	public List<OrderItem> getOrderItemByCustomerId(int cid){
		return oir.getOrderItemByCustomerId(cid);
	}
	
	public void save(OrderItem o) {
		oir.save(o);
	}
}

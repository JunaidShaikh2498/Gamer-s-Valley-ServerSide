package com.springboot.gv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.Order_Item;
import com.springboot.gv.repositories.OrderItemsRepo;
@Service
public class OrderItemService  {
	@Autowired
	OrderItemsRepo oir;
	
	public Order_Item getOrderItemsByOrderItemId(int oiid) {
		Optional<Order_Item> oi = oir.findById(oiid);
		Order_Item o = null;
		try {
			o = oi.get();
		} catch (Exception e) {
			e.printStackTrace();    // TODO: handle exception
		}
		return o;
	}
	
	public List<Order_Item> getOrderItemByCustomerId(int cid){
		return oir.getOrderItemByCustomerId(cid);
	}
	
	public void save(Order_Item o) {
		oir.save(o);
	}
}

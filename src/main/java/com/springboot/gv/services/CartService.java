package com.springboot.gv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gv.entities.Cart;
import com.springboot.gv.repositories.CartRepo;

@Service
public class CartService {
	
	@Autowired
	CartRepo cr;
	
	public Cart addToCart(Cart c) {
		return cr.save(c);
	}
	
	public List<Cart> getAllItems(int cid){
		return cr.getAllItems(cid);
	}
	
	public int deleteAllItems(int cid) {
		return cr.deleteAllItems(cid);
	}
}

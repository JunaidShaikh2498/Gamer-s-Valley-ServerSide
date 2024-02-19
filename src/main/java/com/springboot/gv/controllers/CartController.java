package com.springboot.gv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Cart;
import com.springboot.gv.entities.Customer;
import com.springboot.gv.entities.Product;
import com.springboot.gv.services.CartService;
import com.springboot.gv.services.CustomerService;
import com.springboot.gv.services.ProductService;

@RestController
public class CartController {
	
	@Autowired
	CartService cs;
	
	@Autowired
	CustomerService cus;
	
	@Autowired
	ProductService ps;
	
	@GetMapping("/addtocart")
	public Cart addToCart(@RequestParam int pid,@RequestParam int cid,@RequestParam int qty) {
		Customer c = cus.findByCustId(cid);
		Product p = ps.getById(pid);
		Cart cr = cs.addToCart(new Cart(p,qty,c));
		return cr;
	}
	
	@GetMapping("/getItems")
	public List<Cart> getCartByCustomerId(int cid){
		return cs.getAllItems(cid);
	}
}

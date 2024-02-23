package com.springboot.gv.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Order_Item;
import com.springboot.gv.services.OrderItemService;

@RestController
@CrossOrigin("http://localhost:3000") 
public class OrderItemController {
	@Autowired
	OrderItemService ois;
	
	@GetMapping("/getOrderItemByOrderItemId")
	public Order_Item getOrderItemByOiid(int oiid) {
		return ois.getOrderItemsByOrderItemId(oiid);
	}
	
	
}

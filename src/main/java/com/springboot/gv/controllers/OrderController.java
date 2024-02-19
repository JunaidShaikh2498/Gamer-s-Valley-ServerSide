package com.springboot.gv.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Address;
import com.springboot.gv.entities.Cart;
import com.springboot.gv.entities.Customer;
import com.springboot.gv.entities.Order;
import com.springboot.gv.entities.Order_Item;
import com.springboot.gv.entities.Order_Status;
import com.springboot.gv.entities.PlaceOrderPOJO;
import com.springboot.gv.services.AddressService;
import com.springboot.gv.services.CartService;
import com.springboot.gv.services.CustomerService;
import com.springboot.gv.services.OrderItemService;
import com.springboot.gv.services.OrderService;
import com.springboot.gv.services.OrderStatusService;
import com.springboot.gv.services.ProductService;

@RestController
@CrossOrigin(origins="*")
public class OrderController {
	@Autowired
	OrderService os;
	
	@Autowired
	OrderItemService ois;
	
	@Autowired
	CustomerService cs;
	
	@Autowired
	AddressService as;
	
	@Autowired
	CartService crs;
	
	@Autowired
	ProductService ps;
	
	@Autowired
	OrderStatusService oss;
	
	@Modifying
	@PostMapping("/placeOrder")
	public Order placeOrder(@RequestBody PlaceOrderPOJO po) {
		Customer c = cs.findByCustId(po.getCustomer_id());
		System.out.println(c);
		Address a = po.getAddress();
		
		List<Cart> clist = crs.getAllItems(po.getCustomer_id());
		for(Cart ca : clist) {
			System.out.println(ca);
		}
		LocalDate ld=LocalDate.now();
		Date d= Date.valueOf(ld);
		
		Order_Status ods = oss.getOrderStatusById(1);
		
		Order o = os.placeOrder(new Order(d,c,po.getTotalPrice(),a,ods));
		
		List<Cart> cl = crs.getAllItems(po.getCustomer_id());
		
		for(Cart cart : cl) {
			Order_Item oi = new Order_Item(cart.getProduct(), cart.getQuantity(), o);
			ois.save(oi);
		}
		
		int n = crs.deleteAllItems(po.getCustomer_id());
		return o;
	}
	
//	@GetMapping("/changeOrderStatus")
//	public boolean changeOrderStatus(@RequestParam int oid) {
//		boolean f = 
//	}
}

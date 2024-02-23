package com.springboot.gv.controllers;

import java.sql.Date;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Address;

import com.springboot.gv.entities.CartItem;
import com.springboot.gv.entities.Customer;
import com.springboot.gv.entities.Order;
import com.springboot.gv.entities.Order_Item;
import com.springboot.gv.entities.Order_Status;
import com.springboot.gv.entities.PlaceOrderPOJO;
import com.springboot.gv.services.AddressService;
import com.springboot.gv.services.CartItemService;
import com.springboot.gv.services.CustomerService;
import com.springboot.gv.services.OrderItemService;
import com.springboot.gv.services.OrderService;
import com.springboot.gv.services.OrderStatusService;
import com.springboot.gv.services.ProductService;

@RestController
@CrossOrigin("http://localhost:3000") 
public class OrderController {
	@Autowired
	OrderService os;
	
	@Autowired
	JavaMailSender sender;
	
	@Autowired
	OrderItemService ois;
	
	@Autowired
	CustomerService cs;
	
	@Autowired
	AddressService as;
	
	@Autowired
	CartItemService crs;
	
	@Autowired
	ProductService ps;
	
	@Autowired
	OrderStatusService oss;
	
	@Modifying
	@PostMapping("/placeOrder")
	public Order placeOrder(@RequestBody PlaceOrderPOJO po) {
		Customer cust = cs.findByCustId(po.getCustomer_id());
		System.out.println(cust);
		Address address = po.getAddress();
		address.setCustomer(cust);
		
		
		LocalDate ld=LocalDate.now();
		Date date= Date.valueOf(ld);
		
		Order_Status ods = new Order_Status(1,"placed");
		
		Order o = os.placeOrder(new Order(date,cust,po.getTotalPrice(),address,ods));
		
		List<CartItem> cl = crs.getAllCartItems();
		
		for(CartItem cart : cl) {
			Order_Item oi = new Order_Item(cart.getProduct(), cart.getQuantity(),cart.getProduct().getProductPrice(), o);
			ois.save(oi);
		}
		
		for(CartItem cart : cl)
		{
			crs.deleteCartItem(cart.getId());
		}
		SimpleMailMessage mailMsg = new SimpleMailMessage();
        mailMsg.setFrom("hrishi3bhogade@gmail.com");
        mailMsg.setTo(cust.getEmail());
        mailMsg.setSubject("Ordered Successfully");
        mailMsg.setText("Congratulations "+cust.getFirstname()+". You have ordered successfully. You can recieve your order in 3-4 business days. Your Order Id:"+o.getId()+"\nYour Total Price:"+po.getTotalPrice()+ "\nThank you!!!");
        sender.send(mailMsg);
		return o;
	}
	@GetMapping("/orderlist")
	public List<Order> getOrderList(){
		return os.getOrders();
				
	}
	
//	@GetMapping("/changeOrderStatus")
//	public boolean changeOrderStatus(@RequestParam int oid) {
//		boolean f = 
//	}
}

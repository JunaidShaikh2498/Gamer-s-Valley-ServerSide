package com.springboot.gv.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.Address;
import com.springboot.gv.entities.CartItem;
import com.springboot.gv.entities.Customer;
import com.springboot.gv.entities.Order;
import com.springboot.gv.entities.OrderItem;
import com.springboot.gv.entities.OrderStatus;
import com.springboot.gv.entities.PlaceOrder;
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
	
	
	@PostMapping("/placeOrder")
	public Order placeOrder(@RequestBody PlaceOrder po) {
		Customer cust = cs.findByCustId(po.getCustomer_id());
		System.out.println(cust);
		Address address = po.getAddress();
		address.setCustomer(cust);
		
		
		LocalDate ld=LocalDate.now();
		Date date= Date.valueOf(ld);
		
		OrderStatus ods = new OrderStatus(1,"placed");
		
		Order o = os.placeOrder(new Order(date,cust,po.getTotal_price(),address,ods));
		
		List<CartItem> cl = crs.getAllCartItems();
		
		for(CartItem cart : cl) {
			OrderItem oi = new OrderItem(cart.getProduct(), cart.getQuantity(),cart.getProduct().getProductPrice(), o);
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
        mailMsg.setText("Congratulations "+cust.getFirstname()+". You have ordered successfully. You can recieve your order in 3-4 business days. Your Order Id:"+o.getOrder_id()+"\nYour Total Price:"+po.getTotal_price()+ "\nThank you!!!");
        sender.send(mailMsg);
		return o;
	}
}

package com.springboot.gv.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlaceOrderPOJO { 
	private int customer_id;
	private Address address;
	private double totalPrice;
}

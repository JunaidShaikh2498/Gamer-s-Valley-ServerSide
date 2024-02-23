package com.springboot.gv.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderPOJO {
	private int customer_id;
	private Address address;
	private double totalPrice;
}

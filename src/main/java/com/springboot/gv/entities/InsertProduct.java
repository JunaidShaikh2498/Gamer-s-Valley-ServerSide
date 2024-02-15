package com.springboot.gv.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class InsertProduct {

	private String productName;
	
	private String productDescription;
	
	private double productPrice;
	
}

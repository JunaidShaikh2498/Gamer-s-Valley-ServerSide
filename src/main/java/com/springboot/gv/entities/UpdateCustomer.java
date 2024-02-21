package com.springboot.gv.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomer {
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String contact;
	
	private String  address;
	
	private String username;
	
}

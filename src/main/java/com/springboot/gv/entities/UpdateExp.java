package com.springboot.gv.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateExp {
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String qualification;
	
	private String username;
	
	private String password;
}

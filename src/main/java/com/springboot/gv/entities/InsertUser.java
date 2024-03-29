package com.springboot.gv.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsertUser {
	 	private String firstname;

	    private String lastname;

	    private String email;

	    private String contact;

	    private String address;
	    
	    private String username;
	    
	    private String password;
	    
	    private int roleId;
	    
	    private int approved;
}

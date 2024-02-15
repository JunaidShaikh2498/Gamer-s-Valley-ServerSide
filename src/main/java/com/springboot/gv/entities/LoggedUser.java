package com.springboot.gv.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class LoggedUser {
	
	private int registrationId;
	
	private int roleId;
	
	private String username;
	
	private int approved;
	
	
}

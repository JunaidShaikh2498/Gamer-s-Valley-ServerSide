package com.springboot.gv.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class InsertExpert {
	private String firstname;

    private String lastname;

    private String email;

    private String qualification;

    private String username;
    
    private String password;
    
    private int roleId;
    
    private int approved;
}

package com.springboot.gv.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter

@NoArgsConstructor
@AllArgsConstructor
public class InsertFAQ {

	private String question;
	
	private String answer;
	
	private int categoryId;
	
}

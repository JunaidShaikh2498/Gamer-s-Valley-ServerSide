package com.springboot.gv.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter

@Entity
@Table(name = "registered")
public class RegisteredUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Registration_Id")
	private int registration_id;
	
	@Column
	private int role_id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private int approved;

	public RegisteredUser(int role_id, String username, String password, int approved) {
		super();
		this.role_id = role_id;
		this.username = username;
		this.password = password;
		this.approved = approved;
	}
	
	
}



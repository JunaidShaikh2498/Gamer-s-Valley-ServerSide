package com.springboot.gv.entities;

import java.util.List;


import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "registered")
public class RegisteredUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="registration_id")
	private int registrationId;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	@Column
	private String username;
	
	@Column
	private String password;
	

	@Column
	private int approved;

	public RegisteredUser(Role role, String username, String password, int approved) {
		super();
		this.role=role;
		this.username = username;
		this.password = password;
		this.approved = approved;
	}
	
	
}



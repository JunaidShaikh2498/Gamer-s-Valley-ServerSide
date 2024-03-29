package com.springboot.gv.entities;


import javax.persistence.*;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="address")
public class Address { 
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	private int aid;

	@Column
	private String street;
	
	@Column
	private String city;
	
	@ManyToOne
	@Cascade(value=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;

	public Address(String street, String city, Customer customer) {
		super();
		this.street = street;
		this.city = city;
		this.customer = customer;
	}
	
	

	
}

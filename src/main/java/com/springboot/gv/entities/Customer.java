package com.springboot.gv.entities;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="customers")
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int customerId;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String email;

    @Column
    private String contact;

    @Column
    private String address;

    @OneToOne
    @JoinColumn(name = "Registration_Id", referencedColumnName = "Registration_Id")
    private RegisteredUser registered;

	public Customer(String firstName, String lastName, String email, String contact, String address,
			RegisteredUser registered) {
		super();
		this.firstname = firstName;
		this.lastname = lastName;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.registered = registered;
	}
	
}

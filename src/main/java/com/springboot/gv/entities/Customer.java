package com.springboot.gv.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Customers")
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_Id")
    private int customerId;

    @Column(name = "Firstname")
    private String firstName;

    @Column(name = "Lastname")
    private String lastName;

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "Contact")
    private String contact;

    @Column(name = "Address")
    private String address;

    @OneToOne
    @JoinColumn(name = "Registration_Id", referencedColumnName = "Registration_Id")
    private RegisteredUser registered;

	public Customer(String firstName, String lastName, String email, String contact, String address,
			RegisteredUser registered) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.registered = registered;
	}
	
}

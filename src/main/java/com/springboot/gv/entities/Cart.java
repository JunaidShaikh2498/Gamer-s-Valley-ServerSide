package com.springboot.gv.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cart")
public class Cart {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnoreProperties("cartList")
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id")
    private Product product;


    @Column(name = "quantity")
    private int quantity;

	@JsonIgnoreProperties("cartList")
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
    private Customer customer;

	public Cart(Product product, int quantity, Customer customer) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.customer = customer;
	}
	
	
		
}

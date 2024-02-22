package com.springboot.gv.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "cart_item") 
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private int quantity;

	public CartItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
    
    // Constructors, getters, setters, etc.
}


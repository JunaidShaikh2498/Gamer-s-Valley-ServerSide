package com.springboot.gv.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();

	@JsonIgnoreProperties("cartList")
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
    private Customer customer;
}

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="order_items")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("orderItemList")
	private Product product;
	
	@Column
	private int quantity;
	
	@Column
	private double price;

	@JoinColumn(name ="order_id")
	@JsonIgnoreProperties("orderItemList")
	@ManyToOne(cascade = CascadeType.ALL)
	private Order order;

	public OrderItem(Product product, int quantity, double price, Order order) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.order = order;
	}
	
	
}

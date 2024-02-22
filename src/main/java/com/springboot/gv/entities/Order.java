package com.springboot.gv.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	
	@JsonFormat(pattern = "yyyy-MM-dd-hh-mm-ss")
	@Column
	private Date order_date;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	@JsonIgnoreProperties("orders")
	private Customer customer;
	
	@Column
	private double total_price;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aid")
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private OrderStatus orderStatus;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("order")
	private List<OrderItem> orderItemList;

	public Order(Date order_date, Customer customer, double total_price, Address address, OrderStatus orderStatus,
			List<OrderItem> orderItemList) {
		super();
		this.order_date = order_date;
		this.customer = customer;
		this.total_price = total_price;
		this.address = address;
		this.orderStatus = orderStatus;
		this.orderItemList = orderItemList;
	}

	public Order(Date order_date, Customer customer, double total_price, Address address, OrderStatus orderStatus) {
		super();
		this.order_date = order_date;
		this.customer = customer;
		this.total_price = total_price;
		this.address = address;
		this.orderStatus = orderStatus;
	}
	
	
}

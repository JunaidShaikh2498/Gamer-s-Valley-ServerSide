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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "orders")
public class Order {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="oid")
	    private int id;

		@JsonFormat(pattern = "yyyy-MM-dd-hh-mm-ss")
	    @Column(name = "order_date")
	    private Date orderDate;

		@JsonIgnoreProperties("orders")
	    @ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="customer_Id")
	    private Customer customer;

	    @Column(name = "total_price")
	    private Double totalPrice;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "address_id")
	    private Address address;


		@OneToOne
		@JoinColumn(name="status_id")
	    private Order_Status orderStatus;

	    @JsonIgnoreProperties("order")
		@OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
	    private List<Order_Item> orderitemList;

		public Order(Date orderDate, Customer customer, Double totalPrice, Address address, Order_Status orderStatus,
				List<Order_Item> orderitemList) {
			super();
			this.orderDate = orderDate;
			this.customer = customer;
			this.totalPrice = totalPrice;
			this.address = address;
			this.orderStatus = orderStatus;
			this.orderitemList = orderitemList;
		}

		public Order(Date orderDate, Customer customer, Double totalPrice, Address address, Order_Status orderStatus) {
			super();
			this.orderDate = orderDate;
			this.customer = customer;
			this.totalPrice = totalPrice;
			this.address = address;
			this.orderStatus = orderStatus;
		}
	    
	    
	
}

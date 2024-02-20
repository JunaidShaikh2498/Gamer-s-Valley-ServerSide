package com.springboot.gv.entities;


import java.sql.Date;
import java.util.List;

import javax.persistence.*;

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
    private int oid;

	@JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "order_date")
    private Date orderDate;

	@JsonIgnoreProperties("orders")
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
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

	
    
    
    
}

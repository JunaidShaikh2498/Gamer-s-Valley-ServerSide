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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_item")
public class Order_Item {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oiid;

    @JsonIgnoreProperties("orderItemList")
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    
    @JsonIgnoreProperties("orderitemList")
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="oid")
    private Order order;


	public Order_Item(Product product, int quantity, Order order) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.order = order;
	}
    
    
    
}

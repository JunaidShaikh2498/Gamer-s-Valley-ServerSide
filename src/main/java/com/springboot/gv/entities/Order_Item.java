package com.springboot.gv.entities;

import java.sql.Date;
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
@Table(name = "order_item")
public class Order_Item {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnoreProperties("orderItemList")
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    
    @JsonIgnoreProperties("orderitemList")
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
    private Order order;
}

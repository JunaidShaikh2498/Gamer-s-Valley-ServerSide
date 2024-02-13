package com.springboot.gv.entities;

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


@Setter
@Getter

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Product_Id")
	private int productId;
	
	@Column(name="Product_Name")
	private String productName;
	
	@Column(name="Product_Description")
	private String productDescription;
	
	@Column(name="Product_Price")
	private double productPrice;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	@JsonIgnoreProperties("products")
	private Category category;

	public Product(String productName, String productDescription, double productPrice, Category category) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.category = category;
	}
	
	
}

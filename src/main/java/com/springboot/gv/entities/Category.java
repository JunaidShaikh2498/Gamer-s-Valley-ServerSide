package com.springboot.gv.entities;

import java.util.List;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="category_description")
	private String categoryDescription;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("category")
	private List<Product>products;
	
	
	public Category(String category_name, String category_description) {
		super();
		this.categoryName = category_name;
		this.categoryDescription = category_description;
		for(Product p : products) {
			p.setCategory(this);
		}
	}
	
	
	public void setProducts(List<Product> products) {
		for(Product p : products) {
			p.setCategory(this);
		}
		this.products=products;
	}

}

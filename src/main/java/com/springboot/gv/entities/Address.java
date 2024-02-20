package com.springboot.gv.entities;

import javax.persistence.*;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	private int aid;

	@Column
	private String street;
	
	@Column
	private String city;
	
	@ManyToOne
	@Cascade(value=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;

}

package com.springboot.gv.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="order_status")
public class Order_Status {
	@Id
	private int id;
	
	@Column
	private String status;
}

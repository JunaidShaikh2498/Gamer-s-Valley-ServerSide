package com.springboot.gv.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="faqs")
public class FAQ {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int fid;
	
	@Column
	private String question;
	@Column
	private String answer;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;
}

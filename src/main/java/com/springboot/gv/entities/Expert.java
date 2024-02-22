package com.springboot.gv.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter

@Entity
@Table(name="experts")
public class Expert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="expert_id")
	private int expertId;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private String email;
	
	@Column
	private String qualification;
	
	@OneToOne
    @JoinColumn(name = "registration_id")
    private RegisteredUser registered;


	public Expert(String firstName, String lastName, String email, String qualification,
			RegisteredUser registered) {
		super();
		this.firstname = firstName;
		this.lastname = lastName;
		this.email = email;
		this.qualification = qualification;
		this.registered = registered;
	}
}

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
	@Column(name="Expert_Id")
	private int expert_id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	
	
	
	private String email;
	
	private String qualification;
	
	@OneToOne
    @JoinColumn(name = "registration_id", referencedColumnName = "registration_id")
    private RegisteredUser registered;

	public Expert(String firstName, String lastName, String username, String email, String qualification,
			RegisteredUser registered) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.qualification = qualification;
		this.registered = registered;
	}

	
	
	
}

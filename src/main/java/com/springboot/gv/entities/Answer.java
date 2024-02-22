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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="answers")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "answer_id")
	private int answerId;
	
	@Column
	private String answer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="question_id")
	private Question question;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "expert_id")
	private Expert expert;

	public Answer(String answer, Question question, Expert expert) {
		super();
		this.answer = answer;
		this.question = question;
		this.expert = expert;
	}
	
	
}

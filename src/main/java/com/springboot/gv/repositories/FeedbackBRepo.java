package com.springboot.gv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gv.entities.Feedback;

public interface FeedbackBRepo extends JpaRepository<Feedback, Integer> {

}

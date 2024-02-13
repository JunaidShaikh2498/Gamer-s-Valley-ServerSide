package com.springboot.gv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gv.entities.Expert;

public interface ExpertRepo extends JpaRepository<Expert, Integer> {

}

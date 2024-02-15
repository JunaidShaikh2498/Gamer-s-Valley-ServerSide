package com.springboot.gv.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gv.entities.Expert;


public interface ExpertRepo extends JpaRepository<Expert, Integer> {


}

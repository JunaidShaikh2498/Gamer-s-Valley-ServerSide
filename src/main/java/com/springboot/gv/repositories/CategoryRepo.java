package com.springboot.gv.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gv.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	public Category findByCategoryName(String name);
}

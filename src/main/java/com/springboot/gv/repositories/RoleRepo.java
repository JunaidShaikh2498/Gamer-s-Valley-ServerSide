package com.springboot.gv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gv.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}

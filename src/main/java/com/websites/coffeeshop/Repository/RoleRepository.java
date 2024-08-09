package com.websites.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websites.coffeeshop.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
  Role findByName(String name);
}

package com.websites.coffeeshop.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.websites.coffeeshop.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
  Optional<Role> findByName(String name);
}

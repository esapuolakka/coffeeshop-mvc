package com.websites.coffeeshop.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.websites.coffeeshop.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
  Optional<User> findByUsername(String username);
  boolean existsByUsername(String username);
}

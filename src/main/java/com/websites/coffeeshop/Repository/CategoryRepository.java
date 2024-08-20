package com.websites.coffeeshop.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.websites.coffeeshop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
  Optional<Category> findByName(String name);
}

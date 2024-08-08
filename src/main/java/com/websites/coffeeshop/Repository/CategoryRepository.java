package com.websites.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websites.coffeeshop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
  
}

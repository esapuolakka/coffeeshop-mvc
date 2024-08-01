package com.websites.coffeeshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websites.coffeeshop.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
  
}

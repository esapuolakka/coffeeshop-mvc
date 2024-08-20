package com.websites.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websites.coffeeshop.model.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
  
}

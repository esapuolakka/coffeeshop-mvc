package com.websites.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websites.coffeeshop.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
  
}

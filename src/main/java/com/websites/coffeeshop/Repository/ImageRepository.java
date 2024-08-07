package com.websites.coffeeshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.websites.coffeeshop.Model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
  
}

package com.websites.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websites.coffeeshop.model.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long>{
  
}

package com.websites.coffeeshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websites.coffeeshop.Model.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long>{
  
}

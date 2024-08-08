package com.websites.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websites.coffeeshop.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}
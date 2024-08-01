package com.websites.coffeeshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websites.coffeeshop.Model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}
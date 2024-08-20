package com.websites.coffeeshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.websites.coffeeshop.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

  @EntityGraph(attributePaths = { "manufacturer", "supplier" })
  List<Item> findByCategoryId(Long categoryId);

  @Query(value = "SELECT i FROM Item i WHERE i.id > :id ORDER BY i.id ASC LIMIT 1")
  Optional<Item> findNextItem(@Param("id") Long id);

  @Query(value = "SELECT i FROM Item i WHERE i.id < :id ORDER BY i.id DESC LIMIT 1")
  Optional<Item> findPreviousItem(@Param("id") Long id);

  List<Item> findByManufacturerId(Long manufacturerId);

  List<Item> findBySupplierId(Long supplierId);

  @Query("SELECT i FROM Item i WHERE i.category.id = :category AND LOWER(i.name) LIKE LOWER(CONCAT('%', :name, '%'))")
  List<Item> findByCategoryIdAndName(@Param("category") Long categoryId, @Param("name") String name);
}

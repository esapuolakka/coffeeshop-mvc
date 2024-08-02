package com.websites.coffeeshop.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.websites.coffeeshop.Model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

  @EntityGraph(attributePaths = {"manufacturer", "supplier"})
  List<Item> findByCategoryId(Long categoryId);

  @Query(value = "SELECT i FROM Item i WHERE i.id > :id ORDER BY i.id ASC LIMIT 1")
  Optional<Item> findNextItem(@Param("id") Long id);

  @Query(value = "SELECT i FROM Item i WHERE i.id < :id ORDER BY i.id DESC LIMIT 1")
  Optional<Item> findPreviousItem(@Param("id") Long id);

}

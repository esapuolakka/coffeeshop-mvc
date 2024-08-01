package com.websites.coffeeshop.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.websites.coffeeshop.Model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
  List<Item> findByCategoryId(Long categoryId);
}

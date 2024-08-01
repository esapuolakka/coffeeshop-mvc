package com.websites.coffeeshop.Service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websites.coffeeshop.Model.Item;
import com.websites.coffeeshop.Repository.ItemRepository;

@Service
public class CoffeeShopService {

  @Autowired
  private ItemRepository itemRepository;
  
  public Item getItemById(Long id) {
    Optional<Item> itemOptional = itemRepository.findById(id);

    if (itemOptional.isPresent()) {
      return itemOptional.get();
    } else {
      return null;
    }
  }

  public List<Item> getAllItems() {
    return itemRepository.findAll();
  }

  public List<Item> getAllByCategory(Long categoryId) {
    return itemRepository.findByCategoryId(categoryId);
  }

}

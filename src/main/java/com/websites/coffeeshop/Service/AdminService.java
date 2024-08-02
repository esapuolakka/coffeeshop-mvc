package com.websites.coffeeshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.websites.coffeeshop.Model.Item;
import com.websites.coffeeshop.Repository.ItemRepository;

@Service
public class AdminService {
  
  @Autowired
  private ItemRepository itemRepository;

  public List<Item> getAllItems() {
    return itemRepository.findAll();
  }
  public List<Item> getAllByCategory(Long categoryId) {
    return itemRepository.findByCategoryId(categoryId);
  }

  public Item getItemById(Long id) {
    return itemRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Item not found"));
  }

  public Long getNextItemId(Long id) {
    Optional<Item> nextItem = itemRepository.findNextItem(id);
    return nextItem.map(Item::getId).orElse(null);
  }

  public Long getPreviousItemId(Long id) {
    Optional<Item> previousItem = itemRepository.findPreviousItem(id);
    return previousItem.map(Item::getId).orElse(null);
  }

  public Item updateItem(Item updatedItem) {

    Item item = itemRepository.findById(updatedItem.getId())
      .orElseThrow(() -> new RuntimeException("Item not found"));
    
    if (updatedItem.getName() == null || updatedItem.getName().isEmpty() || 
    updatedItem.getDescription() == null || updatedItem.getDescription().isEmpty() || 
    updatedItem.getPrice() == null) {
      throw new RuntimeException("No empty fields allowed");
    }

    item.setName(updatedItem.getName());
    item.setDescription(updatedItem.getDescription());
    item.setPrice(updatedItem.getPrice());
    
    return itemRepository.save(updatedItem);
  }
}

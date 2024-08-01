package com.websites.coffeeshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
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
}

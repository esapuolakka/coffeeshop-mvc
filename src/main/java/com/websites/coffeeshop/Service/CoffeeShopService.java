package com.websites.coffeeshop.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websites.coffeeshop.Model.Image;
import com.websites.coffeeshop.Model.Item;
import com.websites.coffeeshop.Model.ItemWithImageUrl;
import com.websites.coffeeshop.Repository.ImageRepository;
import com.websites.coffeeshop.Repository.ItemRepository;

@Service
public class CoffeeShopService {

  @Autowired
  private ItemRepository itemRepository;

  @Autowired
  private ImageRepository imageRepository;

  public Item getItemById(Long id) {
    return itemRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Item not found"));
  }

  public List<Item> getAllItems() {
    return itemRepository.findAll();
  }

  public List<Item> getAllByCategory(Long categoryId) {
    return itemRepository.findByCategoryId(categoryId);
  }

  public Image getImageById(Long id) {
    return imageRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Image not found"));
  }

  // public List<String> getAllImageUrls(Long id) {
  // List<Item> items = getAllByCategory(id);
  // List<String> imageUrls = items.stream()
  // .map(item -> {
  // if (item.getImage() != null) {
  // return "/kahvilaitteet/" + item.getImage().getId() + "/kuva";
  // } else {
  // return "/images/No_Image_Available.png";
  // }
  // })
  // .toList();
  // return imageUrls;
  // }

  public List<ItemWithImageUrl> getAllItemsWithImageUrls(Long categoryId) {
    String categoryPath = categoryId == 1 ? "/tuotteet/kahvilaitteet/" : "/tuotteet/kulutustuotteet/";
    List<Item> items = getAllByCategory(categoryId);
    return items.stream()
        .map(item -> {
          String imageUrl = (item.getImage() != null) ? categoryPath + item.getImage().getId() + "/kuva"
              : "/images/No_Image_Available.png";
          return new ItemWithImageUrl(item, imageUrl);
        })
        .toList();
  }
}

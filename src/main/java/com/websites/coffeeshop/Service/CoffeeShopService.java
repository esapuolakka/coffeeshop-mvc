package com.websites.coffeeshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.websites.coffeeshop.repository.DiscountRepository;
import com.websites.coffeeshop.repository.ImageRepository;
import com.websites.coffeeshop.repository.ItemRepository;
import com.websites.coffeeshop.model.Discount;
import com.websites.coffeeshop.model.Image;
import com.websites.coffeeshop.model.Item;
import com.websites.coffeeshop.model.ItemWithImageUrl;

@Service
public class CoffeeShopService {

  @Autowired
  private ItemRepository itemRepository;

  @Autowired
  private ImageRepository imageRepository;

  @Autowired
  private DiscountRepository discountRepository;

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

  public List<ItemWithImageUrl> getAllItemsWithImageUrls(Long categoryId) {
    String categoryPath = categoryId == 1 ? "/tuotteet/kahvilaitteet/" : "/tuotteet/kulutustuotteet/";
    List<Item> items = getAllByCategory(categoryId);
    return items.stream()
        .map(item -> {
          String imageUrl = (item.getImage() != null) ? categoryPath + item.getImage().getId() + "/kuva"
              : "/images/No_Image_Available.png";
          BigDecimal discountedPrice = BigDecimal.valueOf(getDiscountedPrice(item.getPrice()));
          return new ItemWithImageUrl(item, imageUrl, discountedPrice);
        })
        .toList();
  }

  public List<ItemWithImageUrl> searchItemsWithImageUrls(Long categoryId, String name) {
    String categoryPath = categoryId == 1 ? "/tuotteet/kahvilaitteet/" : "/tuotteet/kulutustuotteet/";
    List<Item> items = itemRepository.findByCategoryIdAndName(categoryId, name);

    return items.stream()
        .map(item -> {
          String imageUrl = (item.getImage() != null) ? categoryPath + item.getImage().getId() + "/kuva"
              : "/images/No_Image_Available.png";
          BigDecimal discountedPrice = BigDecimal.valueOf(getDiscountedPrice(item.getPrice()));
          return new ItemWithImageUrl(item, imageUrl, discountedPrice);
        })
        .toList();
  }

  public Discount getDiscount() {
    return discountRepository.findById(1L)
        .orElseThrow(() -> new RuntimeException("Discount not found"));
  }

   // Laskee alennetun hinnan
  public double getDiscountedPrice(BigDecimal itemPrice) {
    double discount = getDiscount().getDiscount();
    BigDecimal discountedPrice = itemPrice.subtract(itemPrice.multiply(BigDecimal.valueOf(discount)).divide(BigDecimal.valueOf(100)));
    discountedPrice = discountedPrice.setScale(2, RoundingMode.HALF_UP);
    return discountedPrice.doubleValue();
  }
}

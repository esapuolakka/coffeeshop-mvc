package com.websites.coffeeshop.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemWithImageUrl {
  
  private Item item;
  private String imageUrl;
}

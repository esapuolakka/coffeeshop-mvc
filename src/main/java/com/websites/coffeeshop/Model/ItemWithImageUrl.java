package com.websites.coffeeshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemWithImageUrl {
  
  private Item item;
  private String imageUrl;
  private BigDecimal discountedPrice;
}

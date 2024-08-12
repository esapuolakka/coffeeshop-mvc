package com.websites.coffeeshop.model;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ItemDTO {

  private Long id;
  private String name;
  private String description;
  private BigDecimal price;
  private Manufacturer manufacturer;
  private Supplier supplier;
  private Long imageId;
  private Long categoryId;
}

package com.websites.coffeeshop.model;

import java.math.BigDecimal;

public class ItemDTO {

  private Long id;
  private String name;
  private String description;
  private BigDecimal price;
  private Manufacturer manufacturer;
  private Supplier supplier;
  private Long imageId;
  private Long categoryId;

  public ItemDTO() {
  }

  public ItemDTO(Long id, String name, String description, BigDecimal price, Manufacturer manufacturer,
      Supplier supplier, Long imageId, Long categoryId) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.manufacturer = manufacturer;
    this.supplier = supplier;
    this.imageId = imageId;
    this.categoryId = categoryId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Manufacturer getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(Manufacturer manufacturer) {
    this.manufacturer = manufacturer;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  public Long getImageId() {
    return imageId;
  }

  public void setImageId(Long imageId) {
    this.imageId = imageId;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }
}

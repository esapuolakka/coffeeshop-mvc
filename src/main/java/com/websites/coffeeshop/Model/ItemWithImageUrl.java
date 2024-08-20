package com.websites.coffeeshop.model;

import java.math.BigDecimal;

public class ItemWithImageUrl {

  private Item item;
  private String imageUrl;
  private BigDecimal discountedPrice;

  public ItemWithImageUrl() {
  }

  public ItemWithImageUrl(Item item, String imageUrl, BigDecimal discountedPrice) {
    this.item = item;
    this.imageUrl = imageUrl;
    this.discountedPrice = discountedPrice;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public BigDecimal getDiscountedPrice() {
    return discountedPrice;
  }

  public void setDiscountedPrice(BigDecimal discountedPrice) {
    this.discountedPrice = discountedPrice;
  }
}

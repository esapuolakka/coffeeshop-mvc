package com.websites.coffeeshop.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "osasto")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "nimi")
  private String name;

  @Column(name = "osastoid")
  private Long categoryId;

  @OneToMany(mappedBy = "category")
  private List<Item> categoryItems;

  public Category() {
  }

  public Category(Long id, String name, Long categoryId, List<Item> categoryItems) {
    this.id = id;
    this.name = name;
    this.categoryId = categoryId;
    this.categoryItems = categoryItems;
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

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public List<Item> getCategoryItems() {
    return categoryItems;
  }

  public void setCategoryItems(List<Item> categoryItems) {
    this.categoryItems = categoryItems;
  }

  @Override
  public String toString() {
    return "Category{id=" + id + ", name='" + name + "'}";
  }
}

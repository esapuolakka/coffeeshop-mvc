package com.websites.coffeeshop.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="valmistaja")
public class Manufacturer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private Long id;

  @Column(name="nimi")
  private String name;

  @Column(name="url")
  private String url;

  @OneToMany(mappedBy="manufacturer")
  private List<Item> manufacturerItems;

  public Manufacturer() {
  }

  public Manufacturer(Long id, String name, String url, List<Item> manufacturerItems) {
    this.id = id;
    this.name = name;
    this.url = url;
    this.manufacturerItems = manufacturerItems;
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

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public List<Item> getManufacturerItems() {
    return manufacturerItems;
  }

  public void setManufacturerItems(List<Item> manufacturerItems) {
    this.manufacturerItems = manufacturerItems;
  }
}

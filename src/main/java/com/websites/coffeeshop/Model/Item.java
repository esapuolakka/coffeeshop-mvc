package com.websites.coffeeshop.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="item")
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private Long id;

  @Column(name="name")
  private String name;

  @Column(name="description")
  private String description;

  @Column(name="price")
  private BigDecimal price;

  @Lob
  @Column(name="image")
  private byte[] image;

  @ManyToOne
  @JoinColumn(name="category_id", nullable=false)
  private Category category;

  @ManyToOne
  @JoinColumn(name="supplier_id", nullable=false)
  private Supplier supplier;

  @ManyToOne
  @JoinColumn(name="manufacturer_id", nullable=false)
  private Manufacturer manufacturer;
}

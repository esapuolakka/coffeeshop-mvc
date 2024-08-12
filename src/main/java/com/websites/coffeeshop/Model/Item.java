package com.websites.coffeeshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tuote")
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private Long id;

  @Column(name="nimi")
  private String name;

  @Column(name="kuvaus")
  private String description;

  @Column(name="hinta")
  private BigDecimal price;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="tuotekuva")
  private Image image;

  @Column(name="lisatty")
  private LocalDateTime createdAt;

  @ManyToOne
  @JoinColumn(name="osastoid", nullable=false)
  private Category category;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="toimittajaid", nullable=false)
  private Supplier supplier;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="valmistajaid", nullable=false)
  private Manufacturer manufacturer;
}

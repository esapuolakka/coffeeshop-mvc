package com.websites.coffeeshop.Model;

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

  @Lob
  @Basic(fetch = FetchType.LAZY)
  @Column(name="tuotekuva")
  private byte[] image;

  @Column(name="lisätty")
  private LocalDateTime createdAt;

  @ManyToOne
  @JoinColumn(name="osastoid", nullable=false)
  private Category category;

  @ManyToOne
  @JoinColumn(name="toimittajaid", nullable=false)
  private Supplier supplier;

  @ManyToOne
  @JoinColumn(name="valmistajaid", nullable=false)
  private Manufacturer manufacturer;
}

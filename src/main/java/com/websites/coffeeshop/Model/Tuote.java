package com.websites.coffeeshop.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tuote")
public class Tuote {

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
  @Column(name="tuotekuva")
  private byte[] image;
}

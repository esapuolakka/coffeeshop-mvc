package com.websites.coffeeshop.Model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="kuva")
public class Image {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private Long id;

  @Column(name="nimi")
  private String name;

  @Column(name="mediatyyppi")
  private String mediaType;

  @Column(name="koko")
  private Long size;

  @Lob
  @Column(name="sisältö")
  @Basic(fetch = FetchType.LAZY)
  private byte[] content;
}

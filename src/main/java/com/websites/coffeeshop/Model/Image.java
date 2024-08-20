package com.websites.coffeeshop.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "kuva")
public class Image {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "nimi")
  private String name;

  @Column(name = "mediatyyppi")
  private String mediaType;

  @Column(name = "koko")
  private Long size;

  @Lob
  @Column(name = "sisalto")
  @Basic(fetch = FetchType.LAZY)
  private byte[] content;

  public Image() {
  }

  public Image(Long id, String name, String mediaType, Long size, byte[] content) {
    this.id = id;
    this.name = name;
    this.mediaType = mediaType;
    this.size = size;
    this.content = content;
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

  public String getMediaType() {
    return mediaType;
  }

  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }

  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  public byte[] getContent() {
    return content;
  }

  public void setContent(byte[] content) {
    this.content = content;
  }
}

package com.websites.coffeeshop.Model;

import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="osasto")
public class Category {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private Long id;

  @Column(name="nimi")
  private String name;

  @Column(name="osastoid")
  private Long categoryId;

  @OneToMany(mappedBy="category")
  private List<Item> categoryItems;
}

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
}

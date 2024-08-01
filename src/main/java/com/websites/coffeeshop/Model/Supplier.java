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
@Table(name="toimittaja")
public class Supplier {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private Long id;

  @Column(name="nimi")
  private String name;

  @Column(name="yhteyshenkilö")
  private String contactPerson;

  @Column(name="yhteyshenkilön_email")
  private String contactPersonEmail;

  @OneToMany(mappedBy="supplier")
  private List<Item> supplierItems;
}

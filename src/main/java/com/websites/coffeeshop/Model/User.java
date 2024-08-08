package com.websites.coffeeshop.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="kayttaja")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private Long id;

  @Column(name="kayttajanimi")
  private String username;

  @Column(name="salasana")
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
        name = "kayttaja_roolit",
        joinColumns = @JoinColumn(name = "kayttaja_id"),
        inverseJoinColumns = @JoinColumn(name = "rooli_id")
    )
  @Column(name="rooli")
  private Set<Role> roles;
}

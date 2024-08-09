package com.websites.coffeeshop.service;

import com.websites.coffeeshop.model.Role;
import com.websites.coffeeshop.model.User;
import com.websites.coffeeshop.repository.RoleRepository;
import com.websites.coffeeshop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public ResponseEntity<String> registerUser(String username, String password) {
    if (existsByUsername(username)) {
      return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
    }
    User user = new User();
    user.setUsername(username);
    user.setPassword(passwordEncoder.encode(password));

    Role userRole = roleRepository.findByName("ROLE_USER");

    if (userRole == null) {
      return new ResponseEntity<>("Role not found: ROLE_USER", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    user.setRoles(new HashSet<>(Set.of(userRole)));
    userRepository.save(user);

    return new ResponseEntity<>("Registration successful", HttpStatus.OK);
  }


  public boolean existsByUsername(String username) {
    return userRepository.existsByUsername(username);
  }
}

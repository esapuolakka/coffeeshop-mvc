package com.websites.coffeeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.websites.coffeeshop.model.User;
import com.websites.coffeeshop.model.UserRegistrationDto;
import com.websites.coffeeshop.service.UserService;

import org.springframework.ui.Model;

@Controller
public class AuthController {

  @Autowired
  private  UserService userService;

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/register")
  public String register(Model model) {
    model.addAttribute("user", new User());
    return "register";
  }

  @PostMapping("/register")
  public String registerUser(@ModelAttribute("user") UserRegistrationDto userDto, Model model) {
    if (userService.existsByUsername(userDto.getUsername())) {
      model.addAttribute("error", "Username already exists");
      return "register";
    }
    if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
      model.addAttribute("error", "Salasanat eivät täsmää");
      return "register";
    }
    userService.registerUser(userDto.getUsername(), userDto.getPassword());
    return "redirect:/login";
  }
}

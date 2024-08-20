package com.websites.coffeeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.websites.coffeeshop.model.User;
import com.websites.coffeeshop.service.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
// import java.util.logging.Logger;

@Controller
public class AuthController {

  // private static final Logger logger =
  // Logger.getLogger(AuthController.class.getName());

  @Autowired
  private UserService userService;

  @GetMapping("/login")
  public String login(@RequestParam(value = "error", required = false) String error, Model model) {
    if (error != null) {
      model.addAttribute("errorMessage", "Virheellinen käyttäjänimi tai salasana.");
    }
    return "login";
  }

  @GetMapping("/register")
  public String register(Model model) {
    model.addAttribute("user", new User());
    return "register";
  }

  @PostMapping("/register")
  public String register(@RequestParam String username, @RequestParam String password,
      @RequestParam String confirmPassword, Model model) {
    if (userService.existsByUsername(username)) {
      model.addAttribute("errorMessage", "Käyttäjänimi on jo käytössä.");
      return "register";
    }

    if (!password.equals(confirmPassword)) {
      model.addAttribute("errorMessage", "Salasanat eivät täsmää.");
      return "register";
    }
    userService.registerUser(username, password);
    return "redirect:/login";
  }

  @GetMapping("/user")
  public String user(Model model, Authentication authentication) {
    if (authentication == null || !authentication.isAuthenticated()) {
      model.addAttribute("errorMessage", "Kirjaudu sisään nähdäksesi tämän sivun.");
      return "redirect:/etusivu";
    }
    String username = authentication.getName();
    User user = userService.findByUsername(username);
    model.addAttribute("username", authentication.getName());
    model.addAttribute("user", user);
    return "user";
  }

  @DeleteMapping("/user")
  public String deleteUserAccount(HttpSession session, Authentication authentication) {
    if (authentication == null || !authentication.isAuthenticated()) {
      return "redirect:/login";
    }

    String username = authentication.getName();
    userService.deleteUser(username);

    session.invalidate();
    SecurityContextHolder.clearContext();

    return "redirect:/etusivu";
  }

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/etusivu";
  }

}

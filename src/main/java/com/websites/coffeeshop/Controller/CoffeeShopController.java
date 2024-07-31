package com.websites.coffeeshop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoffeeShopController {
  
  @GetMapping("/home")
  public String homepage() {
    return "hello customer";
  }
}

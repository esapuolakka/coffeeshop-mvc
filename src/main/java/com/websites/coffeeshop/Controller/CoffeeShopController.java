package com.websites.coffeeshop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.websites.coffeeshop.Service.CoffeeShopService;

import org.springframework.ui.Model;

@Controller
public class CoffeeShopController {

  @Autowired
  private CoffeeShopService coffeeShopService;
  
  @GetMapping("/etusivu")
  public String homepage(Model model) {
    return "index";
  }

  @GetMapping("/kahvilaitteet")
  public String kahvilaitteet(Model model) {
    model.addAttribute("items", coffeeShopService.getAllByCategory(1L));
    return "equipment";
  }


  @GetMapping("/kulutustuotteet")
  public String kulutustuotteet(Model model) {
    model.addAttribute("items", coffeeShopService.getAllByCategory(2L));
    return "supplies";
  }


}

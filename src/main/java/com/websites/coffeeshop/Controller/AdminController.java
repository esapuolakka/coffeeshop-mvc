package com.websites.coffeeshop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.websites.coffeeshop.Service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  private AdminService adminService;

  @GetMapping
  public String adminpage(Model model) {
    return "admin";
  }

  @GetMapping("/tuotteet")
  public String getAllItems(@RequestParam(value = "categoryId", defaultValue = "1") Long categoryId, Model model) {
    model.addAttribute("items", adminService.getAllByCategory(categoryId));
    model.addAttribute("selectedCategory", categoryId);
    return "adminItems";
  }

  @GetMapping("/lisaa")
  public String addNewItem(Model model) {
    return "adminAddItem";
  }

  @PostMapping("/lisaa")
  public String addItem(Model model) {
    return "redirect:/adminItems";
  }

}

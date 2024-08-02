package com.websites.coffeeshop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.websites.coffeeshop.Model.Item;
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

  @GetMapping("/tuotteet/{id}")
  public String getMethodName(@PathVariable Long id, Model model) {
    Item item = adminService.getItemById(id);
    Long nextItem = adminService.getNextItemId(id);
    Long previousItem = adminService.getPreviousItemId(id);

    model.addAttribute("item", item);
    model.addAttribute("nextItem", nextItem);
    model.addAttribute("previousItem", previousItem);

    return "adminItemDetails";
  }


  @PostMapping("/tuotteet/{id}/muokkaa")
  public String updateItem(@PathVariable Long id, @ModelAttribute Item updatedItem, Model model) {
    updatedItem.setId(id);
    adminService.updateItem(updatedItem);
    return "redirect:/admin/tuotteet";
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

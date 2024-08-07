package com.websites.coffeeshop.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.websites.coffeeshop.Model.Image;
import com.websites.coffeeshop.Model.Item;
import com.websites.coffeeshop.Model.Manufacturer;
import com.websites.coffeeshop.Service.AdminService;
import com.websites.coffeeshop.Model.Supplier;
import com.websites.coffeeshop.Model.ItemDTO;

@Controller
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  private AdminService adminService;

  @GetMapping
  public String adminHome(Model model) {
    return "admin";
  }

  @GetMapping("/tuotteet")
  public String allItemsList(@RequestParam(value = "categoryId", defaultValue = "1") Long categoryId, Model model) {
    model.addAttribute("items", adminService.getAllByCategory(categoryId));
    model.addAttribute("selectedCategory", categoryId);
    return "adminItems";
  }

  @GetMapping("/tuotteet/{id}")
  public String itemDetailPage(@PathVariable Long id, Model model) {
    Item item = adminService.getItemById(id);
    Long nextItem = adminService.getNextItemId(id);
    Long previousItem = adminService.getPreviousItemId(id);
    List<Manufacturer> manufacturers = adminService.getAllManufacturers();
    List<Supplier> suppliers = adminService.getAllSuppliers();
    List<Image> images = adminService.getAllImages();
    model.addAttribute("item", item);
    model.addAttribute("nextItem", nextItem);
    model.addAttribute("previousItem", previousItem);
    model.addAttribute("manufacturers", manufacturers);
    model.addAttribute("suppliers", suppliers);
    model.addAttribute("images", images);
    return "adminItemDetails";
  }

  @GetMapping("/tuotteet/{id}/kuva")
  public ResponseEntity<byte[]> viewItemImage(@PathVariable Long id) {
    Image image = adminService.getImageById(id);
    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType(image.getMediaType()));
    headers.setContentLength(image.getSize());

    return new ResponseEntity<>(image.getContent(), headers, HttpStatus.OK);
  }

  @PostMapping("/tuotteet/{id}")
  public String updateItem(
      @PathVariable Long id,
      @ModelAttribute ItemDTO itemDTO,
      @RequestParam(value = "image", required = false) MultipartFile file) throws IOException {
    itemDTO.setId(id);
    adminService.updateItem(itemDTO, file);

    return "redirect:/admin/tuotteet/" + id;
  }

  @DeleteMapping("/tuotteet/{id}/poista")
  public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
    adminService.deleteItem(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }



  @GetMapping("/valmistajat")
  public String allManufacturers(Model model) {
    List<Manufacturer> manufacturers = adminService.getAllManufacturers();
    model.addAttribute("manufacturers", manufacturers);
    return "adminManufacturers";
  }

  @GetMapping("/valmistajat/{id}")
  public String manufacturerDetailPage(@PathVariable Long id, Model model) {
    Manufacturer manufacturer = adminService.getManufacturerById(id);
    List<Item> manufacturerItems = adminService.getItemsByManufacturer(id);
    model.addAttribute("manufacturer", manufacturer);
    model.addAttribute("manufacturerItems", manufacturerItems);
    return "adminManufacturerDetails";
  }

  @PostMapping("/valmistajat/{id}")
  public String updateManufacturer(@PathVariable Long id, @ModelAttribute Manufacturer manufacturer) {
    manufacturer.setId(id);
    adminService.updateManufacturer(manufacturer);
    return "redirect:/admin/valmistajat/" + id;
  }


  @GetMapping("/toimittajat")
  public String allSuppliers(Model model) {
    List<Supplier> suppliers = adminService.getAllSuppliers();
    model.addAttribute("suppliers", suppliers);
    return "adminSuppliers";
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

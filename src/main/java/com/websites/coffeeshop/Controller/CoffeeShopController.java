package com.websites.coffeeshop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import java.util.List;

import com.websites.coffeeshop.Model.Image;
import com.websites.coffeeshop.Model.ItemWithImageUrl;
import com.websites.coffeeshop.Service.CoffeeShopService;

@Controller
public class CoffeeShopController {

  @Autowired
  private CoffeeShopService coffeeShopService;
  
  @GetMapping("/etusivu")
  public String homepage(Model model) {
    return "index";
  }

  @GetMapping("/tuotteet")
  public String redirect() {
    return "redirect:/tuotteet/kahvilaitteet";
  } 

  @GetMapping("/tuotteet/{tuotekategoria}")
  public String itemsPage(@PathVariable String tuotekategoria, Model model) {
    Long categoryId = tuotekategoria.equals("kahvilaitteet") ? 1L : 2L;
    List<ItemWithImageUrl> itemsWithImageUrls = coffeeShopService.getAllItemsWithImageUrls(categoryId);
    model.addAttribute("itemsWithImageUrls", itemsWithImageUrls);
    return "itemsList";
  }

  @GetMapping("/tuotteet/{tuotekategoria}/{id}")
  public String equipmentDetailPage(@PathVariable String tuotekategoria, @PathVariable Long id, Model model) {
    model.addAttribute("item", coffeeShopService.getItemById(id));
    return "itemDetails";
}

  @GetMapping("/tuotteet/{tuotekategoria}/{id}/kuva")
  public ResponseEntity<byte[]> equipmentDetailImage(@PathVariable String tuotekategoria, @PathVariable Long id) {
    Image image = coffeeShopService.getImageById(id);
    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType(image.getMediaType()));
    headers.setContentLength(image.getSize());

    return new ResponseEntity<>(image.getContent(), headers, HttpStatus.OK);
  }
}

package com.websites.coffeeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.math.BigDecimal;

import com.websites.coffeeshop.model.Cart;
import com.websites.coffeeshop.model.CartItem;
import com.websites.coffeeshop.model.Image;
import com.websites.coffeeshop.model.Item;
import com.websites.coffeeshop.model.ItemWithImageUrl;
import com.websites.coffeeshop.service.CoffeeShopService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CoffeeShopController {

  private static final Logger logger = Logger.getLogger(CoffeeShopController.class.getName());

  @Autowired
  private CoffeeShopService coffeeShopService;

  @GetMapping("/")
  public String redirectHome() {
    return "redirect:/etusivu";
  }

  @GetMapping("/etusivu")
  public String homepage(Model model) {
    return "index";
  }

  @GetMapping("/tuotteet")
  public String redirect() {
    return "redirect:/tuotteet/kahvilaitteet";
  }

  @GetMapping("/tuotteet/{tuotekategoria}")
  public String itemsPage(@PathVariable("tuotekategoria") String categoryName,
      @RequestParam(value = "name", required = false) String name,
      @RequestParam(defaultValue = "0") Optional<Integer> page,
      Model model) {
    Long categoryId = categoryName.equals("kahvilaitteet") ? 1L : 2L;

    Page<ItemWithImageUrl> pageItems;

    int currentPage = page.orElse(0);
    int pageSize = 18;

    if (name != null) {
      pageItems = coffeeShopService.searchItemsWithImageUrls(categoryId, name,
          PageRequest.of(currentPage, pageSize));
    } else {
      pageItems = coffeeShopService.getAllItemsWithImageUrls(categoryId,
          PageRequest.of(currentPage, pageSize));
    }

    int totalPages = pageItems.getTotalPages();

    if (totalPages > 0) {
      List<Integer> pageNumbers = IntStream.range(0, totalPages).boxed()
          .toList();
      model.addAttribute("pageNumbers", pageNumbers);
    }
    model.addAttribute("page", pageItems);
    model.addAttribute("itemsWithImageUrls", pageItems.getContent());
    return "itemsList";
  }

  // @GetMapping("/tuotteet/page/{tuotekategoria}")
  // public ResponseEntity<List<ItemWithImageUrl>>
  // showMoreItems(@PathVariable("tuotekategoria") String categoryName,
  // @RequestParam(value = "name", required = false) String name,
  // @RequestParam(defaultValue = "0") int page,
  // @RequestParam(defaultValue = "18") int size) {
  // Long categoryId = categoryName.equals("kahvilaitteet") ? 1L : 2L;
  // List<ItemWithImageUrl> itemsWithImageUrls;

  // if (name != null) {
  // itemsWithImageUrls = coffeeShopService.searchItemsWithImageUrls(categoryId,
  // name, PageRequest.of(page, size));
  // } else {
  // itemsWithImageUrls = coffeeShopService.getAllItemsWithImageUrls(categoryId,
  // PageRequest.of(page, size));
  // }
  // return ResponseEntity.ok(itemsWithImageUrls);
  // }

  @GetMapping("/tuotteet/{tuotekategoria}/{id}")
  public String itemDetailPage(@PathVariable String tuotekategoria, @PathVariable Long id, Model model) {

    Item item = coffeeShopService.getItemById(id);
    BigDecimal price = item.getPrice();
    BigDecimal discountedPrice = BigDecimal.ZERO;

    if (price != null) {
      discountedPrice = BigDecimal.valueOf(coffeeShopService.getDiscountedPrice(price));
    }

    model.addAttribute("item", coffeeShopService.getItemById(id));
    model.addAttribute("discountedPrice", discountedPrice);
    return "itemDetails";
  }

  @GetMapping("/tuotteet/{tuotekategoria}/{id}/kuva")
  public ResponseEntity<byte[]> itemDetailImage(@PathVariable Long id) {
    Image image = coffeeShopService.getImageById(id);
    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType(image.getMediaType()));
    headers.setContentLength(image.getSize());
    return new ResponseEntity<>(image.getContent(), headers, HttpStatus.OK);
  }

  @GetMapping("/ostoskori")
  public String shoppingCart(Model model, HttpSession session) {
    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null) {
      cart = new Cart();
      session.setAttribute("cart", cart);
    }

    List<CartItem> cartItems = cart.getItems();
    cartItems.forEach(cartItem -> {
      BigDecimal originalPrice = cartItem.getPrice();
      double discountedPrice = coffeeShopService.getDiscountedPrice(originalPrice);
      cartItem.setDiscountedPrice(discountedPrice);
    });

    BigDecimal totalPrice = cartItems.stream()
        .map(cartItem -> cartItem.getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity())))
        .reduce(BigDecimal.ZERO, BigDecimal::add);

    BigDecimal totalPriceVIP = cartItems.stream()
        .map(cartItem -> BigDecimal.valueOf(cartItem.getDiscountedPrice())
            .multiply(BigDecimal.valueOf(cartItem.getQuantity())))
        .reduce(BigDecimal.ZERO, BigDecimal::add);

    session.setAttribute("totalPrice", totalPrice);
    session.setAttribute("totalPriceVIP", totalPriceVIP);

    model.addAttribute("cart", cart);
    model.addAttribute("cartItems", cartItems);
    model.addAttribute("totalPrice", session.getAttribute("totalPrice"));
    model.addAttribute("totalPriceVIP", session.getAttribute("totalPriceVIP"));
    return "shoppingCart";
  }

  @PostMapping("/ostoskori/lisaa")
  public String addToCart(@RequestParam("productId") Long productId, HttpSession session) {
    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null) {
      cart = new Cart();
      session.setAttribute("cart", cart);
    }
    String itemName = coffeeShopService.getItemById(productId).getName();
    BigDecimal itemPrice = coffeeShopService.getItemById(productId).getPrice();
    double discountedPrice = coffeeShopService.getDiscountedPrice(itemPrice);

    cart.addItem(productId, itemName, itemPrice, discountedPrice, 1);

    double discount = coffeeShopService.getDiscount().getDiscount();

    BigDecimal totalPrice = cart.getTotalPrice(BigDecimal.ZERO, false);
    BigDecimal totalPriceVIP = cart.getTotalPrice(BigDecimal.valueOf(discount), true);

    session.setAttribute("totalPrice", totalPrice);
    session.setAttribute("totalPriceVIP", totalPriceVIP);

    return "redirect:/tuotteet";
  }

  @GetMapping("/ostoskori/poista")
  public String removeFromCart(@RequestParam("productId") Long productId, HttpSession session) {
    Cart cart = (Cart) session.getAttribute("cart");
    if (cart != null) {
      cart.removeItem(productId);

      double discount = coffeeShopService.getDiscount().getDiscount();

      BigDecimal totalPrice = cart.getTotalPrice(BigDecimal.ZERO, false);
      BigDecimal totalPriceVIP = cart.getTotalPrice(BigDecimal.valueOf(discount), true);

      session.setAttribute("totalPrice", totalPrice);
      session.setAttribute("totalPriceVIP", totalPriceVIP);
    }
    return "redirect:/ostoskori";
  }

}

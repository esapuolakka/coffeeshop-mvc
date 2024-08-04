package com.websites.coffeeshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.websites.coffeeshop.Model.Item;
import com.websites.coffeeshop.Model.Manufacturer;
import com.websites.coffeeshop.Model.Supplier;
import com.websites.coffeeshop.Repository.CategoryRepository;
import com.websites.coffeeshop.Repository.ItemRepository;
import com.websites.coffeeshop.Repository.ManufacturerRepository;
import com.websites.coffeeshop.Repository.SupplierRepository;

@Service
public class AdminService {

  // private static final Logger logger = LoggerFactory.getLogger(AdminService.class);


  @Autowired
  private ItemRepository itemRepository;
  @Autowired
  private SupplierRepository supplierRepository;
  @Autowired
  private CategoryRepository categoryRepository;
  @Autowired
  private ManufacturerRepository manufacturerRepository;

  public List<Item> getAllItems() {
    return itemRepository.findAll();
  }

  public List<Item> getAllByCategory(Long categoryId) {
    return itemRepository.findByCategoryId(categoryId);
  }

  public Item getItemById(Long id) {
    return itemRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Item not found"));
  }

  public Long getNextItemId(Long id) {
    Optional<Item> nextItem = itemRepository.findNextItem(id);
    return nextItem.map(Item::getId).orElse(null);
  }

  public Long getPreviousItemId(Long id) {
    Optional<Item> previousItem = itemRepository.findPreviousItem(id);
    return previousItem.map(Item::getId).orElse(null);
  }



  public Item updateItem(Item updatedItem) {

    // logger.debug("Updated item: " + updatedItem);

    System.out.println("Updated item: " + updatedItem);

    Item existingItem = itemRepository.findById(updatedItem.getId())
        .orElseThrow(() -> new RuntimeException("Item not found"));

    // Tarkistaa onko kentät tyhjiä
    if (updatedItem.getName() == null || updatedItem.getName().isEmpty() ||
        updatedItem.getDescription() == null || updatedItem.getDescription().isEmpty() ||
        updatedItem.getPrice() == null || updatedItem.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
      throw new RuntimeException("No empty fields allowed");
    }

    if (updatedItem.getManufacturer() == null) {
      throw new IllegalArgumentException("Manufacturer cannot be null");
    }

    if (updatedItem.getSupplier() == null) {
      throw new IllegalArgumentException("Supplier cannot be null");
    }

    Manufacturer manufacturer = manufacturerRepository.findById(updatedItem.getManufacturer().getId())
        .orElseThrow(() -> new RuntimeException("Manufacturer not found"));

    Supplier supplier = supplierRepository.findById(updatedItem.getSupplier().getId())
        .orElseThrow(() -> new RuntimeException("Supplier not found"));

    // Takistaa onko muutoksia tehty. Mikäli ei, ei päivitetä
    if (existingItem.getName().equals(updatedItem.getName()) &&
        existingItem.getDescription().equals(updatedItem.getDescription()) &&
        existingItem.getPrice().equals(updatedItem.getPrice()) &&
        existingItem.getManufacturer().getId().equals(manufacturer.getId()) &&
        existingItem.getSupplier().getId().equals(supplier.getId())) {
      return existingItem;
    }

    // päivittää tiedot
    existingItem.setName(updatedItem.getName());
    existingItem.setDescription(updatedItem.getDescription());
    existingItem.setPrice(updatedItem.getPrice());
    existingItem.setManufacturer(manufacturer);
    existingItem.setSupplier(supplier);

    return itemRepository.save(existingItem);
  }


  // Hae kaikki valmistajat ja toimittajat
  public List<Manufacturer> getAllManufacturers() {
    return manufacturerRepository.findAll();
  }

  public List<Supplier> getAllSuppliers() {
    return supplierRepository.findAll();
  }
}

package com.websites.coffeeshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.io.IOException;

import com.websites.coffeeshop.Model.Image;
import com.websites.coffeeshop.Model.Item;
import com.websites.coffeeshop.Model.ItemDTO;
import com.websites.coffeeshop.Model.Manufacturer;
import com.websites.coffeeshop.Model.Supplier;
import com.websites.coffeeshop.Repository.ImageRepository;
import com.websites.coffeeshop.Repository.ItemRepository;
import com.websites.coffeeshop.Repository.ManufacturerRepository;
import com.websites.coffeeshop.Repository.SupplierRepository;

@Service
public class AdminService {

  @Autowired
  private ItemRepository itemRepository;
  @Autowired
  private SupplierRepository supplierRepository;
  @Autowired
  private ManufacturerRepository manufacturerRepository;
  @Autowired
  private ImageRepository imageRepository;

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

  @Transactional
  public Item updateItem(ItemDTO updatedItem, MultipartFile file) {

    Item existingItem = itemRepository.findById(updatedItem.getId())
        .orElseThrow(() -> new RuntimeException("Item not found"));

    // Tarkistaa onko kentät tyhjiä
    validateItem(updatedItem);

    Manufacturer manufacturer = manufacturerRepository.findById(updatedItem.getManufacturer().getId())
        .orElseThrow(() -> new RuntimeException("Manufacturer not found"));

    Supplier supplier = supplierRepository.findById(updatedItem.getSupplier().getId())
        .orElseThrow(() -> new RuntimeException("Supplier not found"));

    // Takistaa onko muutoksia tehty. Mikäli ei, ei päivitetä
    boolean isImageUpdated = file != null && !file.isEmpty();

    if (existingItem.getName().equals(updatedItem.getName()) &&
        existingItem.getDescription().equals(updatedItem.getDescription()) &&
        existingItem.getPrice().equals(updatedItem.getPrice()) &&
        existingItem.getManufacturer().getId().equals(manufacturer.getId()) &&
        existingItem.getSupplier().getId().equals(supplier.getId()) &&
        !isImageUpdated) {
      return existingItem;
    }

    if (existingItem.getImage() != null) {
      imageRepository.delete(existingItem.getImage());
    }

    if (file != null && !file.isEmpty()) {
      Image newImage = createImageFromFile(file);
      existingItem.setImage(newImage);
    }

    existingItem.setName(updatedItem.getName());
    existingItem.setDescription(updatedItem.getDescription());
    existingItem.setPrice(updatedItem.getPrice());
    existingItem.setManufacturer(manufacturer);
    existingItem.setSupplier(supplier);

    return itemRepository.save(existingItem);
  }

  private void validateItem(ItemDTO updatedItem) {

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
  }

  private Image createImageFromFile(MultipartFile file) {

    // Kuvan tulee olla PNG ja koko alle 1MB
    if (!"image/png".equals(file.getContentType()))
      throw new IllegalArgumentException("Only PNG images are allowed");

    if (file.getSize() > 1024 * 1024)
      throw new IllegalArgumentException("Image size must be less than 1MB");

    try {
      Image newImage = new Image();
      newImage.setName(file.getOriginalFilename());
      newImage.setMediaType(file.getContentType());
      newImage.setSize(file.getSize());
      newImage.setContent(file.getBytes());
      return newImage;
    } catch (IOException e) {
      throw new RuntimeException("Failed to store image", e);
    }
  }

  public Image getImageById(Long id) {
    return imageRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Image not found"));
  }

  public List<Manufacturer> getAllManufacturers() {
    return manufacturerRepository.findAll();
  }

  public Manufacturer getManufacturerById(Long id) {
    return manufacturerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Manufacturer not found"));
  }

  public Manufacturer updateManufacturer(Manufacturer manufacturer) {
    Manufacturer existingManufacturer = manufacturerRepository.findById(manufacturer.getId())
      .orElseThrow(() -> new RuntimeException("Manufacturer not found"));

      if (manufacturer.getName() == null || manufacturer.getName().isEmpty()) {
        throw new IllegalArgumentException("Name cannot be empty");
      }

      if (manufacturer.getUrl() == null || manufacturer.getUrl().isEmpty()) {
        throw new IllegalArgumentException("URL cannot be empty");
      }

      if (existingManufacturer.getName().equals(manufacturer.getName()) &&
          existingManufacturer.getUrl().equals(manufacturer.getUrl())) {
        return existingManufacturer;
      }

      return manufacturerRepository.save(manufacturer);
  }

  public List<Item> getItemsByManufacturer(Long id) {
    return itemRepository.findByManufacturerId(id);
  }

  public List<Supplier> getAllSuppliers() {
    return supplierRepository.findAll();
  }

  public List<Image> getAllImages() {
    return imageRepository.findAll();
  }

  public void deleteItem(Long id) {
    if (itemRepository.existsById(id)) {
      itemRepository.deleteById(id);
    } else {
      throw new RuntimeException("Item not found with id: " + id);
    }
  }

}

package com.websites.coffeeshop.model;


public class UserDTO {
  private String username;
  private String password;
  private String confirmPassword;
  private boolean isLoggedIn = false;
  private String message;

  public UserDTO() {
  }

  public UserDTO(String username, String password, String confirmPassword, boolean isLoggedIn, String message) {
    this.username = username;
    this.password = password;
    this.confirmPassword = confirmPassword;
    this.isLoggedIn = isLoggedIn;
    this.message = message;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public boolean isLoggedIn() {
    return isLoggedIn;
  }

  public void setLoggedIn(boolean isLoggedIn) {
    this.isLoggedIn = isLoggedIn;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}

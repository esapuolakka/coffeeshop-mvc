package com.websites.coffeeshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
  private String username;
  private String password;
  private String confirmPassword;
  private boolean isLoggedIn = false;
  private String message;
}

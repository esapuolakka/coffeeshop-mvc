package com.websites.coffeeshop.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Passwordganerator manuaalista kryptatun salasanan luomista varten
public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "";
        String encodedPassword = passwordEncoder.encode(rawPassword);
        
        // System.out.println("Salattu salasana: " + encodedPassword);
    }
}


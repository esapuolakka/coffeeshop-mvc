package com.websites.coffeeshop.security;

import com.websites.coffeeshop.repository.UserRepository;
import com.websites.coffeeshop.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        String userName = user.getUsername();
        String password = user.getPassword();
        String[] roles = user.getRoles().stream()
                .map(role -> role.getName())
                .toArray(String[]::new);

        return org.springframework.security.core.userdetails.User
                .withUsername(userName)
                .password(password)
                .authorities(roles)
                .build();
    }
}

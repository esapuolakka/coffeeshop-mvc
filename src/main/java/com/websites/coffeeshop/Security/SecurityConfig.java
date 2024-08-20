package com.websites.coffeeshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**")
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
            .headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions.sameOrigin()))
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.DELETE, "/user").hasAnyRole("USER", "VIP", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/user").hasAnyRole("USER", "VIP", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/admin/kayttajat").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                .requestMatchers("/user").hasAnyRole("USER", "ADMIN", "VIP")
                .requestMatchers("/login/**").permitAll()
                .requestMatchers("/register/**").permitAll()
                .requestMatchers("/etusivu").permitAll()
                .requestMatchers("/tuotteet/**").permitAll()
                .requestMatchers("/tuotteet/*/haku").permitAll()
                .requestMatchers("/ostoskori/**").permitAll()
                .requestMatchers("/images/**").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated())
            .rememberMe(rememberMe -> rememberMe
                .tokenValiditySeconds(86400)  // Muista käyttäjä 1 päivän ajan
                .key("mySecretKey"))
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/user", true)
                .permitAll())
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/etusivu")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID"));
        return http.build();
    }
}

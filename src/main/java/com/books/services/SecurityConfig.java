package com.books.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	private final MyUserLoginService userdetails;

	public SecurityConfig(MyUserLoginService userdetails) {

		this.userdetails = userdetails;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public SecurityFilterChain securityFilterChannel(HttpSecurity http) throws Exception {
		// http.formLogin();

		http.userDetailsService(userdetails)
				.authorizeHttpRequests(auth -> auth.requestMatchers("/api/**").authenticated()).httpBasic();

		return http.build();

	}

}
package com.books.services;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	private final MyUserLoginService userdetails;

	public SecurityConfig(MyUserLoginService userdetails) {

		this.userdetails = userdetails;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		// return new Argon2PasswordEncoder(10, 10, 0, 50, 10);
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider d = new DaoAuthenticationProvider();
		d.setPasswordEncoder(passwordEncoder());
		d.setUserDetailsService(userdetails);
		return d;
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		// configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(Arrays.asList("Accept", "Access-Control-Allow-Headers",
				"Access-Control-Allow-Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers",
				"Origin", "Cache-Control", "Content-Type", "Authorization"));
		configuration.setAllowedMethods(Arrays.asList("DELETE", "GET", "POST", "PATCH", "PUT"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Bean
	public SecurityFilterChain securityFilterChannel(HttpSecurity http) throws Exception {
		// http.formLogin();
		http.cors().and().csrf().disable().authorizeHttpRequests().requestMatchers("/api/user/register").permitAll()
				.anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// http.userDetailsService(userdetails);
		http.authenticationProvider(authenticationProvider());
//	http.authorizeRequests().requestMatchers("/api/user/insert").anonymous().anyRequest().authenticated()
		http.httpBasic();
		return http.build();

	}

}
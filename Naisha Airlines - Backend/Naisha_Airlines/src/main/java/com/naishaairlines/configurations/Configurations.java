package com.naishaairlines.configurations;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.naishaairlines.utilities.JwtTokenGenerator;
import com.naishaairlines.utilities.JwtTokenValidator;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class Configurations {

    @Bean
    SecurityFilterChain configuration(HttpSecurity http) throws Exception {

		http.sessionManagement(se -> se.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).cors(cors -> {
			cors.configurationSource(new org.springframework.web.cors.CorsConfigurationSource() {

				@Override
				public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
					CorsConfiguration configuration = new CorsConfiguration();
					configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
					configuration.setAllowedMethods(Collections.singletonList("*"));
					configuration.setAllowCredentials(true);
					configuration.setAllowedHeaders(Collections.singletonList("*"));
					configuration.setExposedHeaders(Arrays.asList("Authorization"));
					return configuration;
				}
			});
		}).authorizeHttpRequests(auth -> auth
				.requestMatchers(HttpMethod.POST, "/users/", "/admin/").permitAll()
				.requestMatchers("/swagger-ui*/**", "/v3/api-docs/**").permitAll()
				.requestMatchers("/passengers/**").hasRole("PASSENGER")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()).csrf(csrf -> csrf.disable())
				.addFilterAfter(new JwtTokenGenerator(), BasicAuthenticationFilter.class)
				.addFilterBefore(new JwtTokenValidator(), BasicAuthenticationFilter.class)
				.httpBasic(Customizer.withDefaults());

		return http.build();
	}


    @Bean
    PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

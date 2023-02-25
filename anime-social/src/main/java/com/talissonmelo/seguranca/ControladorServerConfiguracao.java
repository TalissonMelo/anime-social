package com.talissonmelo.seguranca;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class ControladorServerConfiguracao {

	@Bean
    SecurityFilterChain resourceServerFilterChain(HttpSecurity http) throws Exception {
		 http.formLogin(Customizer.withDefaults())
         .csrf().disable()
         .cors().and()
         .oauth2ResourceServer().opaqueToken();
     return http.build();
    }
}

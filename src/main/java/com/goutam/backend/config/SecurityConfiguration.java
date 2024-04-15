package com.goutam.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

//        http.securityContext(c -> c.requireExplicitSave(false))
        http.securityContext(context -> context.requireExplicitSave(false))
                .authorizeHttpRequests(req-> req
                        .antMatchers("/user/register").permitAll()
                        .antMatchers("/other").hasRole("OTHER")
                        .antMatchers("/useradmin").hasAnyRole("USER","ADMIN")
                        .antMatchers("/myLoans").hasRole("USER")
                        .antMatchers("/myCards").hasRole("USER")
                )
                .csrf().disable()
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

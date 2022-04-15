package com.company.customids.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AuthenticationConfiguration {
    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
                .username(applicationProperties.getUsers().getAdmin().getUsername())
                .password(applicationProperties.getUsers().getAdmin().getPassword())
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}

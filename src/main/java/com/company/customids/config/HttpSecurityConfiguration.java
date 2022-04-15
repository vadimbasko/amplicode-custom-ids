package com.company.customids.config;

import com.amplicode.core.graphql.security.GraphQlAuthenticationEntryPoint;
import com.amplicode.core.graphql.security.GraphQlAuthenticationFailureHandler;
import com.amplicode.core.graphql.security.GraphQlAuthenticationSuccessHandler;
import com.amplicode.core.graphql.security.GraphQlLogoutSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class HttpSecurityConfiguration {

    @Bean
    public AuthenticationSuccessHandler graphQlAuthenticationSuccessHandler() {
        return new GraphQlAuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler graphQlAuthenticationFailureHandler() {
        return new GraphQlAuthenticationFailureHandler();
    }

    @Bean
    public GraphQlLogoutSuccessHandler graphQlLogoutSuccessHandler() {
        return new GraphQlLogoutSuccessHandler();
    }

    @Bean
    public AuthenticationEntryPoint graphQlAuthenticationEntryPoint() {
        return new GraphQlAuthenticationEntryPoint();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.formLogin(withFormLoginDefaults())
                .exceptionHandling(withExceptionHandlingDefaults())
                .authorizeRequests(withAuthorizationRequestsDefaults())
                .cors(withDefaults())
                .csrf(withCsrfDefaults())
                .build();
    }

    protected Customizer<FormLoginConfigurer<HttpSecurity>> withFormLoginDefaults() {
        return formLogin -> formLogin.successHandler(graphQlAuthenticationSuccessHandler())
                .failureHandler(graphQlAuthenticationFailureHandler())
                .permitAll();
    }

    protected Customizer<ExceptionHandlingConfigurer<HttpSecurity>> withExceptionHandlingDefaults() {
        return exceptionHandling -> exceptionHandling.authenticationEntryPoint(graphQlAuthenticationEntryPoint());
    }

    private Customizer<ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry> withAuthorizationRequestsDefaults() {
        return authorization -> authorization.antMatchers("/graphql").permitAll()
                .antMatchers("/graphql/**").permitAll();
    }

    protected Customizer<CsrfConfigurer<HttpSecurity>> withCsrfDefaults() {
        return AbstractHttpConfigurer::disable;
    }
}

package com.company.customids.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.util.StringUtils.trimLeadingCharacter;
import static org.springframework.util.StringUtils.trimTrailingCharacter;

@Configuration
public class MvcConfiguration {
    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    public WebMvcConfigurer mvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                String publicUrl = normalizeUrl(applicationProperties.getFrontend().getPublicUrl());
                registry.addViewController("/" + publicUrl).setViewName("forward:/" + publicUrl + "/index.html");
            }

            private String normalizeUrl(String url) {
                return trimTrailingCharacter(trimLeadingCharacter(url, '/'), '/');
            }
        };
    }
}

package com.company.customids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CustomIdsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomIdsApplication.class, args);
    }
}

package com.manba.security.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.manba.security"})
public class SecurityWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityWebApplication.class, args);
    }

}

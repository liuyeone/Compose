package com.example.allservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class AllserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllserviceApplication.class, args);
    }

}

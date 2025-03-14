package com.digisol.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DigisolAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigisolAssignmentApplication.class, args);
    }

}

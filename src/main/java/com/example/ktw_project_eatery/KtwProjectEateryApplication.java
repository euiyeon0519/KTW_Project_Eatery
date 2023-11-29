package com.example.ktw_project_eatery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KtwProjectEateryApplication {

    public static void main(String[] args) {

        SpringApplication.run(KtwProjectEateryApplication.class, args);
    }

}

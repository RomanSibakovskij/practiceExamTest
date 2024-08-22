package com.spring.calculator;

import com.spring.calculator.model.Role;
import com.spring.calculator.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// @SpringBootApplication anotacija yra lygi @Configuration, @EnableAutoConfiguration ir @ComponentScan
// Nurodoma klasėje, turinčioje pagrindinį (main) metodą
@SpringBootApplication
public class CalculatorApplication {

    public static void main(String[] args) {
        // Programos kontrolė deleguojama statiniam klasės SpringApplication metodui run,
        // nurodant aplikacijos šakninį komponentą. Spring karkasas paleis aplikaciją,
        // t.y. startuos serverį su numatytaisiais parametrais.
        SpringApplication.run(CalculatorApplication.class, args);
    }

    @Bean
    public CommandLineRunner createRoles(RoleRepository roleRepo){
        return args -> {
            roleRepo.findByName("admin").orElseGet(()->roleRepo.save(new Role("admin")));
            roleRepo.findByName("user").orElseGet(()->roleRepo.save(new Role("user")));
        };
    }

}

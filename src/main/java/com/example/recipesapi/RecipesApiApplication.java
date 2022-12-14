package com.example.recipesapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class RecipesApiApplication {

   // dopuni
    // u recipe kontroleru za dodavanje recepta dodaj kod koji pretvara weighted ingredient dto u weighted in


    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(RecipesApiApplication.class, args);
    }

    // /recipes - GET
    // /recipes - POST
    // /recipes/id - PUT
    // /recipes/id - GET
    // /recipes/id - DELETE
    // /recipes/id/weighted-ingredients - POST
    // /recipes/id/weighted-ingredients - GET
    // /weighted-ingredients/id - PUT
    // /weighted-ingredients/id - GET
    // /weighted-ingredients/id - DELETE




}

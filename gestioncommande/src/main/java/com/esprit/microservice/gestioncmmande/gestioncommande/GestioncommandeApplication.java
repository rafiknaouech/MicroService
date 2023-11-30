package com.esprit.microservice.gestioncmmande.gestioncommande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class GestioncommandeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestioncommandeApplication.class, args);
    }
    @Autowired
    private Commanderep repository;

    @Bean
    ApplicationRunner init() {
        return (args) -> {
            repository.save(new Commande( 26, 20, "en cours", "2000-01-08"));
            repository.save(new Commande( 26, 100, "en cours", "2000-01-08"));
            repository.save(new Commande( 26, 489, "en cours", "2000-01-08"));

            repository.findAll().forEach(System.out::println);
        };
    }
}



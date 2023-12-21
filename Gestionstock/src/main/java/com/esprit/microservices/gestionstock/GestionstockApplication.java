package com.esprit.microservices.gestionstock;

import com.esprit.microservices.gestionstock.Entity.StockItem;
import com.esprit.microservices.gestionstock.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@EnableDiscoveryClient
@SpringBootApplication

public class GestionstockApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionstockApplication.class, args);
    }
    @Autowired
    private StockRepository stockItemRepository;

    @Bean
    ApplicationRunner init() {
        return (args) -> {
            stockItemRepository.save(new StockItem("Tomate", 100, 10, 1.5));
            stockItemRepository.save(new StockItem("Fromage", 50, 5, 2.0));
            stockItemRepository.save(new StockItem("Pain", 200, 20, 0.5));

            stockItemRepository.findAll().forEach(System.out::println);
        };
    }
}



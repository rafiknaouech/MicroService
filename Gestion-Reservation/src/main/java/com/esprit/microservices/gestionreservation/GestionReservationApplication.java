package com.esprit.microservices.gestionreservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;


@SpringBootApplication


public class GestionReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionReservationApplication.class, args);
	}

	@Autowired
	private ReservationRepository repository;

	public GestionReservationApplication(ReservationRepository repository) {
		this.repository = repository;
	}

	@Bean
  ApplicationRunner init() {
	  return (args) -> {
		  repository.save(new Reservation("sarra", "hg", "ht@e.tn","hg"));
		  repository.save(new Reservation("65", "y", "h@e.tn","ft"));
		  repository.save(new Reservation("g", "g", "mlt@e.tn","rf"));

		  repository.findAll().forEach(System.out::println);
	  };

  }
}
package com.esprit.microservices.gestionreservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication

@EnableDiscoveryClient
public class GestionReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionReservationApplication.class, args);
	}

	@Autowired
	private ReservationRepository repository;

	public GestionReservationApplication(ReservationRepository repository) {
		this.repository = repository;
	}


}
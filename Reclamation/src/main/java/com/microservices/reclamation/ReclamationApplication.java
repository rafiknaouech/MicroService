package com.microservices.reclamation;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import com.microservices.reclamation.entity.Reclamation;
import com.microservices.reclamation.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@EnableDiscoveryClient
@SpringBootApplication


public class ReclamationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReclamationApplication.class, args);
	}

	@Autowired
	private ReclamationRepository repository;

	@Bean
	ApplicationRunner init()
	{
		return (args)-> {
			//save
			repository.save(new Reclamation("good"));
			//fetch
			repository.findAll().forEach(reclamation -> System.out.println(reclamation));
		};
	}



}



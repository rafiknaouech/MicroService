package tn.esprit.authentification1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication(scanBasePackages = "tn.esprit.authentification1")
@EnableDiscoveryClient
public class Authentification1Application {

    public static void main(String[] args) {
        SpringApplication.run(Authentification1Application.class, args);
    }

}

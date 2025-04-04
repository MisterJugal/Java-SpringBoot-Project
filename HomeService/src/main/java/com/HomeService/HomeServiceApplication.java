package com.HomeService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HomeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeServiceApplication.class, args);
	}

}

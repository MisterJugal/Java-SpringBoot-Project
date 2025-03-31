package com.SchoolDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SchoolDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolDetailsApplication.class, args);
	}

}

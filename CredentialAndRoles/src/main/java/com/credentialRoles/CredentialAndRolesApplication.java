package com.credentialRoles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CredentialAndRolesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CredentialAndRolesApplication.class, args);
	}

}

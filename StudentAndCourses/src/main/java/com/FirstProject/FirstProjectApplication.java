package com.FirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.FirstProject.Repositories")
@EnableDiscoveryClient
@EnableFeignClients
public class FirstProjectApplication {
	

	@Autowired
	private Environment env;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

	public static void main(String[] args) {
		 ConfigurableApplicationContext context =SpringApplication.run(FirstProjectApplication.class, args);

		
		FirstProjectApplication app = context.getBean(FirstProjectApplication.class);
        app.getEnvProperty();
		
	
	}

	private void getEnvProperty(){
		System.out.println("Username : "+env.getProperty("spring.datasource.username"));
		System.out.println("Password : "+env.getProperty("spring.datasource.password"));
		System.out.println(env.getActiveProfiles());
	}

}

package cn.edu.nuaa.microservice.todofrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class TodoFrontendApplication {

	private static final Logger log = LoggerFactory.getLogger(TodoFrontendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodoFrontendApplication.class, args);
	}

}

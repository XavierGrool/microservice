package cn.edu.nuaa.microservice.todofrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TodoFrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoFrontendApplication.class, args);
	}

}

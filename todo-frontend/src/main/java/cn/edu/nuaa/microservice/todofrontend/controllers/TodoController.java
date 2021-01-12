package cn.edu.nuaa.microservice.todofrontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.ui.Model;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

import cn.edu.nuaa.microservice.todofrontend.model.Todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpMethod;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@Controller
public class TodoController implements WebMvcConfigurer {

	Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

	@Autowired
	private DiscoveryClient discoveryClient;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@GetMapping("/todo")
	public String showTodo(RestTemplate restTemplate, Model model, Todo todo) {
		ServiceInstance s = this.discoveryClient.getInstances("gateway-client").get(0);
        Todo[] todos = restTemplate.getForObject(s.getUri() + "/todo-backend/all", Todo[].class);
		model.addAttribute("todos", todos);
		return "todo";
	}

	@PostMapping("/add")
	public String addTodo(RestTemplate restTemplate, Model model, Todo todo) {

		ServiceInstance s = this.discoveryClient.getInstances("gateway-client").get(0);
		String url = s.getUri() + "/todo-backend/add";
		LinkedMultiValueMap body = new LinkedMultiValueMap();
        body.add("user_id", 1);
		body.add("content", todo.getContent());
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity httpEntity = new HttpEntity(body, headers);
		restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);

        Todo[] todos = restTemplate.getForObject(s.getUri() + "/todo-backend/all", Todo[].class);
		model.addAttribute("todos", todos);
		return "todo";
	}

	@PostMapping("/delete")
	public String deleteTodo(RestTemplate restTemplate, Model model, Todo todo) {
		ServiceInstance s = this.discoveryClient.getInstances("gateway-client").get(0);
		// String url = s.getUri() + "/todo-backend/delete";
		// LinkedMultiValueMap body = new LinkedMultiValueMap();
		// body.add("id", todo.getId());
		// HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// HttpEntity httpEntity = new HttpEntity(body, headers);
		// restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, String.class);

		logger.info("delete delete delete!!!");

        Todo[] todos = restTemplate.getForObject(s.getUri() + "/todo-backend/all", Todo[].class);
		model.addAttribute("todos", todos);
		return "todo";
	}

	@PostMapping("/tick")
	public String tickTodo(RestTemplate restTemplate, Model model, Todo todo) {
		ServiceInstance s = this.discoveryClient.getInstances("gateway-client").get(0);
		// String url = s.getUri() + "/todo-backend/delete";
		// LinkedMultiValueMap body = new LinkedMultiValueMap();
		// body.add("id", todo.getId());
		// HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// HttpEntity httpEntity = new HttpEntity(body, headers);
		// restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, String.class);

		logger.info("tick tick tick!!!");

        Todo[] todos = restTemplate.getForObject(s.getUri() + "/todo-backend/all", Todo[].class);
		model.addAttribute("todos", todos);
		return "todo";
	}

}
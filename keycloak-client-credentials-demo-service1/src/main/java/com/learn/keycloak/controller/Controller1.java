package com.learn.keycloak.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/microservice1")
public class Controller1 {

	private static final String MICROSERVICE_2_URL = "http://localhost:8084/microservice2/home";

	private final RestTemplate restTemplate = new RestTemplateBuilder().build();
	private final WebClient webClient = WebClient.builder().build();

	@GetMapping("/home")
	public String helloRestClient() {
		Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + jwt.getTokenValue());
		ResponseEntity<String> response = restTemplate.exchange(
				MICROSERVICE_2_URL,
				HttpMethod.GET,
				new HttpEntity<>(headers),
				String.class);

		return "hello from microservice 1 and " + response.getBody() ;
	}

	@GetMapping("/home/web-client")
	public String helloWebClient() {
		Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String response = webClient
				.get()
				.uri(MICROSERVICE_2_URL)
				.headers(header -> header.setBearerAuth(jwt.getTokenValue()))
				.retrieve()
					.bodyToMono(String.class)
					.block();

		return "hello from microservice 1 and " + response ;
	}
}

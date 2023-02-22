package com.learn.keycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/microservice1")
public class Controller1 {

	@GetMapping("/home")
	public String hello() {
		return "hello from microservice 1";
	}
}

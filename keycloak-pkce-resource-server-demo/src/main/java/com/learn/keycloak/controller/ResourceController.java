package com.learn.keycloak.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/my-resource")
@CrossOrigin(origins = "*")
public class ResourceController {

	@GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String myResource() {
        return "Hello";
    }
}

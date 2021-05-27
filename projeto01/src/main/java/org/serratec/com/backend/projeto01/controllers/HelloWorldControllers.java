package org.serratec.com.backend.projeto01.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saudacao")
public class HelloWorldControllers {
	
	@GetMapping("/ola")
	public String helloWorld() {
		return "Olá Mundo";
	}
}

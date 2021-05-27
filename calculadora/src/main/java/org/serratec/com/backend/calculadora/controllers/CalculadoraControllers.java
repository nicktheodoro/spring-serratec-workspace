package org.serratec.com.backend.calculadora.controllers;

import java.util.List;

import org.serratec.com.backend.calculadora.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcular")
public class CalculadoraControllers {
	
	 	@Autowired
	    CalculadoraService service;
	 	
	    @GetMapping
	    public List<Object> calcular() {
	        return service.create();
	   }
	
}

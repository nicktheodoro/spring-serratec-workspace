package org.serratec.com.backend.calculadora.controllers;

import java.util.List;

import org.serratec.com.backend.calculadora.models.CalculadoraEntity;
import org.serratec.com.backend.calculadora.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcular")
public class CalculadoraControllers {
	
	 	@Autowired
	    CalculadoraService service;
	 	
	    @PostMapping("/result")
		public double somar(@RequestBody CalculadoraEntity calculator) {
			return service.calcular(calculator);
		}
	    
	    @PostMapping("/create")
	    public void create(@RequestBody CalculadoraEntity calculator) {
	    	service.create(calculator);
	    }
	    
	    @GetMapping("/all")
	    public List<CalculadoraEntity> getAll() {
	    	return service.getAll();
	    }
	    
	    @GetMapping("/search/{number1}")
	    public CalculadoraEntity search(@PathVariable double number1 ) {
	    	return service.search(number1);
	    }
	
}

package org.serratec.com.backend.calculadora.controllers;

import org.serratec.com.backend.calculadora.models.CalculadoraEntity;
import org.serratec.com.backend.calculadora.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcular")
public class CalculadoraControllers {
	
	 	@Autowired
	    CalculadoraService service;
	 	
	    @GetMapping("/somar")
		public double somar(@RequestBody CalculadoraEntity calculator) {
			return service.somar(calculator);
		}
	    
	    @GetMapping("/subtrair")
		public double subtrair(@RequestBody CalculadoraEntity calculator) {
			return service.subtrair(calculator);
		}
	    
	    @GetMapping("/multiplicar")
		public double multiplicar(@RequestBody CalculadoraEntity calculator) {
			return service.multiplicar(calculator);
		}
	    
	    @GetMapping("/dividir")
		public double dividir(@RequestBody CalculadoraEntity calculator) {
			return service.dividir(calculator);
		}
	
}

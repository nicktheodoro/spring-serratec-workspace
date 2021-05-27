package org.serratec.com.backend.calculadora.services;

import org.serratec.com.backend.calculadora.models.CalculadoraEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

	public double somar(CalculadoraEntity calculator) {
		return (calculator.getNum1() + calculator.getNum2());
	}

	public double subtrair(CalculadoraEntity calculator) {
		return (calculator.getNum1() - calculator.getNum2());
	}

	public double multiplicar(CalculadoraEntity calculator) {
		return (calculator.getNum1() * calculator.getNum2());
	}

	public double dividir(CalculadoraEntity calculator) {
		if(calculator.getNum2() == 0) {
			return 0;
		}
		return (calculator.getNum1() / calculator.getNum2());
	}
}

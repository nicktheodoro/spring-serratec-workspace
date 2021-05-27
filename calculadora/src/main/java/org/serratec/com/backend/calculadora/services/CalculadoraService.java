package org.serratec.com.backend.calculadora.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.com.backend.calculadora.models.CalculadoraEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

	List<CalculadoraEntity> Lista = new ArrayList<>();

	@SuppressWarnings("null")
	public double calcular(CalculadoraEntity calculator) {

		if (calculator.getOpr() != null) {
			switch (calculator.getOpr()) {
			case "+":
				return (calculator.getNum1() + calculator.getNum2());
			case "-":
				return (calculator.getNum1() - calculator.getNum2());
			case "*":
				return (calculator.getNum1() * calculator.getNum2());
			case "/":
				if (calculator.getNum2() == 0) {
					System.out.println("Não podemos dividir por 0");
					return (Double) null;
				}
				return (calculator.getNum1() / calculator.getNum2());
			default:
				System.out.println("Operador invalido para esse endpoint!");
				return (Double) null;
			}
		}
		System.out.println("Operador invalido para esse endpoint!");
		return (Double) null;
	}

	public void create(CalculadoraEntity calculator) {
		Lista.add(calculator);
	}

	public List<CalculadoraEntity> getAll() {
		return this.Lista;
	}
	
	public CalculadoraEntity search(double n1) {
		for (CalculadoraEntity calculadoraEntity : Lista) {
			if(calculadoraEntity.getNum1() == n1) {
				return calculadoraEntity;
			} 
		}
		System.out.println("Numero não encontrado");
		return null;
	}

}

package org.serratec.com.backend.calculadora.services;

import java.util.Arrays;
import java.util.List;

import org.serratec.com.backend.calculadora.models.CalculadoraEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
	
	public List<Object> create() {
        return Arrays.asList(new CalculadoraEntity(20, 2, "+").getTotal(),
                new CalculadoraEntity(20, 2, "-").getTotal(),
                new CalculadoraEntity(20, 2, "/").getTotal(),
                new CalculadoraEntity(20, 2, "*").getTotal()
                );
    }
}

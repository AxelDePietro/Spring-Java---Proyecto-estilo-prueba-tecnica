package com.axeldp.pruebaTecnica.serviceHelpers;

import org.springframework.stereotype.Component;

@Component
public class VehiculoHelper {
	
	public boolean verificarMatricula(String matricula) {
		//equals para textos literales, matches para formatos/patron de expresion xD
		if(!matricula.matches("^[A-Z]{3}[0-9]{3}$|^[A-Z]{2}[0-9]{3}[A-Z]{2}$")) {
			return true;
		}
		return false;
	}
	
}

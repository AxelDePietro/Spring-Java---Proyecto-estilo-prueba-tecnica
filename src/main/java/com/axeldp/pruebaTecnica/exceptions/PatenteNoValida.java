package com.axeldp.pruebaTecnica.exceptions;

public class PatenteNoValida extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public PatenteNoValida() {
		super("la patente ingresada no es valida, intente otra vez");
	}

}

package com.axeldp.pruebaTecnica.exceptions;

import java.time.LocalDate;

public class DiaCompleto extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DiaCompleto(LocalDate fecha) {
		super("el dia " + fecha + " esta sin cupos para turnos");
	}
	
}

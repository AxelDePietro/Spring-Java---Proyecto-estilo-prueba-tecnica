package com.axeldp.pruebaTecnica.exceptions;

public class HorarioNoDisponible extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HorarioNoDisponible(int hora) {
		super("el horario '" + hora + "' de este mismo dia ya ha sido reservado, intente con otro");
	}
	
}

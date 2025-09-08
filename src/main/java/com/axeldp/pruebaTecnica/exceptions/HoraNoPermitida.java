package com.axeldp.pruebaTecnica.exceptions;

public class HoraNoPermitida extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public  HoraNoPermitida(int hora) {
		super("El horario '" + hora + "' no está disponible. Selecciona uno posterior a la hora actual.");
	}
}

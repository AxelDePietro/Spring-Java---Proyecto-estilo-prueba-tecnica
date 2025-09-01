package com.axeldp.pruebaTecnica.exceptions;

public class SinServicios extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SinServicios (int idTurno) {
		super("no selecciono ningun servicio, vuelva a intentarlo seleccionando un servicio");
	}
	
}

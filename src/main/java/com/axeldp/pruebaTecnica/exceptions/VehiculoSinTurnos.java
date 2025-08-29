package com.axeldp.pruebaTecnica.exceptions;

public class VehiculoSinTurnos extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public VehiculoSinTurnos (int idVehiculo) {
		super("el vehiculo "  + idVehiculo + " no tiene turnos aun, intente hacer una reserva.");
	}
	
}

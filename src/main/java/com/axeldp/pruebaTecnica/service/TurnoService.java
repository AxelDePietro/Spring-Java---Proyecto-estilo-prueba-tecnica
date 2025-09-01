package com.axeldp.pruebaTecnica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axeldp.pruebaTecnica.entity.Turno;
import com.axeldp.pruebaTecnica.exceptions.PatenteNoValida;
import com.axeldp.pruebaTecnica.exceptions.VehiculoSinTurnos;
import com.axeldp.pruebaTecnica.repository.ITurnoRepository;
import com.axeldp.pruebaTecnica.repository.IVehiculoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TurnoService {

	private final ITurnoRepository turnoRepository;
	private final IVehiculoRepository vehiculoRepository;

	// crear
	public Turno crearTurno(Turno turno, int idVehiculo ) {
		turno.setVehiculo(vehiculoRepository.findById(idVehiculo).get());
		
		int precio = 0;
		
		switch(turno.getTipo()) {
		case NO -> precio+=0;
		case BASICO ->  precio+=10000;
		case COMPLETO -> precio+=15000;
		case PREMIUM -> precio+=20000;
		}
		
		if(turno.isAlineacionBalanceo()) precio+=120000;
		
		if(turno.isCambioCubiertas()) precio+=50000;
		
		switch(turno.getMotor()) {
		case NO -> precio+=0;
		case DIESEL -> precio+=60000;
		case NAFTERO -> precio+=50000;
		}
		
		switch(turno.getRendimiento()) {
		case NO -> precio+=0; 
		case ALTO -> precio+=20000;
		case BASICO -> precio+=10000;
		}
		
		turno.setPrecio(precio);
		
		return turnoRepository.save(turno);
	}
	
	// modificar
	//TODO
	public Turno modificarTurno (Turno turno) {
		Turno turnoMod = turnoRepository.findById(turno.getIdTurno()).get();
		
		turnoMod.setFecha(turno.getFecha());
		turnoMod.setHora(turno.getHora());
		turnoMod.setVehiculo(turno.getVehiculo());
		
		return turnoMod;
		
	}
	
	// mostrar
	public List<Turno> allTurnos (){
		return turnoRepository.findAll();
	}
	
	public List<Turno> allTurnosByVehiculo (int idVehiculo){
		
		if(turnoRepository.findAll().isEmpty()) {
			throw new VehiculoSinTurnos(idVehiculo);
		}
		
		return turnoRepository.turnosByVehiculo(idVehiculo);
	}
	
	public List<Turno> allTurnosByCliente (int idCliente){
		return turnoRepository.findByVehiculoClienteIdCliente(idCliente);
	}
	
	// eliminar
	//@Transactional
	public void deleteTurno (int idTurno) {
		turnoRepository.deleteById(idTurno);
	}
	
}

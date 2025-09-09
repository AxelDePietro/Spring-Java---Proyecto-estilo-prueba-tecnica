package com.axeldp.pruebaTecnica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axeldp.pruebaTecnica.entity.Turno;
import com.axeldp.pruebaTecnica.exceptions.DiaCompleto;
import com.axeldp.pruebaTecnica.exceptions.HoraNoPermitida;
import com.axeldp.pruebaTecnica.exceptions.HorarioNoDisponible;
import com.axeldp.pruebaTecnica.exceptions.SinServicios;
import com.axeldp.pruebaTecnica.exceptions.VehiculoSinTurnos;
import com.axeldp.pruebaTecnica.repository.ITurnoRepository;
import com.axeldp.pruebaTecnica.repository.IVehiculoRepository;
import com.axeldp.pruebaTecnica.serviceHelpers.TurnoHelper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TurnoService {

	private final ITurnoRepository turnoRepository;
	private final IVehiculoRepository vehiculoRepository;
	private final TurnoHelper helper;

	// crear
	public Turno crearTurno(Turno turno, int idVehiculo ) {
		turno.setVehiculo(vehiculoRepository.findById(idVehiculo).get());
		
		helper.insertarPrecio(turno);
		
		if(helper.verificarDia(turno.getFecha())) {
			throw new DiaCompleto(turno.getFecha()); 
		}
		
		if(helper.verificarHoraOcupada(turno)) {
			throw new HorarioNoDisponible(turno.getHora());
		}
		
		if(helper.verificarHoraPermitida(turno.getHora())) {
			throw new HoraNoPermitida(turno.getHora());
		}
		
		if(helper.verificarSevicios(turno)) {
			throw new SinServicios(turno.getIdTurno());
		}
		
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

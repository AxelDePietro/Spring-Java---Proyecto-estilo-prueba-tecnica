package com.axeldp.pruebaTecnica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axeldp.pruebaTecnica.entity.Turno;
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
		return turnoRepository.save(turno);
	}
	
	// modificar
	//TODO (finish)
	public Turno modificarTurno (Turno turno) {
		Turno turnoMod = turnoRepository.findById(turno.getIdTurno()).get();
		
		turnoMod.setFechaHora(null);
		turnoMod.setVehiculo(null);
		
		return turnoMod;
		
	}
	
	// mostrar
	public List<Turno> allTurnos (){
		return turnoRepository.findAll();
	}
	
	public List<Turno> allTurnosByVehiculo (int idVehiculo){
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

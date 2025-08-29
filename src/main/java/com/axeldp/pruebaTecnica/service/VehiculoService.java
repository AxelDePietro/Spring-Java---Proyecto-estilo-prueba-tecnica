package com.axeldp.pruebaTecnica.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.axeldp.pruebaTecnica.entity.Vehiculo;
import com.axeldp.pruebaTecnica.repository.IVehiculoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehiculoService {

	private final IVehiculoRepository vehiculoRepository;

	public Vehiculo crearVehiculo(Vehiculo vehiculo) {
		return vehiculoRepository.save(vehiculo);
	}

	public List<Vehiculo> vehiculosPorCliente(int idCliente) {
		
		List<Vehiculo> vehiculosCliente = new ArrayList<>();

		for (Vehiculo v : vehiculoRepository.findAll()) {
			if (v.getCliente().getIdCliente() == idCliente) {
				vehiculosCliente.add(v);
			}
		}
		return vehiculosCliente;
	}
	
	public List<Vehiculo> allVehiculos(){
		return vehiculoRepository.findAll();
	}
	
	@Transactional
	public void deleteVehiculo(int idCliente, int idVehiculo) {
		
//		opcion 1: super ineficiente
//		List<Vehiculo> vehiculosCliente = new ArrayList<>();
//
//		for (Vehiculo v : vehiculoRepository.findAll()) {
//			if (v.getCliente().getId_cliente() == idCliente && v.getId_vehiculo() == idVehiculo) {
//				vehiculoRepository.delete(v);
//			}
//		}
		
//		OPCION 2: mas eificiente pero manual
//		Optional<Vehiculo> vehiculo = vehiculoRepository.findById(idVehiculo);
//		
//		if(vehiculo.get().getCliente().getId_cliente() == idCliente) {
//			Vehiculo v = vehiculo.get();
//			vehiculoRepository.delete(v);
//		}

//		OPCION 3: QUERY DIRECTA 
		vehiculoRepository.deleteByIDandClienteID(idVehiculo, idCliente);
	}
	
	public void deleteVehiculo (int idVehiculo) {
		vehiculoRepository.deleteById(idVehiculo);
	}

}

package com.axeldp.pruebaTecnica.serviceHelpers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.axeldp.pruebaTecnica.entity.Turno;
import com.axeldp.pruebaTecnica.entity.enums.Motor;
import com.axeldp.pruebaTecnica.entity.enums.Rendimiento;
import com.axeldp.pruebaTecnica.entity.enums.Tipo;
import com.axeldp.pruebaTecnica.repository.ITurnoRepository;

@Component
public class TurnoHelper {
	
	@Autowired
	private ITurnoRepository turnoRepository;

		public void insertarPrecio(Turno turno) {
			
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
			
			turno.setPrecio(precio);;
		}
		
		public boolean verificarHoraOcupada(Turno turno) {
			for(Turno t : turnoRepository.findAll()) {
				if(t.getHora()==turno.getHora() && t.getFecha().equals(turno.getFecha())) {
					return true;
				}
			}
			return false;
		}
		
		public boolean verificarSevicios(Turno turno) {
			if(turno.getTipo()==Tipo.NO 
					&& !turno.isAlineacionBalanceo() 
					&& !turno.isCambioCubiertas() 
					&& turno.getMotor()==Motor.NO 
					&& turno.getRendimiento()==Rendimiento.NO) {
				return true;
			}
			return false;
		}
		
		public boolean verificarDia(LocalDate fecha) {
			
			List<Integer> horas = new ArrayList<>();
			
			for(Turno t: turnoRepository.findByFecha(fecha)) {
				if(t.getFecha().equals(fecha)) {
					horas.add(t.getHora());
				}
			}
			return horas.size()==11;
		}
		
		public boolean verificarHoraPermitida(int hora) {
			
			if(hora<LocalDateTime.now().getHour()+1) {
				return true;
			}
			return false;
		}
}

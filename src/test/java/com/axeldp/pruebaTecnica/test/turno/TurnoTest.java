package com.axeldp.pruebaTecnica.test.turno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.axeldp.pruebaTecnica.entity.Turno;
import com.axeldp.pruebaTecnica.entity.enums.Motor;
import com.axeldp.pruebaTecnica.entity.enums.Rendimiento;
import com.axeldp.pruebaTecnica.entity.enums.Tipo;
import com.axeldp.pruebaTecnica.repository.ITurnoRepository;
import com.axeldp.pruebaTecnica.serviceHelpers.TurnoHelper;

@ExtendWith(MockitoExtension.class)
class TurnoTest {

	@Mock
	ITurnoRepository turnoRepository;

	@InjectMocks
	TurnoHelper helper;

	private Turno turno;

	@BeforeEach
	void setUp() {
		turno = new Turno();
		turno.setFecha(LocalDate.of(2025, 9, 8));
		turno.setHora(10);
		turno.setTipo(Tipo.BASICO);
		turno.setAlineacionBalanceo(false);
		turno.setCambioCubiertas(false);
		turno.setMotor(Motor.NO);
		turno.setRendimiento(Rendimiento.NO);
	}

	@Test
	void insertarPrecioBasico() {
		helper.insertarPrecio(turno);
		assertEquals(10000, turno.getPrecio());
		//System.out.println(turno);
	}

	@Test
	void verificarHoraDisponible() {
		when(turnoRepository.findAll()).thenReturn(List.of());
		
		boolean resultado = helper.verificarHoraOcupada(turno);
		
		assertFalse(resultado);
		verify(turnoRepository).findAll();
	}
	
	@Test
	void verificarHoraNoDisponible() {
		//crea turno con la misma hora que el turno global.
		Turno ocupado = new  Turno();
		ocupado.setHora(10);
		ocupado.setFecha(turno.getFecha());
		
		//cuando llamamos a findall(dentro de helper) del rep devuelve una lista de turnos ocupados en la misma hora.
		when(turnoRepository.findAll()).thenReturn(List.of(ocupado));
	
		//guarda la verificacion de que el turno tenga un horario no ocupado
		boolean resultado = helper.verificarHoraOcupada(turno);
		
		//verifica que sea lo esperado
		assertTrue(resultado);
		
		//se serciora de que el repositorio se haya llamado de forma correcta, de lo contrario el test falla.
		verify(turnoRepository).findAll();
	
	}
	
	@Test
	void verificarSinServicios() {
		turno.setTipo(Tipo.NO);
		turno.setAlineacionBalanceo(false);
		turno.setCambioCubiertas(false);
		turno.setMotor(Motor.NO);
		turno.setRendimiento(Rendimiento.NO);
		
		boolean resultado = helper.verificarSevicios(turno);
		
		assertTrue(resultado);		
	}
	
	@Test
	void verificarHoraPasada() {
		int horaPasada = LocalDateTime.now().getHour() - 1;

		boolean resultado = helper.verificarHoraPermitida(horaPasada);

		assertTrue(resultado);
	}

	@Test
	void verificarHoraFutura() {
		int horaFutura = LocalDateTime.now().getHour() + 1;

		boolean resultado = helper.verificarHoraPermitida(horaFutura);

		assertFalse(resultado);
	}
	
}

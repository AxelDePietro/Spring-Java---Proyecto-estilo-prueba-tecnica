package com.axeldp.pruebaTecnica.entity;

import java.time.LocalDate;

import com.axeldp.pruebaTecnica.entity.enums.Motor;
import com.axeldp.pruebaTecnica.entity.enums.Rendimiento;
import com.axeldp.pruebaTecnica.entity.enums.Tipo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Turno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTurno;

	LocalDate fecha;

	private int hora;

	private int precio;
	
	@ManyToOne
	@JoinColumn(name = "fk_vehiculo")
	private Vehiculo vehiculo;
	
	private Tipo tipo;
	
	private boolean alineacionBalanceo;
	private boolean cambioCubiertas;
	
	private Motor motor;
	private Rendimiento rendimiento;

}
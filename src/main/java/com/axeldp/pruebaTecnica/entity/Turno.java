package com.axeldp.pruebaTecnica.entity;

import java.time.LocalDate;

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
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Turno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTurno;

	int dia = 25;
	int mes = 8;
	int anio = 2025;

	LocalDate fecha = LocalDate.of(anio, mes, dia);

	private int hora;

	@ManyToOne
	@JoinColumn(name = "id_vehiculo")
	private Vehiculo vehiculo;

}

//public class Ejemplo {
//    public static void main(String[] args) {
//        int dia = 25;
//        int mes = 8;
//        int anio = 2025;
//
//        LocalDate fecha = LocalDate.of(anio, mes, dia);
//        System.out.println("La fecha es: " + fecha);
//    }
//}
package com.axeldp.pruebaTecnica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axeldp.pruebaTecnica.entity.Turno;
import java.time.LocalDate;


@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Integer>{

	//turnos del vehiculo
	@Query("SELECT t FROM Turno t WHERE t.vehiculo.idVehiculo = :idVehiculo")
	public List<Turno> turnosByVehiculo (@Param("idVehiculo") int idVehiculo);
	
	//turnos del cliente
	public List<Turno> findByVehiculoClienteIdCliente (int idCliente);
	
	//se puede hacer sin query mediente "lenguaje de metodo, JPA"
	public void deleteByIdTurno(int idTurno);
	
//	@Modifying
//	@Query("DELETE FROM Turno t WHERE t.vehiculo.idVehiculo = :idVehiculo AND t.idTurno = :idTurno")
//	public void deleteByIdTurnoANDIdVehiculo (@Param("idVehiculo") int idVehiculo, @Param("idTurno") int idTurno);
	
	public List<Turno> findByFecha(LocalDate fecha);
	
}

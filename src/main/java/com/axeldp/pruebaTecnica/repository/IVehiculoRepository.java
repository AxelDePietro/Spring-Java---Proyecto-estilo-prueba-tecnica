package com.axeldp.pruebaTecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.axeldp.pruebaTecnica.entity.Vehiculo;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Integer>{

	@Modifying
	@Query("DELETE FROM Vehiculo v WHERE v.idVehiculo = :idVehiculo AND v.cliente.idCliente = :idCliente")
	void deleteByIDandClienteID (@Param("idVehiculo") int idVehiculo, @Param("idCliente") int idCliente );
	
}

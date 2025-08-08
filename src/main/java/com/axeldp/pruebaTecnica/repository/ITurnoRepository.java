package com.axeldp.pruebaTecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axeldp.pruebaTecnica.entity.Turno;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Integer>{

}

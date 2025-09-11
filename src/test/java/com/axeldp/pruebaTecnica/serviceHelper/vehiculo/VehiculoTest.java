package com.axeldp.pruebaTecnica.serviceHelper.vehiculo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.axeldp.pruebaTecnica.entity.Vehiculo;
import com.axeldp.pruebaTecnica.serviceHelpers.VehiculoHelper;

@ExtendWith(MockitoExtension.class)
class VehiculoTest {

	VehiculoHelper helper = new VehiculoHelper();

	private Vehiculo vehiculo;

	@BeforeEach
	void setUp() {
		vehiculo = new Vehiculo();
		vehiculo.setMatricula("AA123BB");
	}

	@Test
	void verificarMatriculaValida() {
		
		boolean resultado = helper.verificarMatricula(vehiculo.getMatricula());

		assertFalse(resultado);
	}

	@Test
	void verificarMatriculaNoValida() {
		
		vehiculo.setMatricula("AAA123BB");
		
		boolean resultado = helper.verificarMatricula(vehiculo.getMatricula());

		assertTrue(resultado);
	}

}

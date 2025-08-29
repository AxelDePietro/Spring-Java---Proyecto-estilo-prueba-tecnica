package com.axeldp.pruebaTecnica.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(VehiculoSinTurnos.class)
	public ModelAndView ManejarVehiculoSinTurnos( VehiculoSinTurnos ex) {
		ModelAndView mav = new ModelAndView("error/vehiculoSinTurnos");
		mav.addObject( "mensaje", ex.getMessage());
		
		return mav;
		
	}
	
	
}

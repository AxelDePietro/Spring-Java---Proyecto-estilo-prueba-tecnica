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
	
	@ExceptionHandler(PatenteNoValida.class)
	public ModelAndView ManejarPatenteNoValida( PatenteNoValida ex) {
	
		ModelAndView mav = new ModelAndView("error/patenteNoValida");
		mav.addObject("mensaje", ex.getMessage());
		return mav;
	
	}
	
	@ExceptionHandler(HorarioNoDisponible.class)
	public ModelAndView ManejarHorarioNoDisponible( HorarioNoDisponible ex) {
		
		ModelAndView mav = new ModelAndView("error/horarioNoDisponible");
		mav.addObject("mensaje", ex.getMessage());
		return mav;
	}
	
	@ExceptionHandler(SinServicios.class)
	public ModelAndView ManejarSinServicios(SinServicios ex) {
		ModelAndView mav = new ModelAndView("error/sinServicios");
		mav.addObject("mensaje", ex.getMessage());
		return mav;
	}
	
	@ExceptionHandler(DiaCompleto.class)
	public ModelAndView ManejarDiaCompleto(DiaCompleto ex) {
		ModelAndView mav = new ModelAndView("error/diaCompleto");
		mav.addObject("mensaje", ex.getMessage());
		return mav;
	}
	
}

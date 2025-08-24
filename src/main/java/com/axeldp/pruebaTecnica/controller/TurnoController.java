package com.axeldp.pruebaTecnica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.axeldp.pruebaTecnica.entity.Turno;
import com.axeldp.pruebaTecnica.service.TurnoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TurnoController {

	private final TurnoService turnoService;

	//vista crear
	@GetMapping("/createTurno")
	public ModelAndView viewCreateTurno(@RequestParam int idVehiculo) {	
	

		ModelAndView mav = new ModelAndView("turno/createTurno");
		mav.addObject("idVehiculo", idVehiculo);
		mav.addObject("turno", new Turno());
		return mav;
	}
	
	//crear
	@PostMapping("/createTurno")
	public ModelAndView createdTurno(@RequestParam  int idVehiculo, @ModelAttribute Turno turno ) {

		turnoService.crearTurno(turno, idVehiculo);
		
		ModelAndView mav = new ModelAndView("turno/allturnos");
		mav.addObject("turnos", turnoService.allTurnos());
		return mav;
	}

	// mostrar
	@GetMapping("/allTurnos")
	public ModelAndView allTurnos() {

		ModelAndView mav = new ModelAndView("turno/allturnos");
		mav.addObject("turnos", turnoService.allTurnos());
		return mav;
	}

	@GetMapping("/allTurnosVehiculo")
	public ModelAndView allTurnosVehiculo(@RequestParam int idVehiculo) {

		ModelAndView mav = new ModelAndView("turno/allturnos");
		mav.addObject("turnos", turnoService.allTurnosByVehiculo(idVehiculo));
		return mav;
	}

	@GetMapping("/allTurnosCliente")
	public ModelAndView allTurnosCliente(@RequestParam int idCliente) {

		ModelAndView mav = new ModelAndView("turno/allturnos");
		mav.addObject("turnos", turnoService.allTurnosByCliente(idCliente));
		return mav;
	}
	
	//eliminar
	
	@PostMapping("/deleteTurno")
	public ModelAndView deleteTurno(@RequestParam int idTurno) {

		turnoService.deleteTurno(idTurno);
		
		ModelAndView mav = new ModelAndView("turno/allturnos");
		mav.addObject("turnos", turnoService.allTurnos());
		return mav;
	}
	

}

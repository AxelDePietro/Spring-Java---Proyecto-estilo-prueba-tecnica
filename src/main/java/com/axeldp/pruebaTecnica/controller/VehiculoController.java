package com.axeldp.pruebaTecnica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.axeldp.pruebaTecnica.entity.Vehiculo;
import com.axeldp.pruebaTecnica.service.ClienteService;
import com.axeldp.pruebaTecnica.service.VehiculoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class VehiculoController {

	private final VehiculoService vehiculoService;
	private final ClienteService clienteService;

	// revisar
	@GetMapping("/vistaVehiculo")
	public ModelAndView vistaCrearVehiculo(@RequestParam int idCliente) {
		ModelAndView mav = new ModelAndView("vehiculo/createVehiculo");
		mav.addObject("idCliente", idCliente);
		mav.addObject("vehiculo", new Vehiculo());
		return mav;
	}

	// revisar
	@PostMapping("/crearVehiculo")
	public ModelAndView crearVehiculo(@RequestParam int idCliente, @ModelAttribute Vehiculo vehiculo) {

		Vehiculo vehiculoFinal = new Vehiculo(0, vehiculo.getMatricula(), clienteService.clienteID(idCliente), null);

		vehiculoService.crearVehiculo(vehiculoFinal);

		ModelAndView mav = new ModelAndView("vehiculo/allVehiculosCliente");
		mav.addObject("vehiculo", vehiculoService.vehiculosPorCliente(idCliente));
		return mav;

	}

	@GetMapping("/allVehiculos")
	public ModelAndView allVehiculos() {

		ModelAndView mav = new ModelAndView("vehiculo/allVehiculos");
		mav.addObject("vehiculos", vehiculoService.allVehiculos());
		mav.addObject("clientes", clienteService.allClientes());
		return mav;
	}

	@GetMapping("/allVehiculosCliente")
	public ModelAndView allVehiculos(@RequestParam int idCliente) {

		ModelAndView mav = new ModelAndView("vehiculo/allVehiculosCliente");
		mav.addObject("vehiculo", vehiculoService.vehiculosPorCliente(idCliente));
		return mav;
	}
	
	@PostMapping("/deleteVehiculo")
	public ModelAndView deleteVehiculo(@RequestParam int idCliente, @RequestParam int idVehiculo) {
		
		vehiculoService.deleteVehiculo(idCliente, idVehiculo);
		
		ModelAndView mav = new ModelAndView("vehiculo/allVehiculosCliente");
		mav.addObject("vehiculo", vehiculoService.vehiculosPorCliente(idCliente));
		return mav;
	}

}

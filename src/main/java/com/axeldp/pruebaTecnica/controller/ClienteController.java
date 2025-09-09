package com.axeldp.pruebaTecnica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.axeldp.pruebaTecnica.entity.Cliente;
import com.axeldp.pruebaTecnica.service.ClienteService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ClienteController {

	private final ClienteService clienteService;

	@GetMapping("/createCliente")
	public ModelAndView viewCreateCliente () {
		
		ModelAndView mav =  new ModelAndView("cliente/createCliente");
		
		mav.addObject("cliente", new Cliente());
		
		return mav;
	}
	
	@PostMapping("/createCliente")
	public ModelAndView createCliente (@ModelAttribute Cliente cliente) {
		
		clienteService.createCliente(cliente);
		
		ModelAndView mav = new ModelAndView("cliente/allClientes");
		mav.addObject("clientes", clienteService.allClientes());
		return mav;
		
	}
	
	@GetMapping("/allClientes")
	public ModelAndView allClients () {
		
		//List<Cliente> clientes = new ArrayList<>();
		
		ModelAndView mav = new ModelAndView("cliente/allClientes");
		mav.addObject("clientes", clienteService.allClientes());
		return mav;
	}
	
	//metodo post pq thymeleaf no soporta delete;
	
	@PostMapping("/deleteCliente")
	public ModelAndView deleteCliente (@RequestParam int idCliente) {
		
		clienteService.deleteCliente(idCliente);
		
		ModelAndView mav= new ModelAndView("cliente/allClientes");
		mav.addObject("clientes", clienteService.allClientes());
		return mav;
	}
	
}

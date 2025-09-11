package com.axeldp.pruebaTecnica.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axeldp.pruebaTecnica.entity.Cliente;
import com.axeldp.pruebaTecnica.repository.IClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

	private final IClienteRepository clienteRepository;
	
	@Transactional
	public Cliente createCliente (Cliente cliente) {
		
		return clienteRepository.save(cliente);

	}

	@Transactional(readOnly = true)
	public Cliente clienteID (int idCliente) {
		return clienteRepository.findById(idCliente).get();
	}
	
	@Transactional(readOnly = true)
	public List<Cliente> allClientes (){
		
		List<Cliente> clientes = clienteRepository.findAll();
		
		return clientes;
	}
	
	@Transactional
	public void deleteCliente (int idCliente) {
		clienteRepository.deleteById(idCliente);
	}
	
}

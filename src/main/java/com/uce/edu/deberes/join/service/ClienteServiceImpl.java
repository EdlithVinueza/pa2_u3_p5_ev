package com.uce.edu.deberes.join.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.deberes.join.repository.IClienteRepository;
import com.uce.edu.deberes.join.repository.modelo.Cliente;
import com.uce.edu.demo.ventas.repository.IHotelRepository;
import com.uce.edu.demo.ventas.repository.modelo.Habitacion;
import com.uce.edu.demo.ventas.repository.modelo.Hotel;
@Service
public class ClienteServiceImpl implements IClienteService{
	@Autowired
	private IClienteRepository iClienteRepository;

	@Override
	public List<Cliente> buscarClientesConPedidos() {
		// TODO Auto-generated method stub
		return this.iClienteRepository.seleccionarClientesConPedidos();
	}

	@Override
	public List<Cliente> buscarClientesConYSinPedidos() {
		// TODO Auto-generated method stub
		return this.iClienteRepository.seleccionarClientesConYSinPedidos();
	}

	@Override
	public List<Cliente> buscarClientesConPedidosUsandoFetchJoin() {
		// TODO Auto-generated method stub
		return this.iClienteRepository.seleccionarClientesConPedidosUsandoFetchJoin();
	}

	@Override
	public List<Cliente> buscarClientesConPedidosEnRangoDeFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		return this.iClienteRepository.seleccionarClientesConPedidosEnRangoDeFechas(fechaInicio, fechaFin);
	}

	@Override
	public List<Cliente> buscarClientesConYPsinPedidosPorDescripcion(String descripcionPedido) {
		// TODO Auto-generated method stub
		return this.iClienteRepository.seleccionarClientesConYPsinPedidosPorDescripcion(descripcionPedido);
	}

	


	

}

package com.uce.edu.deberes.join.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.deberes.join.repository.modelo.Cliente;

public interface IClienteRepository {
	
	public List<Cliente> seleccionarClientesConPedidos();
	
	public List<Cliente> seleccionarClientesConYSinPedidos();
	
	public List<Cliente> seleccionarClientesConPedidosUsandoFetchJoin();
	
	public List<Cliente> seleccionarClientesConPedidosEnRangoDeFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);
	
	public List<Cliente> seleccionarClientesConYPsinPedidosPorDescripcion(String descripcionPedido);
}

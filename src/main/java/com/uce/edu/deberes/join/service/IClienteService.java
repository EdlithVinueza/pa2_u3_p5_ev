package com.uce.edu.deberes.join.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.deberes.join.repository.modelo.Cliente;

public interface IClienteService {
	
	public List<Cliente> buscarClientesConPedidos();
	
	public List<Cliente> buscarClientesConYSinPedidos();
	
	public List<Cliente> buscarClientesConPedidosUsandoFetchJoin();
	
	public List<Cliente> buscarClientesConPedidosEnRangoDeFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);
	
	public List<Cliente> buscarClientesConYPsinPedidosPorDescripcion(String descripcionPedido);

}

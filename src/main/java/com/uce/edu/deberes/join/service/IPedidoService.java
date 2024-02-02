package com.uce.edu.deberes.join.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.deberes.join.repository.modelo.Pedido;

public interface IPedidoService {
	public List<Pedido> buscarTodosLosClientesConPedidos();
	public List<Pedido> busarTodosLosClientesConPedidosEnRangoDeFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);
	public List<Pedido> buscarPedidosYClientesPorCedula(String cedula);
	
	
	

}

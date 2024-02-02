package com.uce.edu.deberes.join.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.deberes.join.repository.modelo.Pedido;

public interface IPedidoRepository {
	
	public List<Pedido> seleccionarTodosLosClientesConPedidos();
	
	public List<Pedido> seleccionarTodosLosClientesConPedidosEnRangoDeFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);
	
	public List<Pedido> seleccionarPedidosYClientesPorCedula(String cedula);
	
	
}

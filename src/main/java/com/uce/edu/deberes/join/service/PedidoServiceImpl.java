package com.uce.edu.deberes.join.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.deberes.join.repository.IPedidoRepository;
import com.uce.edu.deberes.join.repository.modelo.Pedido;

@Service
public class PedidoServiceImpl implements IPedidoService{
	@Autowired
	private IPedidoRepository iPedidoRepository;

	@Override
	public List<Pedido> buscarTodosLosClientesConPedidos() {
		// TODO Auto-generated method stub
		return this.iPedidoRepository.seleccionarTodosLosClientesConPedidos();
	}

	@Override
	public List<Pedido> busarTodosLosClientesConPedidosEnRangoDeFechas(LocalDateTime fechaInicio,
			LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		return this.iPedidoRepository.seleccionarTodosLosClientesConPedidosEnRangoDeFechas(fechaInicio, fechaFin);
	}

	@Override
	public List<Pedido> buscarPedidosYClientesPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iPedidoRepository.seleccionarPedidosYClientesPorCedula(cedula);
	}



	
	


	

}

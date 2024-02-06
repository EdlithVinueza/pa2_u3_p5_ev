package com.uce.edu.demo.ventas.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.ventas.repository.modelo.Cliente;
import com.uce.edu.demo.ventas.repository.modelo.Factura;
import com.uce.edu.demo.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaService {
	public Factura buscarPorNumero(String numero);

	public void guardar(Factura factura,Cliente cliente);

	public List<Factura> buscarFacturaInnerJoin();

	public List<Factura> buscarFacturaRightJoin();

	public List<Factura> buscarFacturaLeftJoin();

	public List<Factura> buscarFacturaFullJoin();
	
	public List<Factura> buscarFacturaWhereJoin();
	
	public List<Factura> buscarFacturaFetchJoin();
	
	public void actualizar(Factura factura);
	
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual);
	
	public Factura buscar(Integer id);
		
	public void borrar(Integer id);
	
	public int borrarPorNumero(String numero);
	
	public List<FacturaDTO> buscarFacturaDTO();
	
	public void prueba ();
	

}

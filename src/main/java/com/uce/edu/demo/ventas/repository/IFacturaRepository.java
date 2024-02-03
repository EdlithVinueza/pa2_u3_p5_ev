package com.uce.edu.demo.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.ventas.repository.modelo.Factura;
import com.uce.edu.demo.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaRepository {
	public Factura seleccionarPorNumero(String numero);
	
	
	public void insertar(Factura factura);

	public List<Factura> seleccionarFacturaInnerJoin();

	// segundo grupo de JOIN

	public List<Factura> seleccionarFacturaRightJoin();

	public List<Factura> seleccionarFacturaLeftJoin();

	public List<Factura> seleccionarFacturaFullJoin();
	
	public List<Factura> seleccionarFacturaWhereJoin();
	
	public List<Factura> seleccionarFacturaFetchJoin();
	
	public void actualizar(Factura factura);
	
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual);
	
	public Factura seleccionar(Integer id);
		
	public void eliminar(Integer id);
	
	public int eliminarPorNumero(String numero);
	
	public List<FacturaDTO> seleccionarFacturaDTO();
	

}

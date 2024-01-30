package com.uce.edu.demo.ventas.repository;

import java.util.List;

import com.uce.edu.demo.ventas.repository.modelo.Factura;

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

}

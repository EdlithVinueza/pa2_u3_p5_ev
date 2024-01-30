package com.uce.edu.demo.ventas.service;

import java.util.List;

import com.uce.edu.demo.ventas.repository.modelo.Factura;

public interface IFacturaService {
	public Factura buscarPorNumero(String numero);

	public void guardar(Factura factura);

	public List<Factura> buscarFacturaInnerJoin();

	public List<Factura> buscarFacturaRightJoin();

	public List<Factura> buscarFacturaLeftJoin();

	public List<Factura> buscarFacturaFullJoin();
	
	public List<Factura> buscarFacturaWhereJoin();
	
	public List<Factura> buscarFacturaFetchJoin();

}

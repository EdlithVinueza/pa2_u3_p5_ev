package com.uce.edu.demo.ventas.repository;

import com.uce.edu.demo.ventas.repository.modelo.Factura;

public interface IFacturaRepository {
	public Factura seleccionarPorNumero(String numero);
	public void insertar(Factura factura);

}

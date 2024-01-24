package com.uce.edu.demo.ventas.service;

import com.uce.edu.demo.ventas.repository.modelo.Factura;

public interface IFacturaService {
	public Factura buscarPorNumero(String numero);
	public void guardar(Factura factura);

}

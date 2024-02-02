package com.uce.edu.deberes.join.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.deberes.join.repository.modelo.Ciudadano;

public interface ICiudadanoService {


	public List<Ciudadano> buscarPorDireccion(String direccion);
	public List<Ciudadano> buscarPorSalario(BigDecimal salario);

}

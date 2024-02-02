package com.uce.edu.deberes.join.repository;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.deberes.join.repository.modelo.Ciudadano;



public interface ICiudadanoRepository {

	public List<Ciudadano> seleccionarPorDireccion(String direccion);
	public List<Ciudadano> seleccionarPorSalario(BigDecimal salario);
}

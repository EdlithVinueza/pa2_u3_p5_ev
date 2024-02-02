package com.uce.edu.deberes.join.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.deberes.join.repository.ICiudadanoRepository;
import com.uce.edu.deberes.join.repository.modelo.Ciudadano;
@Service
public class CiudadanoServiceImpl implements ICiudadanoService {
	@Autowired
	private ICiudadanoRepository ciudadanoRepository;


	@Override
	public List<Ciudadano> buscarPorDireccion(String direccion) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorDireccion(direccion);
	}

	@Override
	public List<Ciudadano> buscarPorSalario(BigDecimal salario) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.seleccionarPorSalario(salario);
	}

}

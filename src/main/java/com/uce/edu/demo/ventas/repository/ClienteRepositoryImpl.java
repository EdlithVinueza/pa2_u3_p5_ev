package com.uce.edu.demo.ventas.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ventas.repository.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)//Si es Requiared T1
	//begin
	public void insertar(Cliente cliente) {
		//System.out.println("Antes de ejecutar en la base");
		
		try {
		this.entityManager.persist(cliente);
		}catch (RuntimeException e) {
			System.out.println(e.getClass());
		}
		//System.out.println("Despues de ejecuar en la base");
	}
	//commit -->Termina T1 si fuera un Required 
	
	/*
	 * Si uso required la transaccion empieza y termina en el metodo que lo usa
	 * 
	 * 
	 * 
	 */

}

package com.uce.edu.deberes.join.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.deberes.join.repository.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public List<Ciudadano> seleccionarPorDireccion(String direccion) {
		TypedQuery<Ciudadano> query = this.entityManager.createQuery("SELECT c FROM Ciudadano c FULL JOIN c.empleado e WHERE e.direccion = :direccion",
				Ciudadano.class);
		query.setParameter("direccion", direccion);
		List<Ciudadano> lista = query.getResultList();
		return lista;
	}

	@Override
	public List<Ciudadano> seleccionarPorSalario(BigDecimal salario) {
		TypedQuery<Ciudadano> query = this.entityManager.createQuery("SELECT c FROM Ciudadano c JOIN FETCH c.empleado e WHERE e.salario = :salario",
				Ciudadano.class);
		query.setParameter("salario", salario);
		List<Ciudadano> lista = query.getResultList();
		return lista;
	}

}

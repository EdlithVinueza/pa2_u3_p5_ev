package com.uce.edu.deberes.join.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.deberes.join.repository.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Cliente> seleccionarClientesConPedidos() {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> query = entityManager.createQuery("SELECT c FROM Cliente c INNER JOIN c.pedidos p",
				Cliente.class);
		List<Cliente> lists = query.getResultList();
		for (Cliente c : lists) {
			c.getPedidos().size();
		}
		return lists;
	}

	@Override
	public List<Cliente> seleccionarClientesConYSinPedidos() {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> query = entityManager.createQuery("SELECT DISTINCT c FROM Cliente c LEFT JOIN c.pedidos p",
				Cliente.class);
		List<Cliente> lists = query.getResultList();
		for (Cliente c : lists) {
			c.getPedidos().size();
		}
		return lists;
	}

	@Override
	public List<Cliente> seleccionarClientesConPedidosUsandoFetchJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> query = entityManager.createQuery("SELECT DISTINCT c FROM Cliente c JOIN FETCH c.pedidos p",
				Cliente.class);
		List<Cliente> lists = query.getResultList();
		for (Cliente c : lists) {
			c.getPedidos().size();
		}
		return lists;
	}

	@Override
	public List<Cliente> seleccionarClientesConPedidosEnRangoDeFechas(LocalDateTime fechaInicio,
			LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> query = entityManager.createQuery(
				"SELECT c FROM Cliente c INNER JOIN c.pedidos p WHERE p.fecha BETWEEN :fechaInicio AND :fechaFin",
				Cliente.class);
		query.setParameter("fechaInicio", fechaInicio);
		query.setParameter("fechaFin", fechaFin);
		List<Cliente> lists = query.getResultList();
		for (Cliente c : lists) {
			c.getPedidos().size();
		}
		return lists;
	}

	@Override
	public List<Cliente> seleccionarClientesConYPsinPedidosPorDescripcion(String descripcionPedido) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> query = entityManager.createQuery(
				"SELECT DISTINCT c FROM Cliente c LEFT JOIN c.pedidos p WHERE p.descripcion = :descripcionPedido OR p IS NULL",
				Cliente.class);
		query.setParameter("descripcionPedido", descripcionPedido);
		List<Cliente> lists = query.getResultList();
		for (Cliente c : lists) {
			c.getPedidos().size();
		}
		return lists;
	}

}

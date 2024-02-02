package com.uce.edu.deberes.join.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.deberes.join.repository.modelo.Pedido;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PedidoRepositoryImpl implements IPedidoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Pedido> seleccionarTodosLosClientesConPedidos() {
		// TODO Auto-generated method stub
		TypedQuery<Pedido> query = entityManager.createQuery("SELECT p FROM Cliente c RIGHT JOIN c.pedidos p",
				Pedido.class);
		List<Pedido> lists = query.getResultList();
		for (Pedido p : lists) {
			p.getCliente();
		}
		return lists;
	}

	@Override
	public List<Pedido> seleccionarTodosLosClientesConPedidosEnRangoDeFechas(LocalDateTime fechaInicio,
			LocalDateTime fechaFin) {
		TypedQuery<Pedido> query = entityManager.createQuery(
				"SELECT p FROM Cliente c RIGHT JOIN c.pedidos p WHERE p.fecha BETWEEN :fechaInicio AND :fechaFin",
				Pedido.class);
		query.setParameter("fechaInicio", fechaInicio);
		query.setParameter("fechaFin", fechaFin);
		List<Pedido> lists = query.getResultList();
		for (Pedido p : lists) {
			p.getCliente();
		}
		return lists;

	}

	@Override
	public List<Pedido> seleccionarPedidosYClientesPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Pedido> query = entityManager
				.createQuery("SELECT p FROM Pedido p FULL JOIN p.cliente c WHERE c.cedula = :cedula", Pedido.class);
		query.setParameter("cedula", cedula);
		return query.getResultList();
	}



}

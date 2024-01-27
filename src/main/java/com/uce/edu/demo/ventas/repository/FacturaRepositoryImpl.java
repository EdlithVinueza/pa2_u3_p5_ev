package com.uce.edu.demo.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ventas.repository.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Factura seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f WHERE f.numero = :numero",
				Factura.class);
		myQuery.setParameter("numero", numero);
		Factura factura = myQuery.getSingleResult();
		factura.getDetalleFacturas().size(); // le digo que cargue el detalle bajo demanda

		return factura;

	}

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);

	}

	@Override
	public List<Factura> seleccionarFacturaInnerJoin() {
		// TODO Auto-generated method stub

		// SQL : SELECT * FROM factura f inner join detalle_factura d on f.defa_id on
		// defa_id_factura

		// JPQL: SELECT f FROM Factura f INNER JOIN f.detalleFacturas d

		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f INNER JOIN f.detalleFacturas d", Factura.class);

		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFacturas().size();
		}

		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturaRightJoin() {
		// Saca todos los elementos de la tabla derecha, incluso los que se cruzan o no
		// se cruzan
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalleFacturas d", Factura.class);

		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFacturas().size();
		}

		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturaLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalleFacturas d", Factura.class);

		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFacturas().size();
		}

		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturaFullJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f FULL JOIN f.detalleFacturas d", Factura.class);

		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFacturas().size();
		}

		return lista;
	}

}

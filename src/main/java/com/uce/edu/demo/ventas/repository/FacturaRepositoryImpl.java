package com.uce.edu.demo.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ventas.repository.modelo.Factura;
import com.uce.edu.demo.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
		factura.getDetallesFacturas().size(); // le digo que cargue el detalle bajo demanda

		return factura;

	}

	@Override
	@Transactional
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
//		for (Factura f : lista) {
//			f.getDetalleFacturas().size();
//		}

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
			f.getDetallesFacturas().size();
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
			f.getDetallesFacturas().size();
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
			f.getDetallesFacturas().size();
		}

		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturaWhereJoin() {
		// TODO Auto-generated method stub
		// SQL SELECT *FROM
		// SQL SELECT f. FROM factura f, detalle_factura d WHERE f.fecha_ide =
		// d.defa_id_factura
		// JPQL: SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura

		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura" + "", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetallesFacturas().size();
		}

		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturaFetchJoin() {
		// TODO Auto-generated method stub
		// SELECT f FROM Factura f JOIN FETCH f.datalleFacturas d
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f JOIN FETCH f.detalleFacturas d", Factura.class);

		return myQuery.getResultList();

	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);

	}

	@Override
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		// SQL: UPDATE factura set fact_fecha = : fechaNueva WHERE fact_fecha
		// >=fechaActual
		// JPQL_ UPDATE Factura f SET f.fecha =:fechaNueva WHERE f.fecha >=:fechaActual
		Query myQuery = this.entityManager
				.createQuery("UPDATE Factura f SET f.fecha =:fechaNueva WHERE f.fecha >=:fechaActual");
		myQuery.setParameter("fechaNueva", fechaNueva);
		myQuery.setParameter("fechaActual", fechaActual);
		// Cantidad de registros afectados/actualizados
		return myQuery.executeUpdate(); // esto retorna un valor entero
	}

	@Override
	public Factura seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Factura factura = this.seleccionar(id);
		this.entityManager.remove(factura);

	}

	@Override
	public int eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("DELETE FROM Factura f WHERE f.numero =:numero");
		myQuery.setParameter("numero", numero);
		return myQuery.executeUpdate();
	}

	@Override
	public List<FacturaDTO> seleccionarFacturaDTO() {
		// TODO Auto-generated method stub
		TypedQuery<FacturaDTO> myQuery = this.entityManager.createQuery("SELECT NEW com.uce.edu.demo.ventas.repository.modelo.dto.FacturaDTO(f.numero,f.fecha) FROM Factura f ", FacturaDTO.class);

		return myQuery.getResultList();
	}

}

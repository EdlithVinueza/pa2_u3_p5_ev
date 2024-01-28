package com.uce.edu.demo.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ventas.repository.modelo.Habitacion;
import com.uce.edu.demo.ventas.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements IHabitacionesRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Habitacion seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Habitacion.class, id);
	}

	@Override
	public void insertar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.merge(habitacion);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Habitacion habitacion= this.seleccionar(id);
		this.entityManager.remove(habitacion);

	}

	@Override
	public List<Hotel> seleccionarHotelPorClaseHabitacion (String tipoClase) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = 
				this.entityManager.createQuery("SELECT DISTINCT h FROM Hotel h RIGHT JOIN h.habitaciones hab WHERE hab.clase = :tipoHabitacion",
				Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoClase);
		List<Hotel> hoteles=myQuery.getResultList();
		for (Hotel hotel : hoteles) {
			hotel.getHabitaciones().size();
		}
		return hoteles ;
	}

	@Override
	public List<Habitacion> obtenerHabitacionesPorSector(String nombreSector) {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> myQuery = 
				this.entityManager.createQuery("SELECT h FROM Habitacion h LEFT JOIN h.hotel s WHERE s.direccion = :nombreSector",
				Habitacion.class);
		myQuery.setParameter("nombreSector", nombreSector);
		
		return  myQuery.getResultList();
	}
	

}

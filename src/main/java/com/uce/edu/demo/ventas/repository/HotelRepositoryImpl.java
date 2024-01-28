package com.uce.edu.demo.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ventas.repository.modelo.Factura;
import com.uce.edu.demo.ventas.repository.modelo.Habitacion;
import com.uce.edu.demo.ventas.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Hotel seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);

	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.merge(hotel);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Hotel hotel = this.seleccionar(id);
		this.entityManager.remove(hotel);

	}


	@Override
	public List<Hotel> seleccionarPorTipoHabitacionYEstrellas(String tipoHabitacion, String numeroEstrellas) {
		// TODO Auto-generated method stub

		TypedQuery<Hotel> myQuery = 
				this.entityManager.createQuery("SELECT h FROM Hotel h FULL JOIN h.habitaciones hab WHERE hab.clase = :tipoHabitacion AND h.estrellas =:numeroEstrellas",
				Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		myQuery.setParameter("numeroEstrellas", numeroEstrellas);
		List<Hotel> hoteles=myQuery.getResultList();
		for (Hotel hotel : hoteles) {
			hotel.getHabitaciones().size();
		}
		return hoteles ;
	}



	@Override
	public List<Habitacion> seleccioanarHabitacionesDeHotel(String nombreHotel) {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> myQuery = 
				this.entityManager.createQuery("SELECT h FROM Habitacion h INNER JOIN h.hotel hotel WHERE hotel.nombre = :nombreHotel",
				Habitacion.class);
		myQuery.setParameter("nombreHotel", nombreHotel);
		
		return  myQuery.getResultList();
	}


}

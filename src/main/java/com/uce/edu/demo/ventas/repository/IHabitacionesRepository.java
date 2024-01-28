package com.uce.edu.demo.ventas.repository;

import java.util.List;

import com.uce.edu.demo.ventas.repository.modelo.Habitacion;
import com.uce.edu.demo.ventas.repository.modelo.Hotel;

public interface IHabitacionesRepository {

	public Habitacion seleccionar(Integer id);

	public void insertar(Habitacion habitacion);

	public void actualizar(Habitacion habitacion);

	public void eliminar(Integer id);
	
	public List<Hotel> seleccionarHotelPorClaseHabitacion (String tipoClase);
	
	public List<Habitacion> obtenerHabitacionesPorSector(String nombreSector);
	

}

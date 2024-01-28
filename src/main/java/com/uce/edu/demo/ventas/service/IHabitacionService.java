package com.uce.edu.demo.ventas.service;

import java.util.List;

import com.uce.edu.demo.ventas.repository.modelo.Habitacion;
import com.uce.edu.demo.ventas.repository.modelo.Hotel;

public interface IHabitacionService {
	
	public Habitacion buscar(Integer id);

	public void guardar(Habitacion habitacion);

	public void actualizar(Habitacion habitacion);

	public void borrar(Integer id);
	
	public List<Hotel> buscarHotelPorClaseHabitacion (String tipoClase);
	
	public List<Habitacion> buscarHabitacionesPorSector(String nombreSector);

}

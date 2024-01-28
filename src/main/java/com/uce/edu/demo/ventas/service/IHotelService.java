package com.uce.edu.demo.ventas.service;

import java.util.List;

import com.uce.edu.demo.ventas.repository.modelo.Habitacion;
import com.uce.edu.demo.ventas.repository.modelo.Hotel;

public interface IHotelService {

	public Hotel buscar(Integer id);

	public void guardar(Hotel hotel);

	public void actualizar(Hotel hotel);

	public void borrar(Integer id);
	
	public List<Hotel> buscarPorTipoHabitacionYEstrellas(String tipoHabitacion, String numeroEstrellas);
	
	public List<Habitacion> buscarHabitacionesDeHotel(String nombreHotel);
	
	

}

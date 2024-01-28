package com.uce.edu.demo.ventas.repository;

import java.util.List;

import com.uce.edu.demo.ventas.repository.modelo.Habitacion;
import com.uce.edu.demo.ventas.repository.modelo.Hotel;

public interface IHotelRepository {
	
	// CRUD
		public Hotel seleccionar(Integer id);

		public void insertar(Hotel hotel);

		public void actualizar(Hotel hotel);

		public void eliminar(Integer id);
		
	
		
		public List<Hotel> seleccionarPorTipoHabitacionYEstrellas(String tipoHabitacion, String numeroEstrellas);
		

		public List<Habitacion> seleccioanarHabitacionesDeHotel(String nombreHotel); 


}

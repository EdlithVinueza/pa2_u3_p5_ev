package com.uce.edu.demo.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.ventas.repository.IHotelRepository;
import com.uce.edu.demo.ventas.repository.modelo.Habitacion;
import com.uce.edu.demo.ventas.repository.modelo.Hotel;
@Service
public class HotelServiceImpl implements IHotelService{
	@Autowired
	private IHotelRepository iHoteRepository;

	@Override
	public Hotel buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iHoteRepository.seleccionar(id);
	}

	@Override
	public void guardar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.iHoteRepository.insertar(hotel);
	}

	@Override
	public void actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.iHoteRepository.actualizar(hotel);
		
		
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iHoteRepository.eliminar(id);
		
	}

	@Override
	public List<Hotel> buscarPorTipoHabitacionYEstrellas(String tipoHabitacion, String numeroEstrellas) {
		// TODO Auto-generated method stub
		return this.iHoteRepository.seleccionarPorTipoHabitacionYEstrellas(tipoHabitacion, numeroEstrellas);
	}


	@Override
	public List<Habitacion> buscarHabitacionesDeHotel(String nombreHotel) {
		// TODO Auto-generated method stub
		return this.iHoteRepository.seleccioanarHabitacionesDeHotel(nombreHotel);
	}


	



	

}

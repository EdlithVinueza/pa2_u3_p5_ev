package com.uce.edu;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.ventas.repository.modelo.Habitacion;
import com.uce.edu.demo.ventas.repository.modelo.Hotel;
import com.uce.edu.demo.ventas.service.IHabitacionService;
import com.uce.edu.demo.ventas.service.IHotelService;

@SpringBootApplication
public class Pa2U3P5EvApplication implements CommandLineRunner {

	@Autowired
	private IHotelService iHotelService;
	@Autowired
	private IHabitacionService iHabitacionService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5EvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Hotel hotel = new Hotel();
		hotel.setNombre("Hotel 2");
		hotel.setDireccion("Sur de Quito");
		hotel.setEstrellas("5");

		// Crea algunas habitaciones
		Habitacion habitacion1 = new Habitacion();
		habitacion1.setNumero("103");
		habitacion1.setHotel(hotel);
		habitacion1.setClase("Clase A");

		Habitacion habitacion2 = new Habitacion();
		habitacion2.setNumero("104");
		habitacion2.setHotel(hotel);
		habitacion2.setClase("Clase B");

		Habitacion habitacion3 = new Habitacion();
		habitacion3.setNumero("105");
		habitacion3.setHotel(hotel);
		habitacion3.setClase("Clase C");

		// Agrega las habitaciones al hotel
		hotel.setHabitaciones(Arrays.asList(habitacion1, habitacion2, habitacion3));

		// this.iHotelService.guardar(hotel);

		System.out.println("USANDO INNER JOIN");
		List<Habitacion> habitaciones1 = this.iHotelService.buscarHabitacionesDeHotel("Hotel 1");
		for (Habitacion h : habitaciones1) {
			System.out.println(h.getClase());
		}

		System.out.println("USANDO RIGHT JOIN");

		List<Hotel> hoteles1 = this.iHabitacionService.buscarHotelPorClaseHabitacion("Clase B");
		for (Hotel h : hoteles1) {
			System.out.println(h);
		}

		System.out.println("USANDO LEFT JOIN");

		List<Habitacion> habitaciones2 = this.iHabitacionService.buscarHabitacionesPorSector("Quito Sur");
		for (Habitacion h : habitaciones2) {
			System.out.println(h.getClase());
		}

		System.out.println("USANDO FULL JOIN");
		List<Hotel> hoteles2 = this.iHotelService.buscarPorTipoHabitacionYEstrellas("Clase A", "5");
		for (Hotel h : hoteles2) {
			System.out.println(h);
		}

	}
}

package com.uce.edu;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.ventas.repository.IFacturaRepository;
import com.uce.edu.demo.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.demo.ventas.repository.modelo.Factura;
import com.uce.edu.demo.ventas.repository.modelo.Habitacion;
import com.uce.edu.demo.ventas.repository.modelo.Hotel;
import com.uce.edu.demo.ventas.repository.modelo.dto.FacturaDTO;
import com.uce.edu.demo.ventas.service.IFacturaService;
import com.uce.edu.demo.ventas.service.IHabitacionService;
import com.uce.edu.demo.ventas.service.IHotelService;

@SpringBootApplication
public class Pa2U3P5EvApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService iFacturaService;
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5EvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("UPDATE");
		int numero1 = this.iFacturaService.actualizarFechas(LocalDateTime.of(2000, 1, 15, 12, 50), LocalDateTime.of(2024, 1, 23, 20, 0));
		System.out.println(numero1);
		
		System.out.println("DELETE");
		int numero2 = this.iFacturaService.borrarPorNumero("001-026");
		System.out.println(numero2);
		
		System.out.println("DELETE ID----------------------------");
		//this.iFacturaService.borrar(2);

		System.out.println("DTO");
		List<FacturaDTO> listaDTO  = this.iFacturaService.buscarFacturaDTO();
		
		for (FacturaDTO f: listaDTO) {
			System.out.println(f);
		}

	}
}

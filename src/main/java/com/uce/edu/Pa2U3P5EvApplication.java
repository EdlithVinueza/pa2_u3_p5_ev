package com.uce.edu;

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
		
		System.out.println("INNER JOIN");
		List<Factura> Factura1 = this.iFacturaService.buscarFacturaInnerJoin();
		for (Factura factura : Factura1) {
			System.out.println(factura.getNumero());
//			for (DetalleFactura detalleFactura : factura.getDetalleFacturas()) {
//				System.out.println(detalleFactura.getNombreProdcuto());
//			}
		}		

		System.out.println("WHERE JOIN");
		List <Factura> lista = this.iFacturaService.buscarFacturaWhereJoin();
		for (Factura factura : lista) {
			System.out.println(factura.getNumero());
			for (DetalleFactura detalleFactura : factura.getDetalleFacturas()) {
				System.out.println(detalleFactura.getNombreProdcuto());
			}
		}
		
		System.out.println("FETCH JOIN");
		List <Factura> lista2 = this.iFacturaService.buscarFacturaFetchJoin();
		for (Factura factura : lista2) {
			System.out.println(factura.getNumero());
			for (DetalleFactura detalleFactura : factura.getDetalleFacturas()) {
				System.out.println(detalleFactura.getNombreProdcuto());
			}
		}
		

	}
}

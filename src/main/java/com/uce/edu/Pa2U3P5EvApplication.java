package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.demo.ventas.repository.modelo.Factura;
import com.uce.edu.demo.ventas.service.IFacturaService;

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
		Factura fc = new Factura();
		fc.setCedula("1751678065");
		fc.setFecha(LocalDateTime.now());
		fc.setNumero("001-026");

		DetalleFactura df1 = new DetalleFactura();
		df1.setCantidad(100);
		df1.setCodigoBarras("456789123");
		df1.setNombreProdcuto("Spride ");
		df1.setFactura(fc);

		DetalleFactura df2 = new DetalleFactura();
		df2.setCantidad(80);
		df2.setCodigoBarras("123789456");
		df2.setNombreProdcuto("Leche entera");
		df2.setFactura(fc);

		List<DetalleFactura> detalleFacturas = new ArrayList<>();
		detalleFacturas.add(df1);
		detalleFacturas.add(df2);

		fc.setDetalleFacturas(detalleFacturas);

		// this.iFacturaService.guardar(fc);

		System.out.println("INNER JOIN");
		List<Factura> Factura1 = this.iFacturaService.buscarFacturaInnerJoin();
		for (Factura factura : Factura1) {
			System.out.println(factura.getNumero());
		}

		System.out.println("RIGHT JOIN");
		List<Factura> Factura2 = this.iFacturaService.buscarFacturaRightJoin();
		for (Factura factura : Factura2) {
			System.out.println(factura.getNumero());
		}

		System.out.println("LEFT JOIN");
		List<Factura> Factura3 = this.iFacturaService.buscarFacturaLeftJoin();
		for (Factura factura : Factura3) {
			System.out.println(factura.getNumero());
		}

		System.out.println("FULL JOIN");
		List<Factura> Factura4 = this.iFacturaService.buscarFacturaFullJoin();
		for (Factura factura : Factura4) {
			System.out.println(factura.getNumero());
		}

	}

}

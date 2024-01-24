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
public class Pa2U3P5EvApplication implements CommandLineRunner{
	
	@Autowired 
	private IFacturaService iFacturaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5EvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Factura fc= new Factura();
		fc.setCedula("1751674027");
		fc.setFecha(LocalDateTime.now());
		fc.setNumero("001-025");
		
		DetalleFactura df1= new DetalleFactura();
		df1.setCantidad(50);
		df1.setCodigoBarras("123456789");
		df1.setNombreProdcuto("Coca Cola");
		df1.setFactura(fc);
		
		DetalleFactura df2= new DetalleFactura();
		df2.setCantidad(70);
		df2.setCodigoBarras("987654321");
		df2.setNombreProdcuto("Leche la vaquita");
		df2.setFactura(fc);
		
		List<DetalleFactura> detalleFacturas = new ArrayList<>();
		detalleFacturas.add(df1);
		detalleFacturas.add(df2);
		
		fc.setDetalleFacturas(detalleFacturas);
		
		//this.iFacturaService.guardar(fc);
		
		Factura facturabase=this.iFacturaService.buscarPorNumero("001-025");
		System.out.println(facturabase);
		
		
		for (DetalleFactura d:facturabase.getDetalleFacturas()) {
			System.out.println(d);
		}
		
		
	}

}

package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.ventas.repository.modelo.Cliente;
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
		
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		Factura factura = new Factura();
		factura.setCedula("1751674021");
		factura.setFecha(LocalDateTime.now());
		factura.setNumero("001-003");
		
		
		Cliente cliente = new Cliente();
		cliente.setApellido(null);
		cliente.setNombre("Edlith");
		//this.iFacturaService.guardar(factura, cliente);
		System.out.println("Main :"+TransactionSynchronizationManager.isActualTransactionActive());
		this.iFacturaService.prueba();
	
	}
}

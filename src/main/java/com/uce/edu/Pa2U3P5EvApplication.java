package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.ventas.repository.modelo.Cliente;
import com.uce.edu.demo.ventas.repository.modelo.Factura;
import com.uce.edu.demo.ventas.service.IClienteService;
import com.uce.edu.demo.ventas.service.IFacturaService;

@SpringBootApplication
@EnableAsync
public class Pa2U3P5EvApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService iFacturaService;
	@Autowired
	private IClienteService iClienteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5EvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		for(int i = 0;i < 10;i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("CN"+i);
			cliente.setApellido("CA"+i);
			iClienteService.guardar(cliente);
		}
		long tiempoFinal = System.currentTimeMillis();
		
		long tiempoTotal = (tiempoFinal - tiempoInicial)/1000;
		System.out.println("Tiempo Total: " +tiempoTotal);
		*/
		//Programacion en paralelo (multihilo - Multihread)
		
		/*
		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		List<Cliente> listClente = new ArrayList<>();
		for(int i = 0;i < 100;i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("CN"+i);
			cliente.setApellido("CA"+i);
			listClente.add(cliente);
		}
		
		listClente.stream().forEach(Cliente -> this.iClienteService.guardar(Cliente));
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTotal = (tiempoFinal - tiempoInicial)/1000;
		System.out.println("Tiempo Total: " +tiempoTotal);
	*/
		/*
		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		List<Cliente> listClente = new ArrayList<>();
		for(int i = 0;i < 100;i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("CN"+i);
			cliente.setApellido("CA"+i);
			listClente.add(cliente);
		}
		
		listClente.parallelStream().forEach(Cliente -> this.iClienteService.guardar(Cliente));
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTotal = (tiempoFinal - tiempoInicial)/1000;
		System.out.println("Tiempo Total: " +tiempoTotal);
		*/
		
		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		for(int i = 0;i < 500;i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("CN"+i);
			cliente.setApellido("CA"+i);
			iClienteService.guardar(cliente);
		}
		long tiempoFinal = System.currentTimeMillis();
		
		long tiempoTotal = (tiempoFinal - tiempoInicial)/1000;
		System.out.println("Tiempo Total: " +tiempoTotal);
		System.out.println("Se ha mandado a procesar a sus 500 clientes, puede continuar con sus actividades");
	}
}

package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.deberes.join.repository.modelo.Ciudadano;
import com.uce.edu.deberes.join.repository.modelo.Cliente;
import com.uce.edu.deberes.join.repository.modelo.Pedido;
import com.uce.edu.deberes.join.service.ICiudadanoService;
import com.uce.edu.deberes.join.service.IClienteService;
import com.uce.edu.deberes.join.service.IPedidoService;

@SpringBootApplication
public class Pa2U3P5EvApplication implements CommandLineRunner {

	@Autowired
	private IClienteService iClienteService;
	
	@Autowired
	private IPedidoService iPedidoService;
	
	@Autowired
	private ICiudadanoService iCiudadanoService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5EvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("INNER JOIN");
		System.out.println("Ejercicio 1");
		List<Cliente> c1 = this.iClienteService.buscarClientesConPedidos();

		for (Cliente c : c1) {
			System.out.println(c);
		}
		
		System.out.println("Ejercicio 2");
		List<Cliente> c2 = this.iClienteService.buscarClientesConPedidosEnRangoDeFechas(LocalDateTime.of(2024, 01, 31, 12, 0, 0), LocalDateTime.of(2024, 01, 31, 14, 0, 0));

		for (Cliente c : c2) {
			System.out.println(c);
		}
		
		System.out.println("RIGTH JOIN");
		System.out.println("Ejercicio 3");
		List<Pedido> p3 = this.iPedidoService.buscarTodosLosClientesConPedidos();
		for (Pedido p : p3) {
			System.out.println(p);
		}
		
		System.out.println("Ejercicio 4");
		List<Pedido> p4 = this.iPedidoService.busarTodosLosClientesConPedidosEnRangoDeFechas(LocalDateTime.of(2024, 01, 31, 12, 0, 0),LocalDateTime.of(2024, 01, 31, 15, 0, 0));
		for (Pedido p : p4) {
			System.out.println(p);
		}
		
		System.out.println("LEFT JOIN");
		System.out.println("Ejercicio 5");
		List<Cliente> c5 = this.iClienteService.buscarClientesConYSinPedidos();

		for (Cliente c : c5) {
			System.out.println(c);
		}
		System.out.println("Ejercicio 6");
		List<Cliente> c6 = this.iClienteService.buscarClientesConYPsinPedidosPorDescripcion("PedidoCliente1_1");

		for (Cliente c : c6) {
			System.out.println(c);
		}
		
		
		System.out.println("FULL JOIN");
		System.out.println("Ejercicio 7");
		List<Pedido> p7 = this.iPedidoService.buscarPedidosYClientesPorCedula("123456789");
		for (Pedido p : p7) {
			System.out.println(p);
		}
		
		System.out.println("Ejercicio 8");
		List<Ciudadano> c8 = this.iCiudadanoService.buscarPorDireccion("Direccion1");
		for (Ciudadano p : c8) {
			System.out.println(p);
		}
		
		System.out.println("FETCH JOIN");
		System.out.println("Ejercicio 9");
		List<Ciudadano> c9 = this.iCiudadanoService.buscarPorSalario(new BigDecimal(50000));
		for (Ciudadano p : c9) {
			System.out.println(p);
		}
		
		System.out.println("FETCH JOIN");
		
		System.out.println("Ejercicio 10");
		List<Cliente> c10 = this.iClienteService.buscarClientesConPedidosUsandoFetchJoin();
		for (Cliente c : c10) {
			System.out.println(c);
		}
		
	}
}

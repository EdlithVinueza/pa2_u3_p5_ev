package com.uce.edu.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.hibernate.query.spi.Limit;

import ch.qos.logback.core.net.SyslogOutputStream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Supplier
		System.out.println();
		System.out.println("****************SUPPLIER****************");
		// Clase
		System.out.println("Clases");
		IPersonaSupplier<String> supplierClase = new PersonaSupplerImpl();
		System.out.println(supplierClase.getId());

		// Lambdas
		System.out.println("Lambdas 1 ");
		IPersonaSupplier<String> supplierLambda = () -> {
			String cedula = "159357147963";
			return cedula = cedula + " canton";
		};
		System.out.println(supplierLambda.getId());

		System.out.println("Lambdas 2 ");
		IPersonaSupplier<String> supplierLambda2 = () -> "159357147963" + " pais";
		System.out.println(supplierLambda2.getId());

		System.out.println("Lambdas 3 ");
		IPersonaSupplier<Integer> supplierLambda3 = () -> {
			Integer valor1 = Integer.valueOf(100);
			valor1 = valor1 * Integer.valueOf(50) / Integer.valueOf(5);
			return valor1;
		};
		System.out.println(supplierLambda3.getId());
		System.out.println("Métodos Referenciados");
		MetodosReferenciados met = new MetodosReferenciados();
		IPersonaSupplier<String> supplierLambda4 = met::obtenerId;
		System.out.println(supplierLambda4.getId());
		
		//Métodos referenciados 

		System.out.println();
		System.out.println("****************CONSUMER****************");
		// Clase
		System.out.println("Clase");
		IPersonaConsumer<String> consummerClase = new PersonaConsumerImpl();
		consummerClase.accept("Profesor");
		// Lambdas
		System.out.println("Lambdas");
		IPersonaConsumer<String> consummerLambdaConsumer = (cadena) -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consummerLambdaConsumer.accept("Profesor");
		//Métodos referenciados 
		System.out.println("Métodos Referenciados");
		IPersonaConsumer<String> consummerLambdaConsumer1 = met::procesar;
		consummerLambdaConsumer1.accept("Edlith Referenciado");

		System.out.println();
		System.out.println("****************PREDICATE****************");
		System.out.println("Lambdas 1");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(7)));
		System.out.println("Lambdas 2");
		IPersonaPredicate<String> predicateLambda2 = letra -> "Edlith".contains(letra);
		System.out.println(predicateLambda2.evaluar("E"));
		//Métodos referenciados 
		System.out.println("Métodos Referenciados");
		IPersonaPredicate<String> predicateLambda3 = met::evaluar;
		System.out.println(predicateLambda3.evaluar("d"));
		IPersonaPredicate<Integer> predicateLambda4 = met::evaluar;
		System.out.println(predicateLambda4.evaluar(7));
		
		
		System.out.println();
		System.out.println("****************FUNCTION****************");
		System.out.println("Lambdas 1");
		IPersonaFunction<String, Integer> functionLambdaFunction = numero -> {
			numero = numero + Integer.valueOf(10);
			String numeroString = numero.toString().concat("-valor");
			return numeroString;
		};
		System.out.println(functionLambdaFunction.aplicar(Integer.valueOf(10)));

		System.out.println("Lambdas 2 Para crear Objetos");

		IPersonaFunction<Empleado, Ciudadano> functionLambdaFunction1 = ciudadano -> {
			Empleado empleado = new Empleado();
			empleado.setNombreCompleto(ciudadano.getNombre().concat(ciudadano.getApellido()));
			if (ciudadano.getProvincia().compareTo("Pichincha") == 0) {
				empleado.setPais("Ecuador");
			}

			return empleado;
		};

		Ciudadano ciudadano = new Ciudadano();
		ciudadano.setNombre("Edlith");
		ciudadano.setApellido("Vinueza");
		ciudadano.setProvincia("Pichincha");
		System.out.println(functionLambdaFunction1.aplicar(ciudadano));
		//Métodos referenciados 
		System.out.println("Métodos Referenciados");
		IPersonaFunction<Ciudadano, Empleado> functionLambdaFunction2 = met::cambiarCiudadano;
		Empleado empleado = new Empleado();
		empleado.setNombreCompleto("David Casas");
		empleado.setPais("Ecuador");
		System.out.println(functionLambdaFunction2.aplicar(empleado));
		
		System.out.println();
		System.out.println("****************UNARY OPERATOR****************");
		System.out.println("Lambdas con Unary Operator sin herencia");
		IPersonaUnaryOperator<Integer> unaryOperatorLambda = numero -> numero + numero * 2;
		System.out.println(unaryOperatorLambda.aplicar(Integer.valueOf(150)));
		System.out.println("Lambdas con Unary Operator con herencia");
		IPersonaUnaryOperatorFunction<Integer> unaryOperatorLambda2 = numero -> numero + numero * 2;
		System.out.println(unaryOperatorLambda2.aplicar(Integer.valueOf(155)));
		//Métodos referenciados 
		System.out.println("Métodos Referenciados");
		IPersonaUnaryOperatorFunction<Empleado> unaryOperatorLambda3 = met::procesar;
		System.out.println(unaryOperatorLambda3.aplicar(empleado));
		
		
		System.out.println("****************Implementacion de interfaces funcionales mediate libreria Java****************");
		
		//1.Supplier
		System.out.println("Supplier JAVA");
		Stream<String> lista = Stream.generate(()->"159357147963" + " pais").limit(20);
		lista.forEach(cadena -> System.out.println(cadena));
		
		//2.Consumer
		System.out.println("Consumer JAVA");
		List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5,6,67,8,5,4,85,74);
		listaNumeros.forEach(numero -> {
			System.out.println("Se inserta");
			System.out.println(numero);
			});
		
		//3.Predicate
		System.out.println("Predicate JAVA");
		Stream<Integer> listaFiltradaStream = listaNumeros.stream().filter(numero->{
			return numero >=10;
		});
		listaFiltradaStream.forEach(numero->System.out.println(numero));
		
		//4.Function
		System.out.println("Function JAVA");
		Stream<String> listaCambiada = listaNumeros.stream().map(numero->{
			numero = numero*100/50;
			return "Numero: " + numero.toString();
		});
		listaCambiada.forEach(cadena -> System.out.println(cadena));
		
		
		Ciudadano ciudadano1 = new Ciudadano();
		ciudadano1.setNombre("Edlith");
		ciudadano1.setApellido("Vinueza");
		ciudadano1.setProvincia("Pichincha");
		
		Ciudadano ciudadano2 = new Ciudadano();
		ciudadano2.setNombre("Daniela");
		ciudadano2.setApellido("Teran");
		ciudadano2.setProvincia("Pichincha");
		
		Ciudadano ciudadano3 = new Ciudadano();
		ciudadano3.setNombre("Juan");
		ciudadano3.setApellido("Ley");
		ciudadano3.setProvincia("Pichincha");
		
		List<Ciudadano> listaCiudadanos = Arrays.asList(ciudadano1,ciudadano2,ciudadano3);
		Stream<Empleado> listaEmpleado =  listaCiudadanos.stream().map(ciu -> {
			Empleado e = new Empleado();
			e.setNombreCompleto(ciu.getNombre()+" "+(ciu.getApellido()));
			if (ciu.getProvincia().compareTo("Pichincha") == 0) {
				e.setPais("Ecuador");
			}
			return e;
		});
		
		listaEmpleado.forEach(em -> System.out.println(em));
		
		//5.Unary Operator 
		System.out.println("Unary Operator JAVA");
		Stream<Integer> listaNumeros2 = listaNumeros.stream().map(numero->{
			numero = numero*100/50;
			return numero;
		});
		listaNumeros2.forEach(numero ->System.out.println(numero));
		
		
	}
}

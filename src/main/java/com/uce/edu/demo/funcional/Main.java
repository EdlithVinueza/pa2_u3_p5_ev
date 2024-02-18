package com.uce.edu.demo.funcional;

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
		

	}
}

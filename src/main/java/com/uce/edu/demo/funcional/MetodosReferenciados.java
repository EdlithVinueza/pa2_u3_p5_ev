package com.uce.edu.demo.funcional;

public class MetodosReferenciados {
	
	public String obtenerId() {
		// TODO Auto-generated method stub
		String cedula = "159357147963";
		cedula = cedula + " privincia";
		return cedula;
	}
	
	public void procesar(String cadena) {
		System.out.println(cadena);
		System.out.println("Se proceso la cadena");
	}
	
	public boolean evaluar(String cadena) {
		return "Edlith".contains(cadena);
	}
	
	public boolean evaluar(Integer numero) {
		return 8 == numero;
	}
	
	public Ciudadano cambiarCiudadano(Empleado empleado) {
		Ciudadano ciudadano = new Ciudadano();
		ciudadano.setNombre(empleado.getNombreCompleto().split(" ")[0]);
		ciudadano.setApellido(empleado.getNombreCompleto().split(" ")[1]);
		ciudadano.setProvincia("Chimborazo");
		return ciudadano;
	}
	
	public Empleado procesar(Empleado empleado) {
		empleado.setNombreCompleto(empleado.getNombreCompleto()+" "+empleado.getPais());
		empleado.setPais("Pais de nacimiento: "+empleado.getPais());
		return empleado;
	}

}

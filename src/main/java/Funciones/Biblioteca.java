package Funciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import ClasesPrincipales.Arrendado;
import ClasesPrincipales.Edificio;
import ClasesPrincipales.Encargado;
import ClasesPrincipales.Local;
import ClasesPrincipales.Piso;

public class Biblioteca {
	
	
	//Verificar si una cadena solo contiene numeros.
	public static boolean esNumero(String valor) {
		
		for(int i =0;i<valor.length();i++) {
			if(!((int)valor.charAt(i) >= 48 && (int)valor.charAt(i)<=57)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean esDecimal(String valor) {
		String[] numeros = valor.split("\\.");
		
		if(numeros.length == 1) {
			if(esNumero(numeros[0])) {
				return true;
			}
		}
		else if(numeros.length == 2) {
			if( esNumero(numeros[0]) && esNumero(numeros[1]) ) {
				return true;
			}
		}
		
		
		return false;
	}
	
	
	public static Encargado obtener_datos_encargado() throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		String nombre,apellido,cedula;
		String correo,telefono,telefonoMovil;
		LocalDate fecha;
		String dia,mes,anio;

			
		System.out.print("Nombre del encargado: "); nombre = entrada.readLine();
		System.out.print("Apellido del encargado: "); apellido = entrada.readLine();
		System.out.print("Cedula del encargado: "); cedula = entrada.readLine();
		System.out.print("Telefono del encargado: "); telefono = entrada.readLine();
		System.out.print("Telefono movil del encargado: "); telefonoMovil = entrada.readLine();
		System.out.print("Correo del encargado: "); correo = entrada.readLine();
		
		
		
		do {
			System.out.println("Debe ser un numero!\n");
			System.out.print("Ingrese dia de asignacion: ");  dia = entrada.readLine();
		}while(!esNumero(dia));
		
		do {
			System.out.println("Debe ser un numero!\n");
			System.out.print("Ingrese mes de asignacion: "); mes = entrada.readLine();
		}while(!esNumero(mes));
		do {
			System.out.println("Debe ser un numero!\n");
			System.out.print("Ingrese año de asignacion: "); anio = entrada.readLine();
		}while(!esNumero(anio));
		
		
		
		fecha = LocalDate.of(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia));
		

		
		return  new Encargado(cedula,nombre,apellido,correo,telefono,telefonoMovil,fecha);

		
	}
	
	public static Edificio obtener_datos_edificio() throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String codigo, identificacion, estado, direccion, cedulaEncargado;
		String dia_creacion,mes_creacion,anio_creacion;
		LocalDate fechaCreacion;
		
		
		System.out.print("Codigo del edificio: "); codigo = entrada.readLine();
		System.out.print("Nombre del edificio: "); identificacion = entrada.readLine();
		System.out.print("Estado en el que se encuentra ubicado: "); estado = entrada.readLine();
		System.out.print("Direccion del edificio: "); direccion = entrada.readLine();
		System.out.print("Cedula del encargado: "); cedulaEncargado = entrada.readLine();
		
		do {
			System.out.println("Debe ser un numero!\n");
			System.out.print("Dia de creacion del edificio: "); dia_creacion = entrada.readLine();
			
		}while(!esNumero(dia_creacion));
		
		do {
			System.out.println("Debe ser un numero!\n");
			System.out.print("Mes de creacion del edificio: "); mes_creacion = entrada.readLine();
		}while(!esNumero(mes_creacion));
		do {
			System.out.println("Debe ser un numero!\n");
			System.out.print("Año de creacion del edificio: "); anio_creacion = entrada.readLine();
		}while(!esNumero(anio_creacion));
		
		
		
		fechaCreacion = LocalDate.of(Integer.parseInt(anio_creacion), Integer.parseInt(mes_creacion), Integer.parseInt(dia_creacion));

		return new Edificio(codigo,identificacion,estado,direccion,cedulaEncargado,fechaCreacion);
		
	}
	
	public static Piso obtener_datos_piso() throws IOException{
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		String numero_piso,cedula_encargado;
		
		
		do {
			System.out.println("<---INGRESE UN NUMERO--->");
			System.out.print("Numero de piso: "); numero_piso = entrada.readLine();
		}while(!Biblioteca.esNumero(numero_piso));
		System.out.print("Cedula del encargado: "); cedula_encargado = entrada.readLine();
				
		return new Piso(Integer.parseInt(numero_piso),cedula_encargado,LocalDate.now());
	}
	
	public static Local obtener_datos_local() throws IOException{
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String codigoLocal, cedulaArrendatario,montoMensualidad;
	    
		System.out.print("Ingrese codigo del local: "); codigoLocal = entrada.readLine();
		System.out.print("Ingrese cedula del arrendantario: "); cedulaArrendatario = entrada.readLine();
		do {
			System.out.println("<---INGRESE SOLO NUMEROS Y SEPARE POR PUNTOS LOS DECIMALES'.'--->");
			System.out.print("Ingrese monto de la mensualidad: "); montoMensualidad = entrada.readLine();
		}while(!Biblioteca.esDecimal(montoMensualidad));
		
		
		
		return new Local(codigoLocal,cedulaArrendatario,Float.parseFloat(montoMensualidad));
	}
	
	
	public static Arrendado obtener_datos_arrendado() throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String cedula, nombre, apellido, correo, telefono,dia_asignado,mes_asignado,anio_asignado;
	
		LocalDate fechaAsignado;
		
		System.out.print("Cedula del arrendado: "); cedula = entrada.readLine();
		System.out.print("Nombre del arrendado: "); nombre = entrada.readLine();
		System.out.print("Apellido del arrendado: "); apellido = entrada.readLine();
		System.out.print("Correo del arrendado: "); correo = entrada.readLine();
		System.out.print("Telefono del arrendado: "); telefono = entrada.readLine();
		
		do {
			System.out.println("<---INGRESE NUMEROS--->");
			System.out.print("Dia de asignacion: "); dia_asignado = entrada.readLine();
		}while(!Biblioteca.esNumero(dia_asignado));
		
		do {
			System.out.println("<---INGRESE NUMEROS--->");
			System.out.print("Mes de asignacion: "); mes_asignado = entrada.readLine();
		}while(!Biblioteca.esNumero(mes_asignado));
		
		do {
			System.out.println("<---INGRESE NUMEROS--->");
			System.out.print("Año de asignacion: "); anio_asignado = entrada.readLine();
		}while(!Biblioteca.esNumero(anio_asignado));
		
		fechaAsignado = LocalDate.of(Integer.parseInt(anio_asignado), Integer.parseInt(mes_asignado), Integer.parseInt(dia_asignado));
		
		return new Arrendado(cedula,nombre,apellido,correo,telefono,fechaAsignado);
 		
	}

	public static void main(String[] args) throws IOException {
		
		
		
	}

}

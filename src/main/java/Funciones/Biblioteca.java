/**
* Hecho por: Ruben Fuentes 26.326.992 y Alexander Noriega 27.280.176
* Carrera: Informática
* Materia: Algoritmos y Estructuras de Datos II
*/
package Funciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import ClasesPrincipales.*;

public class Biblioteca {
	
	
	//Verificar si una cadena solo contiene numeros.
	
	/**
    *
    * @return
    * 
    */
	public static boolean esNumero(String valor) {
		
		for(int i =0;i<valor.length();i++) {
			if(!((int)valor.charAt(i) >= 48 && (int)valor.charAt(i)<=57)) {
				return false;
			}
		}
		return true;
	}
	/**
    *
    * @return
    * 
    * Verifica si una cadena, es un numero con decimales.
    * 
    */
	
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
	/**
    *
    * @return
    * 
    * le pide al usuario un numero y lo retorna.
    * 
    */
	
	public static Integer leerDatoEntero(String mensaje) throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String opcion;
		do {
			System.out.println("\n<---INGRESE SOLO NUMEROS--->");
			System.out.print(mensaje); opcion = entrada.readLine();
		}while(!Biblioteca.esNumero(opcion));
		
		return Integer.parseInt(opcion);
	}
	
	
	/**
    *
    * 
    * 
    * OBTENER
    * Encada metodo se obtienen los datos de una clase y se retorna un objeto de la misma.
    * 
    */
	
	/**
    *
    * @return
    * 
    */
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
	
	
	
	/**
    *
    * @return
    * 
    */
	
	
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
	
	
	/**
    *
    * @return
    * 
    */
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
	
	/**
    *
    * @return
    * 
    */
	
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
	
	
	/**
    *
    * @return
    * 
    */
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
	
	
	/**
    *
    * @return
    * 
    */
	public static Pago obtener_datos_pago(Float monto_alquiler) throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		Integer dia_pago,mes_pago,anio_pago;
		Float monto_restante;
		String monto_cancelado,cedula_arrendatario,mes;
		
		System.out.print("Ingrese la cedula del arrendatario:"); cedula_arrendatario = entrada.readLine();
		System.out.print("Ingrese mes del pago: "); mes = entrada.readLine();
		
		dia_pago = leerDatoEntero("Ingrese dia que se hace el pago: ");
		mes_pago = leerDatoEntero("Ingrese mes que se hace el pago: ");
		anio_pago = leerDatoEntero("Ingrese año que se hace el pago: ");
		
		do {
			System.out.println("<---INGRESE SOLO NUMEROS Y SEPARE POR PUNTOS LOS DECIMALES'.'--->");
			System.out.print("Ingrese monto cancelado: "); monto_cancelado = entrada.readLine();
		}while(!Biblioteca.esDecimal(monto_cancelado));
		monto_restante = monto_alquiler - Float.parseFloat(monto_cancelado);
		
		
		return new Pago(mes,LocalDate.of(anio_pago, mes_pago, dia_pago),Float.parseFloat(monto_cancelado),monto_restante,cedula_arrendatario);
	}

	/**
    *
    * 
    * 
    * MODIFICAR
    * AL igual que en el obtener se pregunta que datos se quieren modificar y se rretorna el objeto
    * con los datos modificados.
   * 
    */
	
	/**
    *
    * @return
    * 
    */
	public static Encargado modificar_encargado(Encargado encargado_actual) throws IOException {
		Integer opcion;
		String[] fechaAsignacion_actual = encargado_actual.getFechaContrato().toString().split("\\-");
		
		Integer dia_asignacion = Integer.parseInt(fechaAsignacion_actual[2]),
		mes_asignacion = Integer.parseInt(fechaAsignacion_actual[1]),
		anio_asignacion  = Integer.parseInt(fechaAsignacion_actual[0]);
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println("Modificar nombre del encargado?");
			System.out.println("1. Si");
			System.out.println("2. No");
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			System.out.print("Ingrese nuevo nombre: "); String nuevo_nombre = entrada.readLine();
			encargado_actual.setNombre(nuevo_nombre);
		}
		
		
		do {
			System.out.println("Modificar apellido del encargado?"); 
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			System.out.print("Ingrese nuevo apellido: "); String nuevo_apellido = entrada.readLine();
			encargado_actual.setApellido(nuevo_apellido);
		}
		
		do {
			System.out.println("Modificar correo del encargado?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			System.out.print("Nuevo correo: "); String nuevo_correo = entrada.readLine();
			encargado_actual.setCorreo(nuevo_correo);
		}
		
		do {
			System.out.println("Modificar telefono del encargado?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			System.out.print("Nuevo telefono: "); String nuevo_telefono = entrada.readLine();
			encargado_actual.setTelefono(nuevo_telefono);
		}
		
		do {
			System.out.println("Modificar telefono movil del encargado?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			System.out.print("Nuevo telefono movil: "); String nuevo_telefono_movil = entrada.readLine();
			encargado_actual.setTelefonoMovil(nuevo_telefono_movil);
		}
		
		do {
			System.out.println("Modificar dia de asignacion del encargado?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			dia_asignacion = leerDatoEntero("Ingrese nuevo dia de asignacion: ");
			
		}
		
		do {
			System.out.println("Modificar mes de asignacion del encargado?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
			
		}while(opcion != 1 && opcion != 2);
		
		if(opcion == 1) {
			mes_asignacion = leerDatoEntero("Ingrese nuevo mes de asignacion: " );
		}
		
		do {
			System.out.println("Modificar Año de asignacion del encargado?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
		}while(opcion != 1 && opcion !=2 );
		
		if(opcion == 1) {
			anio_asignacion = leerDatoEntero("Ingrese nuevo año de asignacion: "); 
		}
		encargado_actual.setFechaContrato(LocalDate.of(anio_asignacion, mes_asignacion, dia_asignacion));
		
		
		return encargado_actual;
	}
	
	
	/**
    *
    * @return
    * 
    */
	public static Edificio modificar_datos_edificio(Edificio edificio_actual)throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String[] fechaCreacion = edificio_actual.getFechaCreacion().toString().split("\\-");
		
		Integer dia_creacion = Integer.parseInt(fechaCreacion[2]),
		mes_creacion = Integer.parseInt(fechaCreacion[1]),
		anio_creacion  = Integer.parseInt(fechaCreacion[0]);
		Integer opcion;
		
		
		do {
			System.out.println("Modificar nombre del edificio?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			System.out.print("Ingrese nuevo nombre del edificio: "); String nuevo_nombre = entrada.readLine();
			edificio_actual.setIdentificacion(nuevo_nombre);
		}
		
		do {
			System.out.println("Modificar direccion del edificio?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			System.out.print("Ingrese nueva direccion del edificio: "); String nueva_direccion = entrada.readLine();
			edificio_actual.setDireccion(nueva_direccion);
		}
		
		do {
			System.out.println("Modificar estado del edificio?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			System.out.print("Ingrese nuevo estado del edificio: "); String nuevo_estado = entrada.readLine();
			edificio_actual.setEstado(nuevo_estado);
		}
		
		do {
			System.out.println("Modificar la cedula del encargado?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			System.out.print("Ingrese nueva cedula del encargado del edificio: "); String nueva_cedula = entrada.readLine();
			edificio_actual.setCedulaEncargado(nueva_cedula);
		}
		do {
			System.out.println("Modificar dia de creacion?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			dia_creacion = leerDatoEntero("Ingrese nuevo dia de creacion: ");
		}
		
		do {
			System.out.println("Modificar mes de creacion?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			mes_creacion = leerDatoEntero("Ingrese nuevo mes de creacion: ");
		}
		
		do {
			System.out.println("Modificar año de creacion?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			anio_creacion = leerDatoEntero("Ingrese nuevo año de creacion: ");
		}
		
		edificio_actual.setFechaCreacion(LocalDate.of(anio_creacion, mes_creacion, dia_creacion));
		
		return edificio_actual;
	}
	
	
	/**
    *
    * @return
    * 
    */
	public static Piso modificar_datos_piso(Piso piso_actual) throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		Integer opcion;
		String[] fechaCreacion = piso_actual.getFechaRegistro().toString().split("\\-");
		
		Integer dia_creacion = Integer.parseInt(fechaCreacion[2]),
		mes_creacion = Integer.parseInt(fechaCreacion[1]),
		anio_creacion  = Integer.parseInt(fechaCreacion[0]);
		
		
		
		do {
			System.out.println("Modificar numero de piso?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			Integer nuevo_numero_piso = leerDatoEntero("Ingrese nuevo numero de piso: ");
			piso_actual.setNumeroPiso(nuevo_numero_piso);
		}
		
		do {
			System.out.println("Modificar cedula del encargado?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			System.out.print("Ingrese nuevo numero de cedula del encargado: "); String nueva_cedula_encargado = entrada.readLine();
			piso_actual.setCedulaEncargado(nueva_cedula_encargado);
		}
		
		do {
			System.out.println("Modificar dia de registro?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			dia_creacion = leerDatoEntero("Ingrese nuevo dia de registro: ");
		}
		
		do {
			System.out.println("Modificar mes de registro?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			mes_creacion = leerDatoEntero("Ingrese nuevo mes de registro: ");
		}
		
		do {
			System.out.println("Modificar año de registro?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			anio_creacion = leerDatoEntero("Ingrese nuevo año de registro: ");
		}
		
		piso_actual.setFechaRegistro(LocalDate.of(anio_creacion, mes_creacion, dia_creacion));
		
		
		return piso_actual;
	}
	
	
	/**
    *
    * @return
    * 
    */
	public static Local modificar_datos_local(Local local_actual) throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String nueva_mensualidad;
		Integer opcion;
		do {
			System.out.println("Modificar codigo del local?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			System.out.print("Ingrese nuevo codigo del local: "); String nuevo_codigo = entrada.readLine();
			local_actual.setCodigoLocal(nuevo_codigo);
		}
		
		do {
			System.out.println("Modificar cedula del Arredentario del local?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		
		if(opcion == 1) {
			System.out.print("Ingrese nueva cedula: "); String nueva_cedula = entrada.readLine();
			local_actual.setCedulaArrendatario(nueva_cedula);
		}
		
		do {
			System.out.println("Modificar monto de mensualidad del local?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			do {
				System.out.println("\n<---INGRESE SOLO NUMEROS Y DECIMALES SEPARADOS POR PUNTO '.'--->");
				System.out.print("Ingrese nueva mensualidad: "); nueva_mensualidad = entrada.readLine();
			}while(!esDecimal(nueva_mensualidad));
			local_actual.setMontoMensualidad(Float.parseFloat(nueva_mensualidad));
		}
		
		
		
		return local_actual;
	}
	
	
	/**
    *
    * @return
    * 
    */

	public static Arrendado modificar_datos_arrendado(Arrendado arrendado_actual) throws IOException {
		Integer opcion;
		String[] fechaAsignacion_actual = arrendado_actual.getFechaAsignacion().toString().split("\\-");
		
		Integer dia_asignacion = Integer.parseInt(fechaAsignacion_actual[2]),
		mes_asignacion = Integer.parseInt(fechaAsignacion_actual[1]),
		anio_asignacion  = Integer.parseInt(fechaAsignacion_actual[0]);
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			System.out.println("Modificar el nombre del arrendado?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			System.out.print("Ingrese nuevo nombre del arrendado: "); String nuevo_nombre = entrada.readLine();
			arrendado_actual.setNombre(nuevo_nombre);
		}
		
		do {
			System.out.println("Modificar apellido del arrendado?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			System.out.print("Ingrese nuevo apellido del arrendado: "); String nuevo_apellido = entrada.readLine();
			arrendado_actual.setApellido(nuevo_apellido);
		}
		
		do {
			System.out.println("Modificar correo del arrendado?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			System.out.print("Ingrese nuevo correo del arrendado: "); String nuevo_correo = entrada.readLine();
			arrendado_actual.setCorreo(nuevo_correo);
		}
		
		do {
			System.out.println("Modificar telefono del arrendado?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			System.out.print("Ingrese nuevo telefono del arrendado: "); String nuevo_telefono = entrada.readLine();
			arrendado_actual.setTelefono(nuevo_telefono);
		}
		
		do {
			System.out.println("Modificar dia de asignacion?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			dia_asignacion = leerDatoEntero("Ingrese nuevo dia de asignacion: ");
		}
		
		do {
			System.out.println("Modificar mes de asignacion?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			mes_asignacion = leerDatoEntero("Ingrese nuevo mes de asignacion: ");
		}
		
		do {
			System.out.println("Modificar año de asignacion?");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			opcion = leerDatoEntero("Ingrese opcion: ");
			
		}while(opcion != 1 && opcion != 2);
		if(opcion == 1) {
			anio_asignacion = leerDatoEntero("Ingrese nuevo año de asignacion: ");
		}
		
		arrendado_actual.setFechaAsignacion(LocalDate.of(anio_asignacion, mes_asignacion, dia_asignacion));
	 	
		
		return arrendado_actual;
	}
	
	

	

}

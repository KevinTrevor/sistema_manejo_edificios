/**
* Hecho por: Ruben Fuentes 26.326.992 y Alexander Noriega 27.280.176
* Carrera: Informática
* Materia: Algoritmos y Estructuras de Datos II
*/
package ClasesPrincipales;

import Funciones.Biblioteca;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aplicacion {
	private Empresa empresa;
	
	
	public Aplicacion() throws IOException {
		this.empresa = new Empresa();
		this.IngresarAlSistema();
	}
	
	
	public void RegistrarUsuario() throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\n<---REGISTRAR USUARIO--->\n");
		System.out.print("Nombre de usuario: "); entrada.readLine();
		System.out.print("Clave del usuario: "); entrada.readLine();
		
		System.out.println("\n<---REGISTRADO EXITOSAMENTE!!!--->\n");
		this.IngresarAlSistema();
		
		
		
	}
	
	public  void IngresarAlSistema() throws IOException {
    	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String opcion;
		
		
		
		do {
			System.out.println("\n<----- GESTION DE EDIFICIOS ----->\n");
			System.out.println("1. Ingresar al sistema");
			System.out.println("2. Registrar un usuario");
			System.out.println("0. Salir del programa.\n");
			
			System.out.print("Ingrese opcion: "); opcion = entrada.readLine();
			
			
			System.out.println("Opcion digitada: "+opcion+" Es numero: "+Biblioteca.esNumero(opcion));
			while(!Biblioteca.esNumero(opcion)) {
				System.out.println("Ingrese un numero!");
				System.out.print("Ingrese opcion: "); opcion = entrada.readLine();
				
			}
			switch(Integer.parseInt(opcion)) {
			case 1:
				this.menuEmpresa();
			break;
			case 2:
				this.RegistrarUsuario();
			break;
			case 0:
				System.out.println("\n<---FIN DEL PROGRAMA--->\n");
				System.exit(0);
			break;
			}
			
		}while(Integer.parseInt(opcion) != 0);
		    	
    	
    }
	
	public void menuEmpresa() throws IOException {
    	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String opcion;
		
		
		do {
			System.out.println("\n<----- MENU PRINCIPAL ----->\n");
			System.out.println("1. Menu de Edificios");
			System.out.println("2. Menu de Pisos");
			System.out.println("3. Menu de Local");
			System.out.println("4. Menu de Encargados");
			System.out.println("5. Menu de Arredentarios");
			System.out.println("0. Menu anterior\n");
			
			
			System.out.print("Ingrese opcion: ");opcion = entrada.readLine();
			while(!Biblioteca.esNumero(opcion)) {
				System.out.println("\n<---Ingrese un numero!--->");
				System.out.print("Ingrese opcion: "); opcion = entrada.readLine();
				
			}
			switch(Integer.parseInt(opcion)) {
			case 1:
				this.menuEdificio();
			break;
			case 2:
				this.menuPiso();	
			break;
			case 3:
				this.menuLocal();
			break;
			case 4:
				this.menuEncargado();
			break;
			case 5:
				this.menuArrendatario();
			break;
			}
			
			
		}while(Integer.parseInt(opcion) != 0);

    }
	
	public  void menuEdificio() throws IOException {
    	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		Integer opcion;
		String codigo_edificio;
		do {
			System.out.println("\n<----- GESTION DE EDIFICIO ----->\n");
			System.out.println("1. Registrar Edificio");
			System.out.println("2. Modificar Edificio");
			System.out.println("3. Eliminar Edificio");
			System.out.println("4. Mostrar Edificio");
			System.out.println("5. Monto recaudado en todos los edificios en un mes");
			System.out.println("0. Menu anterior\n");
			
			
			opcion = Biblioteca.leerDatoEntero("Ingrese opcion: ");
			switch(opcion) {
			case 1:
				Edificio nuevo_edificio = Biblioteca.obtener_datos_edificio();
				this.empresa.agregarEdificios(nuevo_edificio);
				
				System.out.println("\nPresiona enter para continuar\n"); entrada.readLine();
			break;
			case 2:
				System.out.print("Ingrese el codigo del edificio: "); codigo_edificio = entrada.readLine();	
				Edificio edificio_actual = this.empresa.getEdificios().buscarDato(codigo_edificio);

				if(edificio_actual != null) {
					edificio_actual = Biblioteca.modificar_datos_edificio(edificio_actual);
					this.empresa.modificarEdificio(edificio_actual.getCodigo(), 
							edificio_actual.getIdentificacion(), 
							edificio_actual.getEstado(), 
							edificio_actual.getDireccion(), 
							edificio_actual.getCedulaEncargado(), 
							edificio_actual.getFechaCreacion());
	
				}
				System.out.println("\nPresiona enter para continuar\n"); entrada.readLine();
				
			break;
			case 3:
				System.out.print("Ingrese el codigo del edificio: "); codigo_edificio = entrada.readLine();
				
				this.empresa.eliminarEdificio(codigo_edificio);
				
				System.out.println("\nPresiona enter para continuar\n"); entrada.readLine();
			break;
			case 4:
				System.out.print("Ingrese el codigo del edificio: "); codigo_edificio = entrada.readLine();
				Edificio edificio = this.empresa.getEdificios().buscarDato(codigo_edificio);
				if(edificio != null) {
					System.out.println(edificio.toString());
				}
				
				System.out.println("\nPresiona enter para continuar\n"); entrada.readLine();
			break;
			case 5:
				String mes;
				System.out.println("Ingrese un mes: "); mes = entrada.readLine();
				this.empresa.getMontoEnMes(mes);
				
				System.out.println("\nPresiona enter para continuar\n"); entrada.readLine();
			break;
			}
		}while(opcion != 0);
    	
    }
	
	public void menuPiso() throws IOException {
    	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String opcion,codigo_edificio;
		Integer numero_piso;
		do {
			System.out.println("\n<----- GESTION DE PISOS ----->\n");
			System.out.println("1. Registrar Piso");
			System.out.println("2. Modificar Piso");
			System.out.println("3. Eliminar Piso");
			System.out.println("4. Buscar un piso");
			System.out.println("0. Menu anterior\n");
			
			
			System.out.print("Ingrese opcion: ");opcion = entrada.readLine();
			while(!Biblioteca.esNumero(opcion)) {
				System.out.println("\n<---Ingrese un numero!--->");
				System.out.print("Ingrese opcion: "); opcion = entrada.readLine();
				
			}
			switch(Integer.parseInt(opcion)) {
			case 1:
				
				System.out.print("Ingrese codigo del edificio: "); codigo_edificio = entrada.readLine();
				Piso nuevo_piso = Biblioteca.obtener_datos_piso();
				
				this.empresa.agregarPisosEnEdificio(codigo_edificio, nuevo_piso);
				
				System.out.println("\nPresiona enter para continuar\n"); entrada.readLine();
			break;
			case 2:
				System.out.print("Ingrese el codigo del edificio: "); codigo_edificio = entrada.readLine();
				
				numero_piso = Biblioteca.leerDatoEntero("Ingrese numero de piso: ");
				
				
				System.out.println("\nPresiona enter para continuar\n"); entrada.readLine();
			break;
			case 3:
				System.out.print("Ingrese el codigo del edificio: "); codigo_edificio = entrada.readLine();
				numero_piso = Biblioteca.leerDatoEntero("Ingrese numero de piso: ");
				this.empresa.eliminarPiso(codigo_edificio, numero_piso);
				
				
				
				System.out.println("\nPresiona enter para continuar\n"); entrada.readLine();
			break;
			case 4:
				System.out.print("Ingrese el codigo del edificio: "); codigo_edificio = entrada.readLine();
				Edificio edificio = this.empresa.getEdificios().buscarDato(codigo_edificio);
				if(edificio != null) {
					numero_piso = Biblioteca.leerDatoEntero("Ingrese numero de piso: ");
					Piso piso = this.empresa.getEdificios().buscarDato(codigo_edificio).getPisos().buscarDato(numero_piso);
					System.out.println(piso.toString());
					
				}
				System.out.println("\nPresiona enter para continuar\n"); entrada.readLine();
				
				
			break;
			}
		}while(Integer.parseInt(opcion) != 0);
    	
    }
	
	public  void menuLocal() throws IOException {
    	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String codigo_edificio,numero_piso,codigo_local;
		Integer opcion;
		do {
			System.out.println("\n<----- GESTION DE LOCAL ----->\n");
			System.out.println("1. Registrar Local");
			System.out.println("2. Modificar Local");
			System.out.println("0. Menu anterior\n");
			
			
			opcion = Biblioteca.leerDatoEntero("Ingrese opcion: ");
			switch(opcion) {
			case 1:
				Local nuevo_local = Biblioteca.obtener_datos_local();

				System.out.println("\nPresiona enter para continuar\n"); entrada.readLine();
			break;
			
			case 2:
				System.out.print("Ingrese codigo del edificio: "); codigo_edificio = entrada.readLine();
				do {
					System.out.print("Ingrese numero del piso: "); numero_piso = entrada.readLine();
				}while(!Biblioteca.esNumero(numero_piso));
				System.out.print("Ingrese codigo del local: "); codigo_local = entrada.readLine();
				
				System.out.println("\n<---Modificado exitosamente--->\n");
			break;
			}
		}while(opcion != 0);
    	
    }
	
	public  void menuEncargado() throws IOException {
    	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String cedula_encargado;
		Integer opcion;
		do {
			System.out.println("\n<----- GESTION DE ENCARGADO ----->\n");
			System.out.println("1. Registrar Encargado");
			System.out.println("2. Modificar Encargado");
			System.out.println("0. Menu anterior\n");
			
			
			opcion = Biblioteca.leerDatoEntero("Ingrese opcion: ");
			switch(opcion) {
			case 1:
				Encargado nuevo_encargado = Biblioteca.obtener_datos_encargado();
				
				this.empresa.agregarEncargado(nuevo_encargado);
				System.out.println("\nPresiona enter para continuar\n"); entrada.readLine();
			break;
			case 2:
				System.out.print("Ingrese la cedula del encargado: "); cedula_encargado = entrada.readLine();
				Encargado encargado_actual = this.empresa.getEncargados().buscarDato(cedula_encargado);
				
				if(encargado_actual != null) {
					encargado_actual = Biblioteca.modificar_encargado(encargado_actual);
					
					this.empresa.modificarEncargado(
							encargado_actual.getCedula(), 
							encargado_actual.getNombre(), 
							encargado_actual.getApellido(), 
							encargado_actual.getCorreo(), 
							encargado_actual.getTelefono(), 
							encargado_actual.getTelefonoMovil(), 
							encargado_actual.getFechaContrato());
				}
				
				
				System.out.println("\nPresiona enter para continuar\n"); entrada.readLine();
			break;
			}
		}while(opcion != 0);
    	
    }
    public  void menuArrendatario() throws IOException {
    	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String cedula_arrendado;
		Integer opcion;
		do {
			System.out.println("\n<----- GESTION DE ARREDANTARIO ----->\n");
			System.out.println("1. Registrar Arrendatario");
			System.out.println("2. Modificar Arrendetario");
			System.out.println("0. Menu anterior\n");
			
			
			opcion = Biblioteca.leerDatoEntero("Ingrese opcion: ");
			switch(opcion) {
			case 1:
				Arrendado nuevo_arrendado = Biblioteca.obtener_datos_arrendado();
				
				
				this.empresa.agregarArrendatario(nuevo_arrendado);

				System.out.println("\nPresiona enter para continuar\n"); entrada.readLine();
			break;
			case 2:
				System.out.print("Ingrese la cedula del arrendado: "); cedula_arrendado = entrada.readLine();
				
				Arrendado arrendado_actual = this.empresa.getArrendatarios().buscarDato(cedula_arrendado);
				
				if(arrendado_actual != null) {
					arrendado_actual = Biblioteca.modificar_datos_arrendado(arrendado_actual);
					
					this.empresa.modificarArrendatario(arrendado_actual.getCedula(), 
							arrendado_actual.getNombre(), 
							arrendado_actual.getApellido(), 
							arrendado_actual.getCorreo(), 
							arrendado_actual.getTelefono(), 
							arrendado_actual.getFechaAsignacion());
				}
				
				
				System.out.println("\nPresiona enter para continuar\n"); entrada.readLine();
			break;
			}
		}while(opcion != 0);
    	
    }
	
	
	public static  void main(String[] args) throws IOException {
		Aplicacion aplicacion = new Aplicacion();
	}
	
}

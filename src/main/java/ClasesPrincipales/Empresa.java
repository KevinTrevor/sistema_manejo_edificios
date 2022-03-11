/**
* Hecho por: Ruben Fuentes 26.326.992 y Alexander Noriega 27.280.176
* Carrera: Informática
* Materia: Algoritmos y Estructuras de Datos II
*/
package ClasesPrincipales;

import Lista.*;
import java.time.LocalDate;

/**
 *
 * 
 */
public class Empresa {
    private ListaEnlazada<Edificio> edificios;
    private ListaEnlazada<Encargado> encargados;
    private ListaEnlazada<Arrendado> arrendatarios;
    
    public Empresa() {
        this.edificios = new ListaEnlazada<>();
        this.encargados = new ListaEnlazada<>();
        this.arrendatarios = new ListaEnlazada<>();
    }
    
    // MOSTRAR

    /**
     *
     * @return
     */
    
    public String mostrarEdificios(){
        String edificiosStr = "";
        Nodo<Edificio> edificio = this.getEdificios().getInicio();
        while(edificio != null){
            edificiosStr = edificiosStr + 
                    this.getEncargados().buscarDato(edificio.getInfo().getCedulaEncargado()).toString() 
                    + "\n" + edificio.getInfo().toString()
                    + "\n=========================================\n";
            edificio = edificio.getSiguiente();
        }
        return edificiosStr;
    }
    
    @Override
    public String toString(){
        return this.mostrarEdificios();
    }
    
    // MODIFICAR
    
    public void modificarEncargado(String cedula, String nombre, String apellido, String correo, 
            String telefono, String telefonoMovil, LocalDate fechaContrato){
        
        Encargado encargadoBuscado = this.getEncargados().buscarDato(cedula);
        if (encargadoBuscado != null) {
            encargadoBuscado.modificarEncargado(nombre, apellido, correo, telefono, 
                    telefonoMovil, fechaContrato);
            this.getEncargados().modificarDato(cedula, encargadoBuscado);
        }
    }
    
    public void modificarArrendatario(String cedula, String nombre, String apellido, 
            String correo, String telefono, LocalDate fechaAsignacion){
        Arrendado arrendatarioBuscado = this.getArrendatarios().buscarDato(cedula);
        if (arrendatarioBuscado != null) {
            arrendatarioBuscado.modificarArrendatario(nombre, apellido, correo, telefono, 
                     fechaAsignacion);
            this.getArrendatarios().modificarDato(cedula, arrendatarioBuscado);
        }
    }
    
    public void modificarLocal(String codigo, Integer numeroPiso, String codigoLocal, String cedulaArrendatario, 
            Float montoMensualidad){
        
        Edificio edificioBuscado = this.getEdificios().buscarDato(codigo);
        if (edificioBuscado != null){
            edificioBuscado.modificarLocal(numeroPiso, codigoLocal, cedulaArrendatario, 
                    montoMensualidad);
            this.getEdificios().modificarDato(codigo, edificioBuscado);
        }
        else{
            System.out.println("El edificio del local a modificar no se encuentra registrado.");
        }
    }
    
    public void modificarEdificio(String codigo, String identificacion, String estado, 
            String direccion, String cedulaEncargado, LocalDate fechaCreacion){
        
        Edificio edificioBuscado = this.getEdificios().buscarDato(codigo);
        if (edificioBuscado != null) {
            edificioBuscado.modificarEdificio(identificacion, estado, direccion, 
                    cedulaEncargado, fechaCreacion);
            this.getEdificios().modificarDato(codigo, edificioBuscado);
        }
    }
    
    // ELIMINAR

    /**
     *
     * @param codigo
     */
    
    public void eliminarEdificio(String codigo){
        this.getEdificios().eliminarDato(codigo);
    }
    
    /**
     *
     * @param codigo
     * @param numeroPiso
     */
    public void eliminarPiso(String codigo, Integer numeroPiso){
        Edificio edificioBuscado = this.getEdificios().buscarDato(codigo);
        if (edificioBuscado != null) {
            edificioBuscado.eliminarPiso(numeroPiso);
            this.getEdificios().modificarDato(codigo, edificioBuscado);
        }
    }
    
    // INSERTAR 

    /**
     *
     * @param nuevoEdificio
     */
    public void agregarEdificios(Edificio nuevoEdificio){
       Nodo<Edificio> nuevo = new Nodo<>(nuevoEdificio);
       ListaEnlazada<Edificio> listaEdificios = this.getEdificios();
       
       if (listaEdificios.estaVacio()){
           listaEdificios.setInicio(nuevo);
           listaEdificios.setFin(nuevo);
           listaEdificios.setSize(listaEdificios.getSize() + 1);
       }
       else{
           Nodo<Edificio> auxiliar = listaEdificios.getInicio();
           if(nuevoEdificio.getCodigo().compareTo(auxiliar.getInfo().getCodigo()) < 0){
               nuevo.setSiguiente(auxiliar);
               listaEdificios.setInicio(nuevo);
               listaEdificios.setSize(listaEdificios.getSize() + 1);
           }
           else{
                while(nuevoEdificio.getCodigo().compareTo(auxiliar.getInfo().getCodigo()) > 0 
                        && auxiliar.getSiguiente() != null){
                    auxiliar = auxiliar.getSiguiente();
                }
           
                if (auxiliar.getInfo().getCodigo().equals(nuevoEdificio.getCodigo())){
                    System.out.println("Ya existe un edificio con este código");
                }
                else{
                    if (auxiliar.getInfo().getCodigo().equals(listaEdificios.getFin().getInfo().getCodigo())){
                        auxiliar.setSiguiente(nuevo);
                        listaEdificios.setFin(nuevo);
                    }
                    else{
                        nuevo.setSiguiente(auxiliar.getSiguiente());
                        auxiliar.setSiguiente(nuevo);
                    }
                    listaEdificios.setSize(listaEdificios.getSize() + 1);
                }
           }
       }
    }
    
    public void agregarEncargado(Encargado nuevoEncargado){
        this.getEncargados().insertarFin(nuevoEncargado);
    }
    
    public void agregarArrendatario(Arrendado nuevoArrendado){
        this.getArrendatarios().insertarFin(nuevoArrendado);
    }
    
    public void agregarPisosEnEdificio(String codigo, Piso nuevoPiso){
        Edificio edificioBuscado = this.getEdificios().buscarDato(codigo);
        if (edificioBuscado != null){
            edificioBuscado.agregarPisos(nuevoPiso);
            this.getEdificios().modificarDato(codigo, edificioBuscado);
        }
    }
    
    // GETTER Y SETTER
    
    /**
     *
     * @return
     */

    public ListaEnlazada<Edificio> getEdificios() {
        return edificios;
    }

    public ListaEnlazada<Encargado> getEncargados() {
        return encargados;
    }

    public ListaEnlazada<Arrendado> getArrendatarios() {
        return arrendatarios;
    }
    
    /**
     *
     * @param mes
     * @return
     */
    public Float getMontoEnMes(String mes){
        Float montoRecaudado = new Float(0);
        Nodo<Edificio> nodoEdificio = this.getEdificios().getInicio();
        while(nodoEdificio != null){
            montoRecaudado = montoRecaudado + nodoEdificio.getInfo().getMontoEnMes(mes);
            nodoEdificio.getSiguiente();
        }
        return montoRecaudado;
    }
    
    public Float getRestanteEnMes(String mes){
        Float montoRestante = new Float(0);
        Nodo<Edificio> nodoEdificio = this.getEdificios().getInicio();
        while(nodoEdificio != null){
            montoRestante = montoRestante + nodoEdificio.getInfo().getRestanteEnMes(mes);
            nodoEdificio.getSiguiente();
        }
        return montoRestante;
    }
    
    public static void main(String args[]){
        Edificio nuevoEdificio = new Edificio("1", "Sunsol", "Nueva Esparta", 
                "Porlamar, Calle Zamora", "29582382", LocalDate.now());
        Edificio nuevoEdificio2 = new Edificio("2", "Las Putas", "Nueva Esparta", 
                "Porlamar, Calle Zamora", "3889777", LocalDate.now());
        Empresa nuevaEmpresa = new Empresa();
        
        Encargado nuevoEncargado = new Encargado("29582382", "Kevin", "Rojas", 
                "kevintrevor@gmail.com", "02952690018", "04127955420", LocalDate.now());
        Encargado nuevoEncargado2 = new Encargado("3889777", "Yaritza", "Rodriguez", 
                "viejitayara@gmail.com", "02952692313", "04123526289", LocalDate.now());
        
        nuevaEmpresa.agregarEncargado(nuevoEncargado);
        nuevaEmpresa.agregarEncargado(nuevoEncargado2);
        
        nuevaEmpresa.agregarEdificios(nuevoEdificio);
        nuevaEmpresa.agregarEdificios(nuevoEdificio2);
        
        Piso nuevoPiso = new Piso(1, "14221391", LocalDate.now());
        Piso nuevoPiso2 = new Piso(2, "15895465", LocalDate.now());
        
        Float mensualidadLocal = new Float(2500.50);
        Float mensualidadLocal2 = new Float(4000);
        
        Local nuevoLocal = new Local("1", "12222773", mensualidadLocal);
        Local nuevoLocal2 = new Local("2", "29668074", mensualidadLocal2);
         
        nuevoPiso.getLocales().insertarFin(nuevoLocal);
        nuevoPiso.getLocales().insertarFin(nuevoLocal2);
        
        System.out.println(nuevaEmpresa.toString());
    }
}

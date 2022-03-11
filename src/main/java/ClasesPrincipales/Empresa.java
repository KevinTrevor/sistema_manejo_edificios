/**
* Hecho por: Ruben Fuentes 26.326.992 y Alexander Noriega 27.280.176
* Carrera: Informática
* Materia: Algoritmos y Estructuras de Datos II
*/
package ClasesPrincipales;

import Lista.*;
import java.time.LocalDate;

/**
 * La clase Empresa registra la lista de edificios, lista de encargados y lista 
 * de arrendatarios.
 */
public class Empresa {
    private ListaEnlazada<Edificio> edificios;
    private ListaEnlazada<Encargado> encargados;
    private ListaEnlazada<Arrendado> arrendatarios;
    
    /**
     * Método constructor de la clase Empresa. 
     */
    public Empresa() {
        this.edificios = new ListaEnlazada<>();
        this.encargados = new ListaEnlazada<>();
        this.arrendatarios = new ListaEnlazada<>();
    }
    
    // MOSTRAR

    /**
     * Metodo que retorna la informacion de todos los edificios de la lista de
     * edificios.
     * @return String
     */
    public String mostrarEdificios(){
        String edificiosStr = "";
        Nodo<Edificio> edificio = this.getEdificios().getInicio();
        while(edificio != null){
            edificiosStr = edificiosStr + 
                    this.getEncargadoPorCedula(edificio.getInfo().getCedulaEncargado())
                    + "\n" + edificio.getInfo().toString() +
                    "Número de pisos: " + edificio.getInfo().getNumeroPisos() +
                    "Número de locales" + edificio.getInfo().getNumeroLocales() +
                    "\n====================================================\n";
            edificio = edificio.getSiguiente();
        }
        return edificiosStr;
    }
    
    /**
     * Metodo que retorna la información de un local específico de un piso 
     * específicio de un edificio específico de la lista de edificios.
     * @param codigo String
     * @param numeroPiso Integer
     * @param codigoLocal String
     * @return String
     */
    public String mostrarLocalPorCodigo(String codigo, Integer numeroPiso, 
            String codigoLocal){
        String localStr = "";
        Edificio edificioBuscado = this.getEdificios().buscarDato(codigo);
        if (edificioBuscado != null) {
            localStr = this.getArrendadoPorCedula(edificioBuscado.getCedulaArrendatarioLocal(numeroPiso, codigoLocal)) 
                    + "\n" + edificioBuscado.mostrarLocalPorCodigo(numeroPiso, codigoLocal);
        }
        return localStr;
    }
    
    /**
     * Metodo que retorna la información de un edificio especifico de la lista de
     * edificios.
     * @param codigo String
     * @return String
     */
    public String mostrarEdificioPorCodigo(String codigo) {
    	String edificioStr = "";
    	Edificio edificio = this.getEdificios().buscarDato(codigo);
    	if(edificio != null) {
    		edificioStr = this.getEncargadoPorCedula(edificio.getCedulaEncargado()) + 
                        "\n" + 
                        edificio.toString();
    	}
    	
    	return edificioStr;
    }
    
    @Override
    public String toString(){
        return this.mostrarEdificios();
    }
    
    // MODIFICAR

    /**
     * Método para modificar los valores de un encargado específico, exceptuando
     * la cedula.
     * @param cedula String
     * @param nombre String
     * @param apellido String
     * @param correo String
     * @param telefono String
     * @param telefonoMovil String
     * @param fechaContrato LocalDate
     */
    public void modificarEncargado(String cedula, String nombre, String apellido, String correo, 
            String telefono, String telefonoMovil, LocalDate fechaContrato){
        
        Encargado encargadoBuscado = this.getEncargados().buscarDato(cedula);
        if (encargadoBuscado != null) {
            encargadoBuscado.modificarEncargado(nombre, apellido, correo, telefono, 
                    telefonoMovil, fechaContrato);
            this.getEncargados().modificarDato(cedula, encargadoBuscado);
        }
    }
    
    /**
     * Método para modificar los valores de un arrendatario específico, 
     * exceptuando la cedula.
     * @param cedula String
     * @param nombre String
     * @param apellido String
     * @param correo String
     * @param telefono String
     * @param fechaAsignacion String
     */
    public void modificarArrendatario(String cedula, String nombre, String apellido, 
            String correo, String telefono, LocalDate fechaAsignacion){
        Arrendado arrendatarioBuscado = this.getArrendatarios().buscarDato(cedula);
        if (arrendatarioBuscado != null) {
            arrendatarioBuscado.modificarArrendatario(nombre, apellido, correo, telefono, 
                     fechaAsignacion);
            this.getArrendatarios().modificarDato(cedula, arrendatarioBuscado);
        }
    }
    
    /**
     * Método para modificar los valores de un local específico en un piso 
     * específico de un edificio específico de la lista de edificios, exceptuando 
     * el codigo del local.
     * @param codigo String
     * @param numeroPiso Integer
     * @param codigoLocal String
     * @param cedulaArrendatario String
     * @param montoMensualidad Float
     */
    public void modificarLocal(String codigo, Integer numeroPiso, String codigoLocal, String cedulaArrendatario, 
            Float montoMensualidad){
        
        Edificio edificioBuscado = this.getEdificios().buscarDato(codigo);
        if (edificioBuscado != null){
            edificioBuscado.modificarLocal(numeroPiso, codigoLocal, cedulaArrendatario, 
                    montoMensualidad);
            this.getEdificios().modificarDato(codigo, edificioBuscado);
        }
    }
    
    /**
     * Método para modificar los valores de un piso específico de un edificio 
     * específico de la lista de edificios, exceptuando el numero de piso.
     * @param codigo String
     * @param numeroPiso Integer
     * @param cedulaEncargado String
     * @param fechaRegistro LocalDate
     */
    public void modificarPiso(String codigo, Integer numeroPiso, 
            String cedulaEncargado, LocalDate fechaRegistro){
        
         Edificio edificioBuscado = this.getEdificios().buscarDato(codigo);
        if (edificioBuscado != null) {
            edificioBuscado.modificarPiso(numeroPiso, cedulaEncargado,
                    fechaRegistro);
            this.getEdificios().modificarDato(codigo, edificioBuscado);
        }
    }
    
    /**
     * Método para modificar los valores de un edificio específico de la lista 
     * de edificios, exceptuando el codigo del edificio.
     * @param codigo String
     * @param identificacion String
     * @param estado String
     * @param direccion String
     * @param cedulaEncargado String
     * @param fechaCreacion LocalDate
     */
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
     * Método que elimina un edificio especifico de la lista de edificios.
     * @param codigo String
     */
    
    public void eliminarEdificio(String codigo){
        this.getEdificios().eliminarDato(codigo);
    }
    
    /**
     * Método que elimina un piso específico de unedificio especifico de la 
     * lista de edificios.
     * @param codigo String
     * @param numeroPiso Integer
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
     * Método que agrega un nuevo edificio a la lista de edificios.
     * @param nuevoEdificio Edificio
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
    
    /**
     * Metodo que agrega un nuevo encargado a la lista de encargados.
     * @param nuevoEncargado Encargado
     */
    public void agregarEncargado(Encargado nuevoEncargado){
        this.getEncargados().insertarFin(nuevoEncargado);
    }
    
    /**
     * Metodo que agrega un nuevo arrendatario a la lista de arrendatarios.
     * @param nuevoArrendado Arrendado
     */
    public void agregarArrendatario(Arrendado nuevoArrendado){
        this.getArrendatarios().insertarFin(nuevoArrendado);
    }
    
    /**
     * Método que agrega un nuevo piso a un edificio específico de la lista de
     * edificios.
     * @param codigo String
     * @param nuevoPiso Piso
     */
    public void agregarPisosEnEdificio(String codigo, Piso nuevoPiso){
        Edificio edificioBuscado = this.getEdificios().buscarDato(codigo);
        if (edificioBuscado != null){
            edificioBuscado.agregarPisos(nuevoPiso);
            this.getEdificios().modificarDato(codigo, edificioBuscado);
        }
    }
    
    /**
     * Método que agrega un nuevo local a un piso específico de un edificio 
     * específico de la lista de edificios.
     * @param codigo String
     * @param numeroPiso Integer
     * @param nuevoLocal Local
     */
    public void agregarLocal(String codigo, Integer numeroPiso, Local nuevoLocal){
        Edificio edificioBuscado = this.getEdificios().buscarDato(codigo);
        if (edificioBuscado != null) {
            edificioBuscado.agregarLocal(numeroPiso, nuevoLocal);
        }
    }
    
    /**
     * Método que agrega un nuevo pago a un local especifico de un piso específico 
     * de un edificio específico de la lista de edificios.
     * @param codigo String
     * @param numeroPiso Integer
     * @param codigoLocal String
     * @param nuevoPago Pago
     */
    public void agregarPagoLocalEnMes(String codigo,Integer numeroPiso, 
            String codigoLocal, Pago nuevoPago){
        
        Edificio edificioBuscado = this.getEdificios().buscarDato(codigo);
        if (edificioBuscado != null) {
            edificioBuscado.agregarPagoLocalEnMes(numeroPiso, codigoLocal, nuevoPago);
        }
    }
    
    // GETTER Y SETTER
    
    /**
     * Método que retorna el valor del atributo edificios. 
     * @return ListaEnlazada
     */
    public ListaEnlazada<Edificio> getEdificios() {
        return this.edificios;
    }

    /**
     * Método que retorna el valor del atributo encargados. 
     * @return ListaEnlazada
     */
    public ListaEnlazada<Encargado> getEncargados() {
        return this.encargados;
    }

    /**
     * Método que retorna el valor del atributo arrendatarios. 
     * @return ListaEnlazada
     */
    public ListaEnlazada<Arrendado> getArrendatarios() {
        return this.arrendatarios;
    }
    
    /**
     * Método que retorna el valor total del monto recaudado en un mes en todos 
     * los locales de todos los pisos de todos los edificios de la lista de 
     * edificios.
     * @param mes String
     * @return
     */
    public Float getMontoEnMes(String mes){
        Float montoRecaudado = new Float(0);
        Nodo<Edificio> nodoEdificio = this.getEdificios().getInicio();
        while(nodoEdificio != null){
            montoRecaudado = montoRecaudado + nodoEdificio.getInfo().getMontoEnMes(mes);
            nodoEdificio = nodoEdificio.getSiguiente();
        }
        return montoRecaudado;
    }
    
    /**
     * Método que retorna el valor total del monto restante en un mes en todos 
     * los locales de todos los pisos de todos los edificios de la lista de 
     * edificios.
     * @param mes String
     * @return Float
     */
    public Float getRestanteEnMes(String mes){
        Float montoRestante = new Float(0);
        Nodo<Edificio> nodoEdificio = this.getEdificios().getInicio();
        while(nodoEdificio != null){
            montoRestante = montoRestante + nodoEdificio.getInfo().getRestanteEnMes(mes);
            nodoEdificio = nodoEdificio.getSiguiente();
        }
        return montoRestante;
    }
    
    /**
     * Método que retorna un encargado buscado por su cédula.
     * @param cedula String
     * @return Encargado
     */
    public Encargado getEncargadoPorCedula(String cedula){
        return this.getEncargados().buscarDato(cedula);
    }
    
    /**
     * Método que retorna un arrendatario buscado por su cédula.
     * @param cedula String
     * @return Arrendado
     */
    public Arrendado getArrendadoPorCedula(String cedula){
        return this.getArrendatarios().buscarDato(cedula);
    }
}

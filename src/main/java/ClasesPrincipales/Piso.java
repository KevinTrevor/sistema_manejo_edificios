/**
* Hecho por: Ruben Fuentes 26.326.992 y Alexander Noriega 27.280.176
* Carrera: Informática
* Materia: Algoritmos y Estructuras de Datos II
*/
package ClasesPrincipales;

import Lista.*;
import java.time.LocalDate;

/**
 * La clase Piso registra el número de pisos, cedula del encargado de mantenimiento,
 * fecha de registro y una lista de locales en el piso. 
 */
public class Piso {
    private Integer numeroPiso;
    private String cedulaEncargado;
    private LocalDate fechaRegistro;
    private ListaEnlazada<Local> locales;

    /**
     * Método constructor de la clase Piso. Inicializa los atributos como nulos.
     */
    public Piso() {
        this.numeroPiso = null;
        this.cedulaEncargado = null;
        this.fechaRegistro = null;
        this.locales = null;
    }

    /**
     * Método constructor de la clase Piso. Inicializa los atributos con los 
     * valores pasados como parametros.
     * @param numeroPiso Integer
     * @param cedulaEncargado String
     * @param fechaRegistro Local
     */
    public Piso(Integer numeroPiso, String cedulaEncargado, LocalDate fechaRegistro) {
        this.numeroPiso = numeroPiso;
        this.cedulaEncargado = cedulaEncargado;
        this.fechaRegistro = fechaRegistro;
        this.locales = new ListaEnlazada<>();
        
    }
    
    // COMPARACIONES
    
    @Override
    public boolean equals(Object busqueda){
        return this.getNumeroPiso().compareTo((Integer) busqueda) == 0;
    }
    
    // MODIFICAR

    /**
     * Método que modifica los valores de un piso, exceptuando la numero del piso. 
     * @param cedulaEncargado String
     * @param fechaRegistro LocalDate
     */
    public void modificarPiso(String cedulaEncargado, LocalDate fechaRegistro){
        this.setCedulaEncargado(cedulaEncargado);
        this.setFechaRegistro(fechaRegistro);
    }
    
    /**
     * Método que modifica los valores de un local especifico en un piso.
     * @param codigoLocal String 
     * @param cedulaArrendatario String
     * @param montoMensualidad Float
     */
    public void modificarLocal(String codigoLocal, String cedulaArrendatario, 
            Float montoMensualidad){
        Local localBuscado = this.getLocales().buscarDato(codigoLocal);
        if (localBuscado != null) {
            localBuscado.modificarLocal(cedulaArrendatario, montoMensualidad);
            this.getLocales().modificarDato(codigoLocal, localBuscado);
        }
    }
    
    // INSERTAR

    /**
     * Metodo que agrega un nuevo local a la lista de locales de un piso.
     * @param nuevoLocal Local
     */
    public void agregarLocal(Local nuevoLocal){
        this.getLocales().insertarFin(nuevoLocal);
    }
    
    /**
     * Metodo que agrega un nuevo pago a un local de la lista de locales de un piso.
     * @param codigoLocal String
     * @param nuevoPago Pago
     */
    public void agregarPagoLocalEnMes(String codigoLocal, Pago nuevoPago) {
        Local localBuscado = this.getLocales().buscarDato(codigoLocal);
        if (localBuscado != null) {
            localBuscado.agregarPagoLocalEnMes(nuevoPago);
            this.getLocales().modificarDato(codigoLocal, localBuscado);
        }
    }
    
    // MOSTRAR
    
    @Override
    public String toString(){
        String locales = "";
        Nodo<Local> local = this.getLocales().getInicio();
        while(local != null){
            locales = locales + local.getInfo().toString() + "\n=========================================\n";
            local = local.getSiguiente();
        }
        return "Número piso: " + this.getNumeroPiso().toString() + 
                "\nCédula del encargado: " + this.getCedulaEncargado() + 
                "\nCantidad de locales: " + this.getLocales().getSize() +
                "\nLocales: \n" + locales;
    }
    
    /**
     * Metodo que retorna una cadena con la informacion de un local específico.
     * @param codigoLocal String
     * @return String
     */
    public String mostrarLocalPorCodigo(String codigoLocal) {
        String localStr = "";
        Local localBuscado = this.getLocales().buscarDato(codigoLocal);
        if (localBuscado != null) {
            localStr = localBuscado.toString();
        }
        return localStr;
    }
    // GETTER Y SETTER

    /**
     * Método que retorna el valor del atributo numeroPiso.
     * @return Integer
     */
    public Integer getNumeroPiso() {
        return this.numeroPiso;
    }

    /**
     * Método que asigna un valor al atributo numeroPiso.
     * @param numeroPiso Integer
     */
    public void setNumeroPiso(Integer numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    /**
     * Método que retorna el valor del atributo cedulaEncargado.
     * @return String
     */
    public String getCedulaEncargado() {
        return this.cedulaEncargado;
    }

    /**
     * Método que asigna un valor al atributo cedulaEncargado.
     * @param cedulaEncargado String
     */
    public void setCedulaEncargado(String cedulaEncargado) {
        this.cedulaEncargado = cedulaEncargado;
    }

    /**
     * Método que retorna el valor del atributo fechaRegistro.
     * @return LocalDate
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Método que asigna un valor al atributo fechaRegistro.
     * @param fechaRegistro LocalDate
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }    

    /**
     * Método que retorna el valor del atributo locales.
     * @return ListaEnlazada
     */
    public ListaEnlazada<Local> getLocales() {
        return this.locales;
    }
    
    /**
     * Método que retorna el tamaño de la lista de locales.
     * @return int
     */
    public int getNumeroLocales(){
        return locales.getSize();
    }
    
    /**
     * Método que retorna el valor total del monto recaudado en un mes en todos 
     * los locales de un piso.
     * @param mes String
     * @return Float
     */
    public Float getMontoEnMes(String mes){
        Float montoRecaudado = new Float(0);
        Nodo<Local> nodoLocal = this.getLocales().getInicio();
        while(nodoLocal != null){
            montoRecaudado = montoRecaudado + nodoLocal.getInfo().getMontoEnMes(mes);
            nodoLocal = nodoLocal.getSiguiente();
        }
        return montoRecaudado;
    }
    
    /**
     * Método que retorna el valor total del monto restante en un mes en todos 
     * los locales de un piso.
     * @param mes String
     * @return Float
     */
    public Float getRestanteEnMes(String mes){
        Float montoRestante = new Float(0);
        Nodo<Local> nodoLocal = this.getLocales().getInicio();
        while(nodoLocal.getSiguiente() != null){
            montoRestante = montoRestante + nodoLocal.getInfo().getRestanteEnMes(mes);
            nodoLocal = nodoLocal.getSiguiente();
        }
        return montoRestante;
    }
    
    /**
     * Método que retorna el valor total de locales que pagaron en un mes 
     * específico en un piso.
     * @param mes String
     * @return int
     */
    public int getLocalesPagadosEnMes(String mes){
        int totalLocalesPagados = 0;
        Nodo<Local> nodoLocal = this.getLocales().getInicio();
        while(nodoLocal != null){
            if (nodoLocal.getInfo().pagoEnMes(mes)){
                totalLocalesPagados++;
            }
            nodoLocal = nodoLocal.getSiguiente();
        }
        return totalLocalesPagados;
    }
    
    /**
     * Método que retorna la cantidad de locales que tienen una mensualidad menor
     * al monto indicado por su parametro.
     * @param monto Integer
     * @return int
     */
    public int getLocalesMenorA(Integer monto) {
    	Nodo<Local> nodoLocal = this.getLocales().getInicio();
    	Integer contador = 0;
    	while(nodoLocal != null) {
    		if(nodoLocal.getInfo().getMontoMensualidad() < monto) {
    			contador++;
    		}
    		nodoLocal = nodoLocal.getSiguiente();
    	}
    	return contador;
    }
    
    /**
     * Método que retorna la cedula del arrendatario de un local específico.
     * @param codigoLocal String
     * @return String
     */
    public String getCedulaArrendatarioLocal(String codigoLocal){
        String cedulaEncontrada = "";
        Local localBuscado = this.getLocales().buscarDato(codigoLocal);
        if (localBuscado != null){
            cedulaEncontrada = localBuscado.getCedulaArrendatario();
        }
        return cedulaEncontrada;
    }
    
}

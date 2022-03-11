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
public class Piso {
    private Integer numeroPiso;
    private String cedulaEncargado;
    private LocalDate fechaRegistro;
    private ListaEnlazada<Local> locales;

    /**
     *
     */
    public Piso() {
        this.numeroPiso = null;
        this.cedulaEncargado = null;
        this.fechaRegistro = null;
        this.locales = null;
    }

    /**
     *
     * @param numeroPiso
     * @param cedulaEncargado
     * @param fechaRegistro
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
    
    public void modificarPiso(String cedulaEncargado, LocalDate fechaRegistro){
        this.setCedulaEncargado(cedulaEncargado);
        this.setFechaRegistro(fechaRegistro);
    }
    
    public void modificarLocal(String codigoLocal, String cedulaArrendatario, 
            Float montoMensualidad){
        Local localBuscado = this.getLocales().buscarDato(codigoLocal);
        if (localBuscado != null) {
            localBuscado.modificarLocal(cedulaArrendatario, montoMensualidad);
            this.getLocales().modificarDato(codigoLocal, localBuscado);
        }
    }
    
    // INSERTAR
    
    public void agregarLocal(Local nuevoLocal){
        this.getLocales().insertarFin(nuevoLocal);
    }
    
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
     *
     * @return
     */

    public Integer getNumeroPiso() {
        return numeroPiso;
    }

    /**
     *
     * @param numeroPiso
     */
    public void setNumeroPiso(Integer numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    /**
     *
     * @return
     */
    public String getCedulaEncargado() {
        return cedulaEncargado;
    }

    /**
     *
     * @param cedulaEncargado
     */
    public void setCedulaEncargado(String cedulaEncargado) {
        this.cedulaEncargado = cedulaEncargado;
    }

    /**
     *
     * @return
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     *
     * @param fechaRegistro
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }    

    /**
     *
     * @return
     */
    public ListaEnlazada<Local> getLocales() {
        return locales;
    }
    
    public int getNumeroLocales(){
        return locales.getSize();
    }
    
    /**
     *
     * @param mes
     * @return
     */
    public Float getMontoEnMes(String mes){
        Float montoRecaudado = new Float(0);
        Nodo<Local> nodoLocal = this.getLocales().getInicio();
        while(nodoLocal != null){
            montoRecaudado = montoRecaudado + nodoLocal.getInfo().getMontoEnMes(mes);
            nodoLocal.getSiguiente();
        }
        return montoRecaudado;
    }
    
    /**
     *
     * @param mes
     * @return
     */
    public Float getRestanteEnMes(String mes){
        Float montoRestante = new Float(0);
        Nodo<Local> nodoLocal = this.getLocales().getInicio();
        while(nodoLocal.getSiguiente() != null){
            montoRestante = montoRestante + nodoLocal.getInfo().getRestanteEnMes(mes);
            nodoLocal.getSiguiente();
        }
        return montoRestante;
    }
    
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
}

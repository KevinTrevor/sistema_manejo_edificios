/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesPrincipales;
import Lista.*;
/**
 *
 * @author Alberto Gutiérrez
 */
public class Local {
    private String codigoLocal, cedulaArrendatario;
    private Float montoMensualidad;
    private ListaEnlazada<Pago> registroPagos;

    /**
     *
     */
    public Local() {
        this.codigoLocal = null;
        this.cedulaArrendatario = null;
        this.montoMensualidad = null;
        this.registroPagos = null;
    }

    /**
     *
     * @param codigoLocal
     * @param cedulaArrendatario
     * @param montoMensualidad
     */
    public Local(String codigoLocal, String cedulaArrendatario, Float montoMensualidad) {
        this.codigoLocal = codigoLocal;
        this.cedulaArrendatario = cedulaArrendatario;
        this.montoMensualidad = montoMensualidad;
        this.registroPagos = new ListaEnlazada<>();
    }
    
    // COMPARACIONES
    
    @Override
    public boolean equals(Object busqueda){
        return this.getCodigoLocal().equals((String) busqueda);
    }
    
    // MOSTRAR
    
    @Override
    public String toString(){
        return "Código Local: " + this.getCodigoLocal() + 
                "\nCédula del Arrendatario: " + this.getCedulaArrendatario() + 
                "\nMonto de la mensualidad: " + this.getMontoMensualidad().toString();
    }
    
    // GETTER Y SETTER

    /**
     *
     * @return
     */

    public String getCodigoLocal() {
        return codigoLocal;
    }

    /**
     *
     * @param codigoLocal
     */
    public void setCodigoLocal(String codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    /**
     *
     * @return
     */
    public String getCedulaArrendatario() {
        return cedulaArrendatario;
    }

    /**
     *
     * @param cedulaArrendatario
     */
    public void setCedulaArrendatario(String cedulaArrendatario) {
        this.cedulaArrendatario = cedulaArrendatario;
    }

    /**
     *
     * @return
     */
    public Float getMontoMensualidad() {
        return montoMensualidad;
    }

    /**
     *
     * @param montoMensualidad
     */
    public void setMontoMensualidad(Float montoMensualidad) {
        this.montoMensualidad = montoMensualidad;
    }

    /**
     *
     * @return
     */
    public ListaEnlazada<Pago> getRegistroPagos() {
        return registroPagos;
    }
}

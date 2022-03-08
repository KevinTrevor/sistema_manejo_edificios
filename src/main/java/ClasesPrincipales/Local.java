/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesPrincipales;
import Lista.*;
import java.util.Objects;
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
    
    public int compareTo(Local comparator){
        return this.getCodigoLocal().compareTo(comparator.getCodigoLocal());
    }
    
    @Override
    public boolean equals(Object busqueda){
        return this.getCodigoLocal().compareTo((String) busqueda) == 0;
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

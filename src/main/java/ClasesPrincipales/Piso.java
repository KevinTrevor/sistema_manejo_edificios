/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesPrincipales;

import Lista.*;
import java.time.LocalDate;

/**
 *
 * 
 */
public class Piso {
    public Integer numeroPiso;
    public String cedulaEncargado;
    public LocalDate fechaRegistro;
    public ListaEnlazada<Local> locales;

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
}

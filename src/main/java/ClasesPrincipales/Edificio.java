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
public class Edificio {
    public String codigo, identificacion, estado, direccion, cedulaEncargado;
    public LocalDate fechaCreacion;
    public ListaEnlazada<Piso> pisos;
    public ListaEnlazada<Encargado> encargados;
    public ListaEnlazada<Arrendado> arrendatarios;

    public Edificio() {
        this.codigo = null;
        this.identificacion = null;
        this.estado = null;
        this.direccion = null;
        this.cedulaEncargado = null;
        this.fechaCreacion = null;
        this.pisos = null;
        this.encargados = null;
        this.arrendatarios = null;
    }

    public Edificio(String codigo, String identificacion, String estado, String direccion, String cedulaEncargado, LocalDate fechaCreacion, ListaEnlazada<Piso> pisos, ListaEnlazada<Encargado> encargados, ListaEnlazada<Arrendado> arrendatarios) {
        this.codigo = codigo;
        this.identificacion = identificacion;
        this.estado = estado;
        this.direccion = direccion;
        this.cedulaEncargado = cedulaEncargado;
        this.fechaCreacion = fechaCreacion;
        this.pisos = new ListaEnlazada<>();
        this.encargados = new ListaEnlazada<>();
        this.arrendatarios = new ListaEnlazada<>();
    }
    
    // GETTER Y SETTER

    /**
     *
     * @return
     */
    
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     *
     * @param identificacion
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     *
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     *
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     *
     * @param fechaCreacion
     */
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
}

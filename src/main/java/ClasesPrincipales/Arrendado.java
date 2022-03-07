/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesPrincipales;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * 
 */
public class Arrendado extends Persona{
    public LocalDate fechaAsignacion;

    /**
     *
     */
    public Arrendado() {
        super();
        this.fechaAsignacion = null;
    }

    /**
     *
     * @param fecha_asignacion
     * @param nombre
     * @param apellido
     * @param correo
     * @param telefono
     * @param fechaAsignacion
     */
    public Arrendado(String fecha_asignacion, String nombre, String apellido, String correo, String telefono, LocalDate fechaAsignacion) {
        super(nombre, apellido, correo, telefono);
        this.fechaAsignacion = fechaAsignacion;
    }
    
    
    // GETTER Y SETER

    /**
     *
     * @return
     */
    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    /**
     *
     * @param fechaAsignacion
     */
    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getCorreo() {
        return correo;
    }

    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public static void main(String args[]){
        LocalDate fecha = LocalDate.now();
        System.out.println(fecha);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesPrincipales;
import java.time.LocalDate;

/**
 *
 * 
 */
public class Encargado extends Persona {
    public String telefonoMovil;
    public LocalDate fechaContrato;
    
    /**
     *
     */
    public Encargado() {
        super();
        this.telefonoMovil = null;
        this.fechaContrato = null;
    }

    public Encargado(String nombre, String apellido, String correo, String telefono, String telefonoMovil, LocalDate fechaContrato) {
        super(nombre, apellido, correo, telefono);
        this.telefonoMovil = telefonoMovil;
        this.fechaContrato = fechaContrato;
    }
    
    // GETTER Y SETTER
    
    
    /**
     *
     * @return
     */
    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    /**
     *
     * @param telefonoMovil
     */
    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    /**
     *
     * @return
     */
    public LocalDate getFechaContrato() {
        return fechaContrato;
    }

    /**
     *
     * @param fechaContrato
     */
    public void setFechaContrato(LocalDate fechaContrato) {
        this.fechaContrato = fechaContrato;
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
}

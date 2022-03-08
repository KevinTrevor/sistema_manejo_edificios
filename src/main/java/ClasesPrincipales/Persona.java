/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesPrincipales;

/**
 *
 * 
 */
public class Persona {
    private String cedula, nombre, apellido, correo, telefono;

    /**
     *
     */
    public Persona() {
        this.cedula = null;
        this.nombre = null;
        this.apellido = null;
        this.correo = null;
        this.telefono = null;
    }
    
    /**
     *
     * @param cedula
     * @param nombre
     * @param apellido
     * @param correo
     * @param telefono
     */
    public Persona(String cedula, String nombre, String apellido, String correo, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public void modificarPersona(){
    
    }

    // GETTER Y SETTER
    
    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getApellido() {
        return apellido;
    }

    /**
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     *
     * @return
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}

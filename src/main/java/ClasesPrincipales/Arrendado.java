/**
* Hecho por: Ruben Fuentes 26.326.992 y Alexander Noriega 27.280.176
* Carrera: Informática
* Materia: Algoritmos y Estructuras de Datos II
*/
package ClasesPrincipales;

import java.time.LocalDate;

/**
 *
 * 
 */
public class Arrendado extends Persona{
    private LocalDate fechaAsignacion;

    /**
     *
     */
    public Arrendado() {
        super();
        this.fechaAsignacion = null;
    }

    /**
     *
     * @param cedula
     * @param nombre
     * @param apellido
     * @param correo
     * @param telefono
     * @param fechaAsignacion
     */
    public Arrendado(String cedula, String nombre, String apellido, String correo, String telefono, LocalDate fechaAsignacion) {
        super(cedula, nombre, apellido, correo, telefono);
        this.fechaAsignacion = fechaAsignacion;
    }
    
    // COMPARACIONES
    
    @Override
    public boolean equals(Object busqueda){
        return this.getCedula().compareTo((String) busqueda) == 0;
    }
    
    // MOSTRAR
    
    @Override
    public String toString(){
        return "Nombre completo del arrendatario: " + this.getNombre() + 
                " " + this.getApellido();
    }
    
    // MODIFICAR

    /**
     *
     * @param nombre
     * @param apellido
     * @param correo
     * @param telefono
     * @param fechaAsignacion
     */
    public void modificarArrendatario(String nombre, String apellido, String correo, 
            String telefono, LocalDate fechaAsignacion){
        
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setCorreo(correo);
        this.setTelefono(telefono);
        this.setFechaAsignacion(fechaAsignacion);
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
    public String getCedula(){
        return super.getCedula();
    }
    
    @Override
    public void setCedula(String cedula){
        super.setCedula(cedula);
    }
    
    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public String getApellido() {
        return super.getApellido();
    }

    @Override
    public void setApellido(String apellido) {
        super.setApellido(apellido);
    }

    @Override
    public String getCorreo() {
        return super.getCorreo();
    }

    @Override
    public void setCorreo(String correo) {
        super.setCorreo(correo);
    }

    @Override
    public String getTelefono() {
        return super.getTelefono();
    }

    @Override
    public void setTelefono(String telefono) {
        super.setTelefono(telefono);
    }
}

/**
* Hecho por: Ruben Fuentes 26.326.992 y Alexander Noriega 27.280.176
* Carrera: Informática
* Materia: Algoritmos y Estructuras de Datos II
*/
package ClasesPrincipales;

import java.time.LocalDate;

/**
 * La clase Encargado registra todos los atributos de la clase Persona y el
 * atributo propio fecha de asignación.
 */
public class Arrendado extends Persona{
    private LocalDate fechaAsignacion;

    /**
     * Método constructor de la clase Arrendado. Inicializa los atributos como nulos.
     */
    public Arrendado() {
        super();
        this.fechaAsignacion = null;
    }

    /**
     * Método constructor de la clase Arrendado. Inicializa los atributos con los 
     * valores pasados como parametros.
     * @param cedula String
     * @param nombre String
     * @param apellido String
     * @param correo String
     * @param telefono String
     * @param fechaAsignacion LocalDate
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
     * Método que modifica los valores de un arrendado, exceptuando la cedula.
     * @param nombre String
     * @param apellido String
     * @param correo String
     * @param telefono String
     * @param fechaAsignacion LocalDate
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
     * Método que retorna el valor del atributo fechaAsignacion.
     * @return LocalDate
     */
    public LocalDate getFechaAsignacion() {
        return this.fechaAsignacion;
    }

    /**
     * Método que asigna un valor al atributo fechaAsignacion.
     * @param fechaAsignacion LocalDate
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

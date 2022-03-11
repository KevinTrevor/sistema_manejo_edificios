/**
* Hecho por: Ruben Fuentes 26.326.992 y Alexander Noriega 27.280.176
* Carrera: Informática
* Materia: Algoritmos y Estructuras de Datos II
*/
package ClasesPrincipales;
import java.time.LocalDate;

/**
 * La clase Encargado registra todos los atributos de la clase Persona y 
 * atributos propios como teléfono movil y fecha del contrato.
 */
public class Encargado extends Persona {
    private String telefonoMovil;
    private LocalDate fechaContrato;
    
    /**
     * Método constructor de la clase Encargado. Inicializa los atributos como nulos.
     */
    public Encargado() {
        super();
        this.telefonoMovil = null;
        this.fechaContrato = null;
    }

    /**
     * Método constructor de la clase Encargado. Inicializa los atributos con los 
     * valores pasados como parametros.
     * @param cedula String
     * @param nombre String
     * @param apellido String
     * @param correo String
     * @param telefono String
     * @param telefonoMovil String
     * @param fechaContrato LocalDate
     */
    public Encargado(String cedula, String nombre, String apellido, String correo, 
            String telefono, String telefonoMovil, LocalDate fechaContrato) {
        super(cedula, nombre, apellido, correo, telefono);
        this.telefonoMovil = telefonoMovil;
        this.fechaContrato = fechaContrato;
    }
    
    // COMPARACIONES
    
    @Override
    public boolean equals(Object busqueda){
        return this.getCedula().compareTo((String) busqueda) == 0;
    }
    
    // MOSTRAR
    
    @Override
    public String toString(){
        return "Nombre completo del encargado: " + this.getNombre() + 
                " " + this.getApellido();
    }
    
    // MODIFICAR

    /**
     * Método que modifica los valores de un encargado, exceptuando la cedula.
     * @param nombre String
     * @param apellido String
     * @param correo String
     * @param telefono String
     * @param telefonoMovil String
     * @param fechaContrato LocalDate
     */
    public void modificarEncargado(String nombre, String apellido, String correo, 
            String telefono, String telefonoMovil, LocalDate fechaContrato){
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setCorreo(correo);
        this.setTelefono(telefono);
        this.setTelefonoMovil(telefonoMovil);
        this.setFechaContrato(fechaContrato);
    }
    
    // GETTER Y SETTER
    
    
    /**
     * Método que retorna el valor del atributo telefonoMovil.
     * @return String
     */
    public String getTelefonoMovil() {
        return this.telefonoMovil;
    }

    /**
     * Método que asigna un valor al atributo telefonoMovil.
     * @param telefonoMovil String
     */
    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    /**
     * Método que retorna el valor del atributo fechaContrato.
     * @return LocalDate
     */
    public LocalDate getFechaContrato() {
        return this.fechaContrato;
    }

    /**
     * Método que asigna un valor al atributo fechaContrato.
     * @param fechaContrato LocalDate
     */
    public void setFechaContrato(LocalDate fechaContrato) {
        this.fechaContrato = fechaContrato;
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

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
public class Encargado extends Persona {
    private String telefonoMovil;
    private LocalDate fechaContrato;
    
    /**
     *
     */
    public Encargado() {
        super();
        this.telefonoMovil = null;
        this.fechaContrato = null;
    }

    /**
     *
     * @param cedula
     * @param nombre
     * @param apellido
     * @param correo
     * @param telefono
     * @param telefonoMovil
     * @param fechaContrato
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

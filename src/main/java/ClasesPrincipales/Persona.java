/**
* Hecho por: Ruben Fuentes 26.326.992 y Alexander Noriega 27.280.176
* Carrera: Informática
* Materia: Algoritmos y Estructuras de Datos II
*/
package ClasesPrincipales;

/**
 * La clase Persona registra la cédula, nombre, apellido, correo electrónico y  
 * teléfono.
 */
public class Persona {
    private String cedula, nombre, apellido, correo, telefono;

    /**
     * Método constructor de la clase Persona. Inicializa los atributos como nulos.
     */
    public Persona() {
        this.cedula = null;
        this.nombre = null;
        this.apellido = null;
        this.correo = null;
        this.telefono = null;
    }
    
    /**
     * Método constructor de la clase Persona. Inicializa los atributos con los 
     * valores pasados como parametros.
     * @param cedula String
     * @param nombre String
     * @param apellido String
     * @param correo String
     * @param telefono String
     */
    public Persona(String cedula, String nombre, String apellido, String correo, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    @Override
    public String toString(){
        return "Nombre completo: " + this.getNombre() + 
                " " + this.getApellido();
    }

    // GETTER Y SETTER

    /**
     * Método que retorna el valor del atributo cedula.
     * @return String
     */
    public String getCedula() {
        return this.cedula;
    }

    /**
     * Método que asigna un valor al atributo cedula.
     * @param cedula String
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
    
    /**
     * Método que retorna el valor del atributo nombre.
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Método que asigna un valor al atributo nombre.
     * @param nombre String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que retorna el valor del atributo apellido.
     * @return String
     */
    public String getApellido() {
        return this.apellido;
    }

    /**
     * Método que asigna un valor al atributo apellido.
     * @param apellido String
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Método que retorna el valor del atributo correo.
     * @return String
     */
    public String getCorreo() {
        return this.correo;
    }

    /**
     * Método que asigna un valor al atributo correo.
     * @param correo String
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Método que retorna el valor del atributo telefono.
     * @return String
     */
    public String getTelefono() {
        return this.telefono;
    }

    /**
     * Método que asigna un valor al atributo telefono.
     * @param telefono String
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

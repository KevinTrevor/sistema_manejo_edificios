/**
* Hecho por: Ruben Fuentes 26.326.992 y Alexander Noriega 27.280.176
* Carrera: Informática
* Materia: Algoritmos y Estructuras de Datos II
*/
package ClasesPrincipales;
import Lista.*;

/**
 * La clase Local registra el codigo del local, cedula del arrendatario,  
 * monto de mensualidad y el registro de pagos.
 */
public class Local {
    private String codigoLocal, cedulaArrendatario;
    private Float montoMensualidad;
    private ListaEnlazada<Pago> registroPagos;

    /**
     * Método constructor de la clase Local. Inicializa los atributos como nulos.
     */
    public Local() {
        this.codigoLocal = null;
        this.cedulaArrendatario = null;
        this.montoMensualidad = null;
        this.registroPagos = null;
    }

    /**
     * Método constructor de la clase Local. Inicializa los atributos con los 
     * valores pasados como parametros.
     * @param codigoLocal String
     * @param cedulaArrendatario String
     * @param montoMensualidad Float
     */
    public Local(String codigoLocal, String cedulaArrendatario, Float montoMensualidad) {
        this.codigoLocal = codigoLocal;
        this.cedulaArrendatario = cedulaArrendatario;
        this.montoMensualidad = montoMensualidad;
        this.registroPagos = new ListaEnlazada<>();
    }
    
    // COMPARACIONES
    
    @Override
    public boolean equals(Object busqueda){
        return this.getCodigoLocal().equals((String) busqueda);
    }
    
    // MODIFICAR
    
    public void modificarLocal(String cedulaArrendatario, Float montoMensualidad){
        this.setCedulaArrendatario(cedulaArrendatario);
        this.setMontoMensualidad(montoMensualidad);
    }
    
    // INSERTAR
    
    public void agregarPagoLocalEnMes(Pago nuevoPago) {
        this.getRegistroPagos().insertarFin(nuevoPago);
    }
    
    // MOSTRAR
    
    @Override
    public String toString(){
        return "Código Local: " + this.getCodigoLocal() + 
                "\nCédula del Arrendatario: " + this.getCedulaArrendatario() + 
                "\nMonto de la mensualidad: " + this.getMontoMensualidad().toString();
    }
    
    // GETTER Y SETTER

    /**
     * Método que retorna el valor del atributo codigoLocal.
     * @return String
     */

    public String getCodigoLocal() {
        return codigoLocal;
    }

    /**
     * Método que asigna un valor al atributo codigoLocal.
     * @param codigoLocal
     */
    public void setCodigoLocal(String codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    /**
     * Método que retorna el valor del atributo cedulaArrendatario.
     * @return String
     */
    public String getCedulaArrendatario() {
        return cedulaArrendatario;
    }

    /**
     * Método que asigna un valor al atributo cedulaArrendatario.
     * @param cedulaArrendatario String
     */
    public void setCedulaArrendatario(String cedulaArrendatario) {
        this.cedulaArrendatario = cedulaArrendatario;
    }

    /**
     * Método que retorna el valor del atributo montoMensualidad.
     * @return Float
     */
    public Float getMontoMensualidad() {
        return montoMensualidad;
    }

    /**
     * Método que asigna un valor al atributo montoMensualidad.
     * @param montoMensualidad Float
     */
    public void setMontoMensualidad(Float montoMensualidad) {
        this.montoMensualidad = montoMensualidad;
    }

    /**
     * Método que retorna el valor del atributo registroPagos.
     * @return ListaEnlazada
     */
    public ListaEnlazada<Pago> getRegistroPagos() {
        return registroPagos;
    }
    
    /**
     * Método que retorna el valor total del monto recaudado en un mes específico.
     * @param mes String
     * @return Float
     */
    public Float getMontoEnMes(String mes){
        Float montoRecaudado = new Float(0);
        Nodo<Pago> nodoPago = this.getRegistroPagos().getInicio();
        while(nodoPago != null){
            if (nodoPago.getInfo().getMes().equals(mes)){
                montoRecaudado = montoRecaudado + nodoPago.getInfo().getMontoCancelado();
            }
            nodoPago = nodoPago.getSiguiente();
        }
        return montoRecaudado;
    }
    
    /**
     * Método que retorna el valor total del monto restante en un mes específico.
     * @param mes
     * @return
     */
    public Float getRestanteEnMes(String mes){
        Float montoRestante = new Float(0);
        Nodo<Pago> nodoPago = this.getRegistroPagos().getInicio();
        while(nodoPago != null){
            if (nodoPago.getInfo().getMes().equals(mes)){
                montoRestante = montoRestante + nodoPago.getInfo().getMontoRestante();
            }
            nodoPago = nodoPago.getSiguiente();
        }
        return montoRestante;
    }
    
    /**
     * Metodo que retorna un valor booleano dependiendo si el local se ha pagado
     * en un mes específico. 
     * @param mes String
     * @return boolean
     */
    public boolean pagoEnMes(String mes){
        boolean banderaPago = false;
        Nodo<Pago> nodoPago = this.getRegistroPagos().getInicio();
        while(nodoPago != null){
            if (nodoPago.getInfo().getMes().equals(mes)){
                banderaPago = true;
            }
            nodoPago = nodoPago.getSiguiente();
        }
        return banderaPago;

    }
}

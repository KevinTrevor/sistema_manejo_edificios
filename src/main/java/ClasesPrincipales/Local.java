/**
* Hecho por: Ruben Fuentes 26.326.992 y Alexander Noriega 27.280.176
* Carrera: Informática
* Materia: Algoritmos y Estructuras de Datos II
*/
package ClasesPrincipales;
import Lista.*;
/**
 *
 * @author Alberto Gutiérrez
 */
public class Local {
    private String codigoLocal, cedulaArrendatario;
    private Float montoMensualidad;
    private ListaEnlazada<Pago> registroPagos;

    /**
     *
     */
    public Local() {
        this.codigoLocal = null;
        this.cedulaArrendatario = null;
        this.montoMensualidad = null;
        this.registroPagos = null;
    }

    /**
     *
     * @param codigoLocal
     * @param cedulaArrendatario
     * @param montoMensualidad
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
     *
     * @return
     */

    public String getCodigoLocal() {
        return codigoLocal;
    }

    /**
     *
     * @param codigoLocal
     */
    public void setCodigoLocal(String codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    /**
     *
     * @return
     */
    public String getCedulaArrendatario() {
        return cedulaArrendatario;
    }

    /**
     *
     * @param cedulaArrendatario
     */
    public void setCedulaArrendatario(String cedulaArrendatario) {
        this.cedulaArrendatario = cedulaArrendatario;
    }

    /**
     *
     * @return
     */
    public Float getMontoMensualidad() {
        return montoMensualidad;
    }

    /**
     *
     * @param montoMensualidad
     */
    public void setMontoMensualidad(Float montoMensualidad) {
        this.montoMensualidad = montoMensualidad;
    }

    /**
     *
     * @return
     */
    public ListaEnlazada<Pago> getRegistroPagos() {
        return registroPagos;
    }
    
    /**
     *
     * @param mes
     * @return
     */
    public Float getMontoEnMes(String mes){
        Float montoRecaudado = new Float(0);
        Nodo<Pago> nodoPago = this.getRegistroPagos().getInicio();
        while(nodoPago != null){
            if (nodoPago.getInfo().getMes().equals(mes)){
                montoRecaudado = montoRecaudado + nodoPago.getInfo().getMontoCancelado();
            }
            nodoPago.getSiguiente();
        }
        return montoRecaudado;
    }
    
    /**
     *
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
            nodoPago.getSiguiente();
        }
        return montoRestante;
    }
    
    public boolean pagoEnMes(String mes){
        boolean banderaPago = false;
        Nodo<Pago> nodoPago = this.getRegistroPagos().getInicio();
        while(nodoPago != null){
            if (nodoPago.getInfo().getMes().equals(mes)){
                banderaPago = true;
            }
            nodoPago.getSiguiente();
        }
        return banderaPago;

    }
}

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
public class Pago {
    private LocalDate fechaPago;
    private Float montoCancelado, montoRestante;
    private String cedulaActualArrendatario, mes;

    public Pago() {
        this.mes = null;
        this.fechaPago = null;
        this.montoCancelado = null;
        this.montoRestante = null;
        this.cedulaActualArrendatario = null;
    }

    /**
     *
     * @param mes
     * @param fechaPago
     * @param montoCancelado
     * @param montoRestante
     * @param cedulaActualArrendatario
     */
    public Pago(String mes, LocalDate fechaPago, Float montoCancelado, Float montoRestante, String cedulaActualArrendatario) {
        this.mes = mes;
        this.fechaPago = fechaPago;
        this.montoCancelado = montoCancelado;
        this.montoRestante = montoRestante;
        this.cedulaActualArrendatario = cedulaActualArrendatario;
    }
    
    // COMPARACIONES
    
    @Override
    public boolean equals(Object busqueda){
        return this.getMes().compareTo((String) busqueda) == 0;
    }  
    
    // MOSTRAR
    
    @Override
    public String toString(){
        return "Mes a cancelar: " + this.getMes() + 
                "\nFecha de pago: "  + this.getFechaPago().toString() + 
                "\nCédula del Actual Arrendatario: " + this.getCedulaActualArrendatario() + 
                "\nMonto cancelado: " + this.getMontoCancelado().toString() + 
                "\nMonto restante: " + this.getMontoRestante().toString();
    }
    
    // GETTER Y SETTER

    /**
     *
     * @return
     */
    public String getMes() {
        return mes;
    }

    /**
     *
     * @param mes
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     *
     * @return
     */
    public LocalDate getFechaPago() {
        return fechaPago;
    }

    /**
     *
     * @param fechaPago
     */
    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    /**
     *
     * @return
     */
    public Float getMontoCancelado() {
        return montoCancelado;
    }

    /**
     *
     * @param montoCancelado
     */
    public void setMontoCancelado(Float montoCancelado) {
        this.montoCancelado = montoCancelado;
    }

    /**
     *
     * @return
     */
    public Float getMontoRestante() {
        return montoRestante;
    }

    /**
     *
     * @param montoRestante
     */
    public void setMontoRestante(Float montoRestante) {
        this.montoRestante = montoRestante;
    }

    /**
     *
     * @return
     */
    public String getCedulaActualArrendatario() {
        return cedulaActualArrendatario;
    }

    /**
     *
     * @param cedulaActualArrendatario
     */
    public void setCedulaActualArrendatario(String cedulaActualArrendatario) {
        this.cedulaActualArrendatario = cedulaActualArrendatario;
    } 
    
    public static void main(String args[]){
        Float nuevoMontoCancelado = new Float(2506.50);
        Float nuevoMontoRestante = new Float(5000 - 2506.50);
        Pago nuevoPago = new Pago("Enero",LocalDate.now(), nuevoMontoCancelado, nuevoMontoRestante, "12222773");
        
        System.out.println(nuevoPago.toString());
    }
}

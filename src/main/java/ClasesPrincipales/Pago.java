/**
* Hecho por: Ruben Fuentes 26.326.992 y Alexander Noriega 27.280.176
* Carrera: Informática
* Materia: Algoritmos y Estructuras de Datos II
*/
package ClasesPrincipales;

import java.time.LocalDate;

/**
 * La clase Pago registra los montos cancelados, restantes, fecha de pago, 
 * mes del pago y cédula del arrendatario actual.
 * 
 */
public class Pago {
    private LocalDate fechaPago;
    private Float montoCancelado, montoRestante;
    private String cedulaActualArrendatario, mes;

    /**
     * Método constructor de la clase Pago. Inicializa los atributos como nulos.
     */
    public Pago() {
        this.mes = null;
        this.fechaPago = null;
        this.montoCancelado = null;
        this.montoRestante = null;
        this.cedulaActualArrendatario = null;
    }

    /**
     * Método constructor de la clase Pago. Inicializa los atributos con los 
     * valores pasados como parametros.
     * @param mes String
     * @param fechaPago LocalDate
     * @param montoCancelado Float
     * @param montoRestante Float
     * @param cedulaActualArrendatario String
     */
    public Pago(String mes, LocalDate fechaPago, Float montoCancelado, 
            Float montoRestante, String cedulaActualArrendatario) {
        
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
     * Método que retorna el valor del atributo mes
     * @return String
     */
    public String getMes() {
        return mes;
    }

    /**
     * Método que asigna un valor al atributo mes
     * @param mes String
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * Método que retorna el valor del atributo fechaPago
     * @return LocalDate
     */
    public LocalDate getFechaPago() {
        return fechaPago;
    }

    /**
     * Método que asigna un valor al atributo fechaPago
     * @param fechaPago LocalDate
     */
    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    /**
     * Método que retorna el valor del atributo montoCancelado
     * @return Float
     */
    public Float getMontoCancelado() {
        return this.montoCancelado;
    }

    /**
     * Método que asigna un valor al atributo montoCancelado
     * @param montoCancelado Float
     */
    public void setMontoCancelado(Float montoCancelado) {
        this.montoCancelado = montoCancelado;
    }

    /**
     * Método que retorna el valor del atributo montoRestante
     * @return Float
     */
    public Float getMontoRestante() {
        return this.montoRestante;
    }

    /**
     * Método que asigna un valor al atributo montoRestante
     * @param montoRestante Float
     */
    public void setMontoRestante(Float montoRestante) {
        this.montoRestante = montoRestante;
    }

    /**
     * Método que retorna el valor del atributo cedulaActualArrendatario
     * @return String
     */
    public String getCedulaActualArrendatario() {
        return cedulaActualArrendatario;
    }

    /**
     * Método que asigna un valor al atributo cedulaActualArrendatario
     * @param cedulaActualArrendatario String
     */
    public void setCedulaActualArrendatario(String cedulaActualArrendatario) {
        this.cedulaActualArrendatario = cedulaActualArrendatario;
    } 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesPrincipales;

import java.time.LocalDate;

/**
 *
 * 
 */
public class Pago {
    private LocalDate fechaPago;
    private Integer mes;
    private Float montoCancelado, montoRestante;
    private String cedulaActualArrendatario;

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
    public Pago(Integer mes, LocalDate fechaPago, Float montoCancelado, Float montoRestante, String cedulaActualArrendatario) {
        this.mes = mes;
        this.fechaPago = fechaPago;
        this.montoCancelado = montoCancelado;
        this.montoRestante = montoRestante;
        this.cedulaActualArrendatario = cedulaActualArrendatario;
    }
    
    // COMPARACIONES
    
    @Override
    public boolean equals(Object busqueda){
        return this.getMes().compareTo((Integer) busqueda) == 0;
    }    
    
    public void modificarPago(LocalDate mes, LocalDate fechaPago, Float montoCancelado, Float montoRestante, String cedulaActualArrendatario){
    
    }
    
    // GETTER Y SETTER

    /**
     *
     * @return
     */
    public Integer getMes() {
        return mes;
    }

    /**
     *
     * @param mes
     */
    public void setMes(Integer mes) {
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
}

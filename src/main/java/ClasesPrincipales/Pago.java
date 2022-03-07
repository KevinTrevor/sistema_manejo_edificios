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
    public LocalDate mes, fechaPago;
    public Float montoCancelado, montoRestante;
    public String cedulaActualArrendatario;

    public Pago() {
        this.mes = null;
        this.fechaPago = null;
        this.montoCancelado = null;
        this.montoRestante = null;
        this.cedulaActualArrendatario = null;
    }

    public Pago(LocalDate mes, LocalDate fechaPago, Float montoCancelado, Float montoRestante, String cedulaActualArrendatario) {
        this.mes = mes;
        this.fechaPago = fechaPago;
        this.montoCancelado = montoCancelado;
        this.montoRestante = montoRestante;
        this.cedulaActualArrendatario = cedulaActualArrendatario;
    }
    
    // GETTER Y SETTER

    /**
     *
     * @return
     */
    public LocalDate getMes() {
        return mes;
    }

    /**
     *
     * @param mes
     */
    public void setMes(LocalDate mes) {
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

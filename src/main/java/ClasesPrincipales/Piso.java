/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesPrincipales;

import Lista.*;
import java.time.LocalDate;

/**
 *
 * 
 */
public class Piso {
    private Integer numeroPiso;
    private String cedulaEncargado;
    private LocalDate fechaRegistro;
    private ListaEnlazada<Local> locales;

    /**
     *
     */
    public Piso() {
        this.numeroPiso = null;
        this.cedulaEncargado = null;
        this.fechaRegistro = null;
        this.locales = null;
    }

    /**
     *
     * @param numeroPiso
     * @param cedulaEncargado
     * @param fechaRegistro
     */
    public Piso(Integer numeroPiso, String cedulaEncargado, LocalDate fechaRegistro) {
        this.numeroPiso = numeroPiso;
        this.cedulaEncargado = cedulaEncargado;
        this.fechaRegistro = fechaRegistro;
        this.locales = new ListaEnlazada<>();
        
    }
    
    // COMPARACIONES
    
    @Override
    public boolean equals(Object busqueda){
        Piso comparar = (Piso) busqueda;
        return this.getNumeroPiso().compareTo(comparar.getNumeroPiso()) == 0;
    }
    
    // MODIFICAR
    
    public void modificarLocal(String codigoLocal, String cedulaArrendatario, 
            Float montoMensualidad){
        Local localBuscado = this.getLocales().buscarDato(codigoLocal);
        if (localBuscado != null) {
            localBuscado.modificarLocal(cedulaArrendatario, montoMensualidad);
            this.getLocales().modificarDato(codigoLocal, localBuscado);
        }
        else{
            System.out.println("El local a modificar no se encuentra registrado.");
        }
    }
    
    // MOSTRAR
    
    @Override
    public String toString(){
        String locales = "";
        Nodo<Local> local = this.getLocales().getInicio();
        while(local != null){
            locales = locales + local.getInfo().toString() + "\n=========================================\n";
            local = local.getSiguiente();
        }
        return "Número piso: " + this.getNumeroPiso().toString() + 
                "\nCédula del encargado: " + this.getCedulaEncargado() + 
                "\nCantidad de locales: " + this.getLocales().getSize() +
                "\nLocales: \n" + locales;
    }
    // GETTER Y SETTER

    /**
     *
     * @return
     */

    public Integer getNumeroPiso() {
        return numeroPiso;
    }

    /**
     *
     * @param numeroPiso
     */
    public void setNumeroPiso(Integer numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    /**
     *
     * @return
     */
    public String getCedulaEncargado() {
        return cedulaEncargado;
    }

    /**
     *
     * @param cedulaEncargado
     */
    public void setCedulaEncargado(String cedulaEncargado) {
        this.cedulaEncargado = cedulaEncargado;
    }

    /**
     *
     * @return
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     *
     * @param fechaRegistro
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }    

    /**
     *
     * @return
     */
    public ListaEnlazada<Local> getLocales() {
        return locales;
    }
    
    public int getNumeroLocales(){
        return locales.getSize();
    }
    
    /**
     *
     * @param mes
     * @return
     */
    public Float getMontoEnMes(String mes){
        Float montoRecaudado = new Float(0);
        Nodo<Local> nodoLocal = this.getLocales().getInicio();
        while(nodoLocal != null){
            montoRecaudado = montoRecaudado + nodoLocal.getInfo().getMontoEnMes(mes);
            nodoLocal.getSiguiente();
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
        Nodo<Local> nodoLocal = this.getLocales().getInicio();
        while(nodoLocal.getSiguiente() != null){
            montoRestante = montoRestante + nodoLocal.getInfo().getRestanteEnMes(mes);
            nodoLocal.getSiguiente();
        }
        return montoRestante;
    }
    
    public int getLocalesPagadosEnMes(String mes){
        int totalLocalesPagados = 0;
        Nodo<Local> nodoLocal = this.getLocales().getInicio();
        while(nodoLocal != null){
            if (nodoLocal.getInfo().pagoEnMes(mes)){
                totalLocalesPagados++;
            }
            nodoLocal = nodoLocal.getSiguiente();
        }
        return totalLocalesPagados;
    }
    
    public static void main(String args[]){
        Piso nuevoPiso = new Piso(1, "29582382", LocalDate.now());
        
        Float mensualidadLocal = new Float(250.50);
        Float mensualidadLocal2 = new Float(5000);
        Local nuevoLocal = new Local("1", "12222773", mensualidadLocal);
        Local nuevoLocal2 = new Local("2", "29668074", mensualidadLocal2);
         
        nuevoPiso.getLocales().insertarFin(nuevoLocal);
        nuevoPiso.getLocales().insertarFin(nuevoLocal2);
        
        System.out.println(nuevoPiso.toString());
    }
}

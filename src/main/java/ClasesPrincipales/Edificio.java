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
public class Edificio {
    private String codigo, identificacion, estado, direccion, cedulaEncargado;
    private LocalDate fechaCreacion;
    private ListaEnlazada<Piso> pisos;
    private ListaEnlazada<Encargado> encargados;
    private ListaEnlazada<Arrendado> arrendatarios;

    public Edificio() {
        this.codigo = null;
        this.identificacion = null;
        this.estado = null;
        this.direccion = null;
        this.cedulaEncargado = null;
        this.fechaCreacion = null;
        this.pisos = null;
        this.encargados = null;
        this.arrendatarios = null;
    }

    public Edificio(String codigo, String identificacion, String estado, 
            String direccion, String cedulaEncargado, LocalDate fechaCreacion) {
        this.codigo = codigo;
        this.identificacion = identificacion;
        this.estado = estado;
        this.direccion = direccion;
        this.cedulaEncargado = cedulaEncargado;
        this.fechaCreacion = fechaCreacion;
        this.pisos = new ListaEnlazada<>();
        this.encargados = new ListaEnlazada<>();
        this.arrendatarios = new ListaEnlazada<>();
    }
    
    public void agregarEncargado(Encargado nuevoEncargado){
        this.getEncargados().insertarFin(nuevoEncargado);
    }
    
    public void agregarPisos(Piso nuevoPiso){
       Nodo<Piso> nuevo = new Nodo<>(nuevoPiso);
       ListaEnlazada<Piso> listaPisos = this.getPisos();
       if (listaPisos.estaVacio()){
           listaPisos.setInicio(nuevo);
           listaPisos.setFin(nuevo);
       }
       else{
           Nodo<Piso> auxiliar = this.getPisos().getInicio();
           if(nuevoPiso.getNumeroPiso() < auxiliar.getInfo().getNumeroPiso()){
               nuevo.setSiguiente(auxiliar);
               listaPisos.setInicio(nuevo);
           }
           else{
                while(nuevoPiso.getNumeroPiso() > auxiliar.getInfo().getNumeroPiso()){
                    auxiliar = auxiliar.getSiguiente();
                }
           
                if (auxiliar.getInfo().equals(nuevoPiso.getNumeroPiso())){
                    System.out.println("Ya existe unedificio con este código");
                }
                else{
                    if (auxiliar.getInfo().equals(listaPisos.getFin().getInfo())){
                        auxiliar.setSiguiente(nuevo);
                        listaPisos.setFin(nuevo);
                    }
                    else{
                        nuevo.setSiguiente(auxiliar.getSiguiente());
                        auxiliar.setSiguiente(nuevo);
                    }
                }
           }
       }
    }
    
    public void agregarArrendatario(Arrendado nuevoArrendado){
        this.getArrendatarios().insertarFin(nuevoArrendado);
    }
    
    // COMPARACIONES
    
    @Override
    public boolean equals(Object busqueda){
        return this.getCodigo().compareTo((String) busqueda) == 0;
    }
    
    // MOSTRAR
    
    @Override
    public String toString(){
        return "Código del edificio: " + this.getCodigo() + 
                "\nNombre del edificio: " + this.getIdentificacion() + 
                "\nEstado: " + this.getEstado() + 
                "\nDirrecion del edificio: " + this.getDireccion() +
                "\nEncargado del edificio: " + this.getCedulaEncargado() +
                "\nFecha de creación: " + this.getFechaCreacion();
    }
    
    // GETTER Y SETTER

    /**
     *
     * @return
     */
    
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     *
     * @param identificacion
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     *
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     *
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     *
     * @param fechaCreacion
     */
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     *
     * @return
     */
    public ListaEnlazada<Piso> getPisos() {
        return pisos;
    }

    /**
     *
     * @return
     */
    public ListaEnlazada<Encargado> getEncargados() {
        return encargados;
    }

    /**
     *
     * @return
     */
    public ListaEnlazada<Arrendado> getArrendatarios() {
        return arrendatarios;
    }
    
    public static void main(String args[]){
        Edificio nuevoEdificio = new Edificio("1", "Sunsol", "Nueva Esparta", 
                "Porlamar, Calle Zamora", "29582382", LocalDate.now());
        
        System.out.println(nuevoEdificio.toString());
    }
}

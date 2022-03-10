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
public class Empresa {
    private ListaEnlazada<Edificio> edificios;
    private ListaEnlazada<Encargado> encargados;
    private ListaEnlazada<Arrendado> arrendatarios;
    
    public Empresa() {
        this.edificios = new ListaEnlazada<>();
        this.encargados = new ListaEnlazada<>();
        this.arrendatarios = new ListaEnlazada<>();
    }
    
    // MOSTRAR
    
    @Override
    public String toString(){
        String edificiosStr = "";
        Nodo<Edificio> edificio = this.getEdificios().getInicio();
        while(edificio != null){
            edificiosStr = edificiosStr + edificio.getInfo().toString()+ "\n=========================================\n";
            edificio = edificio.getSiguiente();
        }
        return edificiosStr;
    }
    
    public void agregarEdificios(Edificio nuevoEdificio){
       Nodo<Edificio> nuevo = new Nodo<>(nuevoEdificio);
       ListaEnlazada<Edificio> listaEdificios = this.getEdificios();
       if (listaEdificios.estaVacio()){
           listaEdificios.setInicio(nuevo);
           listaEdificios.setFin(nuevo);
       }
       else{
           Nodo<Edificio> auxiliar = listaEdificios.getInicio();
           if(nuevoEdificio.getCodigo().compareTo(auxiliar.getInfo().getCodigo()) < 0){
               nuevo.setSiguiente(auxiliar);
               listaEdificios.setInicio(nuevo);
           }
           else{
                while(nuevoEdificio.getCodigo().equals(auxiliar.getInfo().getCodigo())){
                    auxiliar = auxiliar.getSiguiente();
                }
           
                if (auxiliar.getInfo().getCodigo().equals(nuevoEdificio.getCodigo())){
                    System.out.println("Ya existe un edificio con este código");
                }
                else{
                    if (auxiliar.getInfo().equals(listaEdificios.getFin().getInfo())){
                        auxiliar.setSiguiente(nuevo);
                        listaEdificios.setFin(nuevo);
                    }
                    else{
                        nuevo.setSiguiente(auxiliar.getSiguiente());
                        auxiliar.setSiguiente(nuevo);
                    }
                }
           }
       }
    }
    
    public void agregarEncargado(Encargado nuevoEncargado){
        this.getEncargados().insertarFin(nuevoEncargado);
    }
    
    public void agregarArrendatario(Arrendado nuevoArrendado){
        this.getArrendatarios().insertarFin(nuevoArrendado);
    }
    
    
    
    // GETTER Y SETTER
    
    /**
     *
     * @return
     */

    public ListaEnlazada<Edificio> getEdificios() {
        return edificios;
    }

    public ListaEnlazada<Encargado> getEncargados() {
        return encargados;
    }

    public ListaEnlazada<Arrendado> getArrendatarios() {
        return arrendatarios;
    }
    
    public static void main(String args[]){
        Edificio nuevoEdificio = new Edificio("1", "Sunsol", "Nueva Esparta", 
                "Porlamar, Calle Zamora", "29582382", LocalDate.now());
        Edificio nuevoEdificio2 = new Edificio("2", "Las Putas", "Nueva Esparta", 
                "Porlamar, Calle Zamora", "3889777", LocalDate.now());
        Empresa nuevaEmpresa = new Empresa();
        
        nuevaEmpresa.getEdificios().insertarFin(nuevoEdificio);
        nuevaEmpresa.getEdificios().insertarFin(nuevoEdificio2);
        
        System.out.println(nuevaEmpresa.toString());
    }
}

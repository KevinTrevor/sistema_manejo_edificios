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
    
    public Empresa() {
        this.edificios = new ListaEnlazada<>();
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
    
    public void agregarEdificio(Edificio nuevoEdificio){
        
    }
    
    // GETTER Y SETTER
    
    /**
     *
     * @return
     */

    public ListaEnlazada<Edificio> getEdificios() {
        return edificios;
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

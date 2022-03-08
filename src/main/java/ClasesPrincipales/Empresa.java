/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesPrincipales;

import Lista.*;

/**
 *
 * 
 */
public class Empresa {
    private ListaEnlazada<Edificio> edificios;
    
    public Empresa() {
        this.edificios = new ListaEnlazada<>();
    }
    
    public void agregarEdificio(Edificio nuevoEdificio){
        this.getEdificios().insertar(nuevoEdificio);
    }
    
    // GETTER Y SETTER
    
    /**
     *
     * @return
     */

    public ListaEnlazada<Edificio> getEdificios() {
        return edificios;
    }
    
    
}

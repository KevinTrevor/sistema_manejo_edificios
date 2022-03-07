/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

/**
 *
 * 
 * @param <E>
 */
public class Nodo <E>{
    public E info;
    public Nodo siguiente;

    /**
     *
     * @param info
     */
    public Nodo(E info) {
        this.info = info;
        this.siguiente = null;
    }
    
    // GETTER Y SETTER
    
    /**
     *
     * @return
     */
    public E getInfo() {
        return info;
    }

    /**
     *
     * @param info
     */
    public void setInfo(E info) {
        this.info = info;
    }

    /**
     *
     * @return
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     *
     * @param siguiente
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

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
public class ListaEnlazada <E>{
    public Nodo<E> inicio;
    public Nodo<E> fin;

    /**
     *
     */
    public ListaEnlazada() {
        this.inicio = null;
        this.fin = null;
    }
    
    public boolean estaVacio(){
        return this.inicio == null;
    }
    /**
     *
     * @param dato
     */
    public void insertarInicio(E dato){
        Nodo<E> nuevo = new Nodo(dato);
        
        if (this.estaVacio()){
            this.setInicio(nuevo);
            this.setFin(nuevo);
        }
        else{
            nuevo.setSiguiente(this.getInicio());
            this.setInicio(nuevo);
        }
    }
    
    /**
     *
     * @param dato
     */
    public void insertarFin(E dato){
        Nodo<E> nuevo = new Nodo(dato);
        
        if (this.estaVacio()){
            this.setInicio(nuevo);
            this.setFin(nuevo);
        }
        else{
            this.getFin().setSiguiente(nuevo);
            this.setFin(nuevo);
        }
    }
    
    /**
     *
     * 
     */
    public void eliminarInicio(){
        if (this.estaVacio()){
            System.out.println("La lista esta vacía.");
        }
        else{
            Nodo<E> auxiliar = this.getInicio().getSiguiente();
            this.getInicio().setSiguiente(null);
            this.setInicio(auxiliar);
        }
    }
    
    /**
     *
     */
    public void eliminarFin(){
        if (this.estaVacio()){
            System.out.println("La lista esta vacía.");
        }
        else{
            Nodo<E> auxiliar = this.getInicio();
            
            while(auxiliar.getSiguiente() != this.getFin()){
                auxiliar = auxiliar.getSiguiente();
            }
            
            auxiliar.setSiguiente(null);
            this.setFin(auxiliar);
        }
    }
    
    // GETTER Y SETTER
    
    /**
     *
     * @return
     */
    public Nodo getInicio() {
        return inicio;
    }

    /**
     *
     * @param inicio
     */
    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    /**
     *
     * @return
     */
    public Nodo getFin() {
        return fin;
    }

    /**
     *
     * @param fin
     */
    public void setFin(Nodo fin) {
        this.fin = fin;
    }
    
    
}

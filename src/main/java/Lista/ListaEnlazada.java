/**
* Hecho por: Ruben Fuentes 26.326.992 y Alexander Noriega 27.280.176
* Carrera: Informática
* Materia: Algoritmos y Estructuras de Datos II
*/
package Lista;
import ClasesPrincipales.*;
import java.util.LinkedList;

/**
 *
 * 
 * @param <E>
 */
public class ListaEnlazada <E> {
    private Nodo<E> inicio, fin;
    private int size;
    
    /**
     *
     */
    public ListaEnlazada() {
        this.inicio = null;
        this.fin = null;
        this.size = 0;
    }
    
    public boolean estaVacio(){
        return this.size == 0;
    }
    
    /**
     *
     * @param dato
     */
    public void eliminarDato(Object dato){ 
        if (this.estaVacio()){
            System.out.println("La lista esta vacía.");
        }
        else{
            Nodo<E> auxiliar = this.getInicio();
            Nodo<E> previo = null;
            
            if(auxiliar.getInfo().equals(dato)){
                this.setInicio(auxiliar.getSiguiente());
                auxiliar.setSiguiente(null);
                this.size--;
            }
            else{
                while(!auxiliar.getInfo().equals(dato) && auxiliar.getSiguiente() != null){
                    previo = auxiliar;
                    auxiliar = auxiliar.getSiguiente();
                }
                
                if (!auxiliar.getInfo().equals(dato)){
                    System.out.println("No se encontró el registro a eliminar.");
                }
                else{ 
                    if (this.getFin().getInfo().equals(dato)){
                        previo.setSiguiente(null);
                        this.setFin(previo);
                    }
                    else{
                        previo.setSiguiente(auxiliar.getSiguiente());
                        auxiliar.setSiguiente(null);
                    }
                    this.size--;
                }
            }
        }
    }
    
    /**
     *
     * @param dato
     * @return
     */
    public E buscarDato(Object dato){
        E datoEncontrado = null;
        if (this.estaVacio()){
            System.out.println("La lista esta vacía.");
        }
        else{
            Nodo<E> auxiliar = this.getInicio();
            while(!auxiliar.getInfo().equals(dato) && auxiliar.getSiguiente() != null){
                auxiliar = auxiliar.getSiguiente();
            }  
            
            if (!auxiliar.getInfo().equals(dato)){
                System.out.println("No se encontró el registro.");
            }
            else{
                datoEncontrado = auxiliar.getInfo();
            }
        }
        
        return datoEncontrado;
    }
    
    /**
     *
     * @param dato
     * @param nuevoRegistro
     */
    public void modificarDato(Object dato, E nuevoRegistro){
        if (this.estaVacio()){
            System.out.println("La lista esta vacía.");
        }
        else{
            Nodo<E> auxiliar = this.getInicio();
            while(!auxiliar.getInfo().equals(dato) && auxiliar.getSiguiente() != null){
                auxiliar = auxiliar.getSiguiente();
            }
            
            if (!auxiliar.getInfo().equals(dato)){
                System.out.println("No se encontró el registro a modificar.");
            }
            else{
                auxiliar.setInfo(nuevoRegistro);
            }
        }
    }
    
    /**
     *
     * @param dato
     */
    public void insertarInicio(E dato){
        Nodo<E> nuevo = new Nodo<>(dato);
        
        if (this.estaVacio()){
            this.setInicio(nuevo);
            this.setFin(nuevo);
            size++;
        }
        else{
            nuevo.setSiguiente(this.getInicio());
            this.setInicio(nuevo);
            size++;
        }
    }
    
    /**
     *
     * @param dato
     */
    public void insertarFin(E dato){
        Nodo<E> nuevo = new Nodo<>(dato);
        
        if (this.estaVacio()){
            this.setInicio(nuevo);
            this.setFin(nuevo);
            size++;
        }
        else{
            this.getFin().setSiguiente(nuevo);
            this.setFin(nuevo);
            this.size++;
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
            this.size--;
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
            this.size--;
        }
    }
    
    // GETTER Y SETTER
    
    /**
     *
     * @return
     */
    public Nodo<E> getInicio() {
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
    public Nodo<E> getFin() {
        return fin;
    }

    /**
     *
     * @param fin
     */
    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    /**
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }
}

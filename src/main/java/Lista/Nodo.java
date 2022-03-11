/**
* Hecho por: Ruben Fuentes 26.326.992 y Alexander Noriega 27.280.176
* Carrera: Informática
* Materia: Algoritmos y Estructuras de Datos II
*/
package Lista;

/**
 *
 * 
 * @param <E>
 */
public class Nodo <E>{
    private E info;
    private Nodo<E> siguiente;

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
    public Nodo<E> getSiguiente() {
        return siguiente;
    }

    /**
     *
     * @param siguiente
     */
    public void setSiguiente(Nodo<E> siguiente) {
        this.siguiente = siguiente;
    }
}

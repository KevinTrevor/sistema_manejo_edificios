/**
* Hecho por: Ruben Fuentes 26.326.992 y Alexander Noriega 27.280.176
* Carrera: Informática
* Materia: Algoritmos y Estructuras de Datos II
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

    public Edificio() {
        this.codigo = null;
        this.identificacion = null;
        this.estado = null;
        this.direccion = null;
        this.cedulaEncargado = null;
        this.fechaCreacion = null;
        this.pisos = null;
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
    }
    
    // INSERTAR
    
    public void agregarPisos(Piso nuevoPiso){
       Nodo<Piso> nuevo = new Nodo<>(nuevoPiso);
       ListaEnlazada<Piso> listaPisos = this.getPisos();
       if (listaPisos.estaVacio()){
           listaPisos.setInicio(nuevo);
           listaPisos.setFin(nuevo);
           listaPisos.setSize(listaPisos.getSize() + 1);
       }
       else{
           Nodo<Piso> auxiliar = this.getPisos().getInicio();
           if(nuevoPiso.getNumeroPiso() < auxiliar.getInfo().getNumeroPiso()){
               nuevo.setSiguiente(auxiliar);
               listaPisos.setInicio(nuevo);
               listaPisos.setSize(listaPisos.getSize() + 1);
           }
           else{
                while(nuevoPiso.getNumeroPiso() > auxiliar.getInfo().getNumeroPiso() && auxiliar.getSiguiente() != null){
                    auxiliar = auxiliar.getSiguiente();
                }
           
                if (auxiliar.getInfo().getNumeroPiso().equals(nuevoPiso.getNumeroPiso())){
                    System.out.println("Ya existe un piso con este número.");
                }
                else{
                    if (auxiliar.getInfo().getNumeroPiso().equals(listaPisos.getFin().getInfo().getNumeroPiso())){
                        auxiliar.setSiguiente(nuevo);
                        listaPisos.setFin(nuevo);
                    }
                    else{
                        nuevo.setSiguiente(auxiliar.getSiguiente());
                        auxiliar.setSiguiente(nuevo);
                    }
                    listaPisos.setSize(listaPisos.getSize() + 1);
                }
           }
       }
    }
    
    public void agregarLocal(Integer numeroPiso, Local nuevoLocal){
        Piso pisoBuscado = this.getPisos().buscarDato(numeroPiso);
        if (pisoBuscado != null) {
            pisoBuscado.agregarLocal(nuevoLocal);
        }
    }
    
    public void agregarPagoLocalEnMes(Integer numeroPiso, String codigoLocal,
            Pago nuevoPago){
        
        Piso pisoBuscado = this.getPisos().buscarDato(numeroPiso);
        if (pisoBuscado != null) {
            pisoBuscado.agregarPagoLocalEnMes(codigoLocal, nuevoPago);
        }
    }
    
    // COMPARACIONES
    
    @Override
    public boolean equals(Object busqueda){
        return this.getCodigo().compareTo((String) busqueda) == 0;
    }
    
    // MODIFICAR
    
    public void modificarLocal(Integer numeroPiso, String codigoLocal, String cedulaArrendatario, 
            Float montoMensualidad){
        
        Piso pisoBuscado = this.getPisos().buscarDato(numeroPiso);
        if (pisoBuscado != null) {
            pisoBuscado.modificarLocal(codigoLocal, cedulaArrendatario, montoMensualidad);
            this.getPisos().modificarDato(numeroPiso, pisoBuscado);
        }
    }
    
    public void modificarPiso(Integer numeroPiso, String cedulaEncargado, 
            LocalDate fechaRegistro){
        
        Piso pisoBuscado = this.getPisos().buscarDato(numeroPiso);
        if (pisoBuscado != null) {
            pisoBuscado.modificarPiso(cedulaEncargado, fechaRegistro);
            this.getPisos().modificarDato(numeroPiso, pisoBuscado);
        }
    }
    
    public void modificarEdificio(String identificacion, String estado, 
            String direccion, String cedulaEncargado, LocalDate fechaCreacion){
        this.setIdentificacion(identificacion);
        this.setEstado(estado);
        this.setDireccion(direccion);
        this.setCedulaEncargado(cedulaEncargado);
        this.setFechaCreacion(fechaCreacion);
    }
    
    // ELIMINAR
    
    public void eliminarPiso(Integer numeroPiso){
        this.getPisos().eliminarDato(numeroPiso);
        
    }
    
    // MOSTRAR
    
    @Override
    public String toString(){
        return "Código del edificio: " + this.getCodigo() + 
                "\nNombre del edificio: " + this.getIdentificacion() + 
                "\nEstado: " + this.getEstado() + 
                "\nDirrecion del edificio: " + this.getDireccion() +
                "\nEncargado del edificio: " + this.getCedulaEncargado() +
                "\nFecha de creación: " + this.getFechaCreacion() +
                "\nNumero de pisos: " + this.getNumeroPisos() +
                "\nNúmero de locales: " +this.getNumeroLocales() ;
    }
    
    public String mostrarLocalPorCodigo(Integer numeroPiso, String codigoLocal){
        String localStr = "";
        Piso pisoBuscado = this.getPisos().buscarDato(numeroPiso);
        if (pisoBuscado != null) {
            localStr = pisoBuscado.mostrarLocalPorCodigo(codigoLocal);
        }
        return localStr;
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
        return this.fechaCreacion;
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
        return this.pisos;
    }
    
    public Float getMontoEnMes(String mes){
        Float montoRecaudado = new Float(0);
        Nodo<Piso> nodoPiso = this.getPisos().getInicio();
        while(nodoPiso != null){
            montoRecaudado = montoRecaudado + nodoPiso.getInfo().getMontoEnMes(mes);
            nodoPiso = nodoPiso.getSiguiente();
        }
        return montoRecaudado;
    }
    
    public Float getRestanteEnMes(String mes){
        Float montoRestante = new Float(0);
        Nodo<Piso> nodoPiso = this.getPisos().getInicio();
        while(nodoPiso != null){
            montoRestante = montoRestante + nodoPiso.getInfo().getRestanteEnMes(mes);
            nodoPiso =  nodoPiso.getSiguiente();
        }
        return montoRestante;
    }
    
    public int getNumeroLocales(){
        int totalLocales = 0;
        Nodo<Piso> piso = this.getPisos().getInicio();
        while(piso != null){
            totalLocales = totalLocales + piso.getInfo().getNumeroLocales();
            piso = piso.getSiguiente();
        }
        return totalLocales;
    }
    
    /**
    *
    * @return
    */
    public int getLocalesMontoMenorA(Integer monto) {
    	Nodo<Piso> piso = this.getPisos().getInicio();
    	Integer contador = 0;
    	while(piso != null) {
    		contador += piso.getInfo().getLocalesMenorA(monto);
    		piso = piso.getSiguiente();
    	}
    	
    	return contador;
    }
    
    public int getNumeroLocalesPagosEnMes(String mes){
        int totalLocales = 0;
        Nodo<Piso> piso = this.getPisos().getInicio();
        while (piso != null){
            totalLocales = totalLocales + piso.getInfo().getLocalesPagadosEnMes(mes);
            piso = piso.getSiguiente();
        }
        return totalLocales;
    }
    
    public int getNumeroPisos(){
        return this.getPisos().getSize();
    }
    
    public String getCedulaEncargadoPiso(Integer numeroPiso){
        String cedulaEncontrada = "";
        Piso pisoBuscado = this.getPisos().buscarDato(numeroPiso);
        if (pisoBuscado != null){
            cedulaEncontrada = pisoBuscado.getCedulaEncargado();
        }
        return cedulaEncontrada;
    }
    
    public String getCedulaArrendatarioLocal(Integer numeroPiso, String codigoLocal){
        String cedulaEncontrada = "";
        Piso pisoBuscado = this.getPisos().buscarDato(numeroPiso);
        if (pisoBuscado != null){
            cedulaEncontrada = pisoBuscado.getCedulaArrendatarioLocal(codigoLocal);
        }
        return cedulaEncontrada;
    }
}
